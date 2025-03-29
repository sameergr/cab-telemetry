package com.telemetry.info;

import ch.hsr.geohash.GeoHash;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.telemetry.info.avro.CabLocationFeed;
import com.telemetry.info.avro.CabLocationSpeed;
import com.telemetry.info.avro.Location;
import com.telemetry.info.config.KafkaConfig;
import com.telemetry.info.constants.KafkaConstants;
import com.uber.h3core.H3Core;
import io.confluent.kafka.streams.serdes.avro.SpecificAvroSerde;
import org.apache.avro.Schema;
import org.apache.avro.io.DatumWriter;
import org.apache.avro.io.Encoder;
import org.apache.avro.io.EncoderFactory;
import org.apache.avro.specific.SpecificDatumWriter;
import org.apache.kafka.common.serialization.Serde;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.Topology;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.state.KeyValueStore;
import org.apache.kafka.streams.state.StoreBuilder;
import org.apache.kafka.streams.state.Stores;
import org.rocksdb.Options;
import org.rocksdb.RocksDB;
import org.rocksdb.RocksDBException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.Properties;

/**
 * Hello world!
 */
public class Streamer {

    private static final Logger LOG = LoggerFactory.getLogger(Streamer.class);

    static RocksDB db = getRocksDB();

    public static void main(String[] args) throws InterruptedException {
        StreamsBuilder streamsBuilder = new StreamsBuilder();
        Properties properties = new KafkaConfig().getProperties();

//        properties.put(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.String().getClass());
//        properties.put(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, SpecificAvroSerde.class);

        // BusPosition serializer/deserializer
//        final Serde<CabLocationFeed> serdeBusPosition = new SpecificAvroSerde<>();
//        serdeBusPosition.configure((Map) properties, false);

        // create key/value store for bus positions
//        final StoreBuilder<KeyValueStore<String, CabLocationFeed>> busPositionStore = Stores.keyValueStoreBuilder(
//                Stores.persistentKeyValueStore("busPositionStore"),
//                Serdes.String(),
//                Serdes.serdeFrom(serdeBusPosition.serializer(), serdeBusPosition.deserializer()));

//        streamsBuilder.addStateStore(busPositionStore);

        // create a stream of the raw iris records
        final KStream<String, CabLocationFeed> cabLocationStream = streamsBuilder.stream("live-cab-position");

        // calculate the speed using the Haversine transform
        cabLocationStream.mapValues(Streamer::enrichBusPosition).to("live-cab-position-enriched");

        // run it
        final Topology topology = streamsBuilder.build();
        try (final KafkaStreams streams = new KafkaStreams(topology, properties)) {
            streams.cleanUp();
            streams.start();

            Thread.sleep(5000);

            // Add shutdown hook to respond to SIGTERM and gracefully close Kafka Streams
            Runtime.getRuntime().addShutdownHook(new Thread(streams::close));
        }

    }

    private static RocksDB getRocksDB() {
        RocksDB.loadLibrary();

        final Options options = new Options().setCreateIfMissing(true);

        try {
            String tempDir = System.getProperty("java.io.tmpdir");
            return RocksDB.open(options, tempDir + "\\" + KafkaConstants.APPLICATION_ID);
        } catch (RocksDBException e) {
            LOG.error(e.getMessage());
            return null;
        }
    }

    private static String convertAvroToJson(CabLocationFeed feed) throws Exception {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        Schema schema = feed.getSchema();

        DatumWriter<CabLocationFeed> writer = new SpecificDatumWriter<>(schema);
        Encoder encoder = EncoderFactory.get().jsonEncoder(schema, outputStream);

        writer.write(feed, encoder);
        encoder.flush();
        return outputStream.toString();
    }

    private static CabLocationSpeed enrichBusPosition(CabLocationFeed value) {

        // map record to BusPosition POJO
        ObjectMapper mapper = new ObjectMapper();
        CabLocationSpeed currCabPosition = new CabLocationSpeed();
        currCabPosition.setBearing(value.getBearing());
        currCabPosition.setId(value.getId());
        Location location = new Location();
        location.setLat(value.getLocation().getLat());
        location.setLon(value.getLocation().getLon());
        currCabPosition.setLocation(location);
        currCabPosition.setTimestamp(value.getTimestamp());

        // get previous bus position from RocksDB
        int cabId = currCabPosition.getId();
        CabLocationSpeed previousCabPosition = new CabLocationSpeed();
        String previousCabPositionString;
        try {
            byte[] cabBytes = db.get(String.valueOf(cabId).getBytes(StandardCharsets.UTF_8));
            if (cabBytes != null) {
                previousCabPositionString = new String(cabBytes);
                previousCabPosition = mapper.readValue(previousCabPositionString, CabLocationSpeed.class);
            }
        } catch (RocksDBException | IOException e) {
            LOG.error(e.getMessage());
        }

        // persist current bus position to RocksDB
        try {
            String currentLocationJson = convertAvroToJson(value);
            db.put(String.valueOf(cabId).getBytes(StandardCharsets.UTF_8), currentLocationJson.getBytes(StandardCharsets.UTF_8));
        } catch (RocksDBException e) {
            LOG.error(e.getMessage());
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        // calculate distance and time between last two measurements
        HaversineDistanceCalculator haversineDistanceCalculator = new HaversineDistanceCalculator();
        double distance = haversineDistanceCalculator.calculateDistance(
                previousCabPosition.getLocation() == null ? 0 : previousCabPosition.getLocation().getLat(),
                previousCabPosition.getLocation() == null ? 0 : previousCabPosition.getLocation().getLon(),
                currCabPosition.getLocation().getLat(),
                currCabPosition.getLocation().getLon()); // distance is in kilometers

        long timedelta = currCabPosition.getTimestamp() - previousCabPosition.getTimestamp(); // time delta is in seconds

        // calculate and set miles per hour
        double milesPerHour = calculateMilesPerHour(distance, timedelta);
        currCabPosition.setMilesPerHour(milesPerHour);

        // Geohashed to tiles approx. 150m in size: https://gis.stackexchange.com/questions/115280/what-is-the-precision-of-a-geohash
        GeoHash geohash = GeoHash.withCharacterPrecision(currCabPosition.getLocation().getLat(), currCabPosition.getLocation().getLon(), 7);
        String geohashString = geohash.toBase32();
        currCabPosition.setGeohash(geohashString);

        return currCabPosition;
    }

    private static double calculateMilesPerHour(double meters, long seconds) {
        if (seconds == 0) {
            return 0;
        } else {
            double metersPerSecond = meters * 1000 / seconds;
            return metersPerSecond * 2.2369;
        }
    }
}
