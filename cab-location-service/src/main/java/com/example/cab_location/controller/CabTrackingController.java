package com.example.cab_location.controller;

import com.example.cab_location.model.Location;
import com.example.cab_location.service.CabTrackingService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Map;

@RestController
@RequestMapping("/api/cabs")
public class CabTrackingController {

    private final CabTrackingService cabTrackingService;

    public CabTrackingController(CabTrackingService cabTrackingService) {
        this.cabTrackingService = cabTrackingService;
    }

    // Get all cab locations
    @GetMapping("/locations")
    public Collection<Location> getAllCabLocations() {
        return cabTrackingService.getAllCabLocations().values();
    }

    // Get a specific cab location
    @GetMapping("/{cabId}/location")
    public Location getCabLocation(@PathVariable String cabId) {
        return cabTrackingService.getCabLocation(cabId);
    }

}
