package com.telemetry.info;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class IotTelemetryApplication {

	public static void main(String[] args) {
		SpringApplication.run(IotTelemetryApplication.class, args);
	}

}
