package com.example.cab_location.service;

import com.example.cab_location.model.Location;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class CabTrackingService {

    private final Map<String, Location> cabLocations = new ConcurrentHashMap<>();
    private final Random random = new Random();

    // Define Delhi's rough latitude and longitude boundaries
    private static final double MIN_LAT = 28.4042, MAX_LAT = 28.8833;
    private static final double MIN_LON = 76.8370, MAX_LON = 77.3490;

    public CabTrackingService() {
        // Initialize 10 cabs with random locations in Delhi
        for (int i = 1; i <= 10; i++) {
            cabLocations.put("Cab-" + i, getRandomLocation(i));
        }
    }

    // Generate a random location within Delhi
    private Location getRandomLocation(int id) {
        double latitude = MIN_LAT + (MAX_LAT - MIN_LAT) * random.nextDouble();
        double longitude = MIN_LON + (MAX_LON - MIN_LON) * random.nextDouble();
        return new Location(id, Calendar.getInstance().getTimeInMillis(), latitude, longitude);
    }

    // Simulate cab movement every 1 seconds
    @Scheduled(fixedRate = 1000)
    public void updateCabLocations() {
        for (String cab : cabLocations.keySet()) {
            Location location = cabLocations.get(cab);
            location.setLatitude(location.getLatitude() + (random.nextDouble() - 0.5) * 0.01); // Small latitude shift
            location.setLongitude(location.getLongitude() + (random.nextDouble() - 0.5) * 0.01); // Small longitude shift
            cabLocations.put(cab, location);
        }
    }

    // Get all cab locations
    public Map<String, Location> getAllCabLocations() {
        return cabLocations;
    }

    // Get specific cab location
    public Location getCabLocation(String cabId) {
        Random random = new Random();
        int id = random.nextInt(1_000_000) + 1;
        return cabLocations.getOrDefault(cabId, getRandomLocation(id));
    }

}
