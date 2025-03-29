package com.telemetry.info;

import com.telemetry.info.avro.CabLocationFeed;
import com.telemetry.info.avro.CabLocationSpeed;
import org.apache.kafka.streams.KeyValue;
import org.apache.kafka.streams.kstream.Transformer;
import org.apache.kafka.streams.kstream.TransformerSupplier;
import org.apache.kafka.streams.processor.ProcessorContext;
import org.apache.kafka.streams.state.KeyValueStore;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HaversineTransformerSupplier implements TransformerSupplier<String, CabLocationFeed, KeyValue<String, CabLocationSpeed>> {

    private static final Logger LOG = LoggerFactory.getLogger(HaversineTransformerSupplier.class);

    public String busPositionStoreName;

    public HaversineTransformerSupplier(String busPositionStoreName) {
        this.busPositionStoreName = busPositionStoreName;
    }


    @Override
    public Transformer<String, CabLocationFeed, KeyValue<String, CabLocationSpeed>> get() {
        return new Transformer<String, CabLocationFeed, KeyValue<String, CabLocationSpeed>>() {

            private KeyValueStore<String, CabLocationFeed> busPositionStore;

            @SuppressWarnings("unchecked")
            @Override
            public void init(final ProcessorContext context) {
                busPositionStore = (KeyValueStore<String, CabLocationFeed>) context.getStateStore(busPositionStoreName);
            }

            @Override
            public KeyValue<String, CabLocationSpeed> transform(final String dummy, final CabLocationFeed busPosition) {

                CabLocationFeed previousBusPosition = busPositionStore.get(String.valueOf(busPosition.getId()));

                System.out.println("PREV POS: lat "+ previousBusPosition.getLocation().getLat() + " lon + " + previousBusPosition.getLocation().getLon());


                CabLocationSpeed busPositionSpeed = new CabLocationSpeed();
                busPositionSpeed.setId(busPosition.getId());
                busPositionSpeed.setTimestamp(busPosition.getTimestamp());
                busPositionSpeed.setLocation(busPosition.getLocation());
                busPositionSpeed.setBearing(busPosition.getBearing());
                busPositionSpeed.setMilesPerHour(0);

                // if there is a previous location for that bus ID, calculate the speed based on its previous position/timestamp.
                if (previousBusPosition != null) {

                    // calculate distance and time between last two measurements
                    HaversineDistanceCalculator haversineDistanceCalculator = new HaversineDistanceCalculator();
                    double distanceKm = haversineDistanceCalculator.calculateDistance(
                            previousBusPosition.getLocation().getLat(),
                            previousBusPosition.getLocation().getLon(),
                            busPosition.getLocation().getLat(),
                            busPosition.getLocation().getLon()); // distance is in kilometers

                    long timeDeltaMillis = busPosition.getTimestamp() - previousBusPosition.getTimestamp();
                    double milesPerHour = calculateMilesPerHour(distanceKm * 1000, timeDeltaMillis / 1000);
                    busPositionSpeed.setMilesPerHour(milesPerHour);

                }

                busPositionStore.put(String.valueOf(busPosition.getId()), busPosition);

                return new KeyValue<>(String.valueOf(busPosition.getId()), busPositionSpeed);

            }

            @Override
            public void close() {
            }

        };
    }

    private static double calculateMilesPerHour(double meters, long seconds) {
        if (seconds == 0) {
            return 0;
        } else {
            double metersPerSecond = meters / seconds;
            return metersPerSecond * 2.2369;
        }
    }
}
