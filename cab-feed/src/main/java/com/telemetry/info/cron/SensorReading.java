package com.telemetry.info.cron;

import com.telemetry.info.avro.CabLocationFeed;
import com.telemetry.info.avro.Location;
import com.telemetry.info.model.CabPosition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import java.util.List;
import java.util.Optional;

@Component
public class SensorReading {

    @Autowired
    private KafkaTemplate<String, CabLocationFeed> kafkaTemplate;

    @Scheduled(cron = "*/5 * * * * *") // every 2 seconds
    public void readSensorData(){

        String URL = "http://localhost:8089/api/cabs/locations";
        RestClient restClient = RestClient.create();
        List<CabPosition> result = restClient.get().uri(URL).retrieve().body(new ParameterizedTypeReference<List<CabPosition>>() {});

        Optional.ofNullable(result).ifPresent( cabPositions -> {
            // create Avro cab location reading object
            cabPositions.stream().map(this::convertToCabPosition).forEach(cabLocation -> {
                // send Avro message to Kafka
                kafkaTemplate.send("live-cab-position", cabLocation);
            });
        });
    }

    private CabLocationFeed convertToCabPosition(CabPosition cabPosition){
        CabLocationFeed cabLocation = new CabLocationFeed();
        cabLocation.setId(cabPosition.id());
        cabLocation.setTimestamp(cabPosition.timestamp());
        Location location = new Location(cabPosition.longitude(), cabPosition.latitude());
        cabLocation.setLocation(location);
        return cabLocation;
    }


}
