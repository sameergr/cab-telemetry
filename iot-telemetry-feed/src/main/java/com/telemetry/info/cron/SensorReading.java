package com.telemetry.info.cron;

import com.telemetry.info.avro.SensorReadingV1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Calendar;

@Component
public class SensorReading {

    @Autowired
    private KafkaTemplate<String, SensorReadingV1> kafkaTemplate;

    @Scheduled(cron = "*/2 * * * * *") // every 2 seconds
    public void readSensorData(){
        // create Avro sensor reading object
        SensorReadingV1 sensorReadingAvro = SensorReadingV1.newBuilder()
                .setHost("0.0.0.1")
                .setTimestamp(Calendar.getInstance().getTimeInMillis())
                .setCelcius(21)
                .setHumidity(11)
                .build();

        // send Avro message to Kafka
        kafkaTemplate.send("temperature-humidity", sensorReadingAvro);
    }

}
