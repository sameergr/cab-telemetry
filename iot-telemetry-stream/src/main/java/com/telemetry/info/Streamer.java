package com.telemetry.info;

import com.telemetry.info.avro.SensorReadingInfluxV1;
import com.telemetry.info.avro.SensorReadingV1;
import com.telemetry.info.avro.TagsRecord;
import com.telemetry.info.config.KafkaConfig;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.KeyValue;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.Topology;
import org.apache.kafka.streams.kstream.KStream;

import java.util.Properties;

/**
 * Hello world!
 *
 */
public class Streamer
{
    public static void main( String[] args )
    {
        StreamsBuilder streamsBuilder = new StreamsBuilder();
        Properties properties = new KafkaConfig().getProperties();

        // create a stream of the raw iris records
        KStream<String, SensorReadingV1> temperatureHumidityStream = streamsBuilder.stream("temperature-humidity");

        temperatureHumidityStream.map((key, value) -> {
            SensorReadingInfluxV1 influxV1 = new SensorReadingInfluxV1();
            influxV1.setCelcius(value.getCelcius());
            influxV1.setHumidity(value.getHumidity());
            influxV1.setMeasurement("temperature-humidity");

            TagsRecord tagsRecord = new TagsRecord();
            tagsRecord.setHost(value.getHost());
            influxV1.setTags(tagsRecord);
            return new KeyValue<>(key, influxV1);
        }).to("temperature-humidity-influx");


        // run it
        final Topology topology = streamsBuilder.build();
        final KafkaStreams streams = new KafkaStreams(topology, properties);
        streams.start();

        // Add shutdown hook to respond to SIGTERM and gracefully close Kafka Streams
        Runtime.getRuntime().addShutdownHook(new Thread(streams::close));

    }
}
