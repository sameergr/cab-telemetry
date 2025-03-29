package com.telemetry.info;

public class HaversineDistanceCalculator {

    final int R = 6371; // Radius of the earth in kilometers

    public Double calculateDistance(Double lat1, Double lon1, Double lat2, Double lon2){
        double latDistance = toRad(lat2-lat1);
        double lonDistance = toRad(lon2-lon1);
        double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2) +
                Math.cos(toRad(lat1)) * Math.cos(toRad(lat2)) *
                        Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));

        return R * c; // in kilometers
    }

    private static Double toRad(Double value) {
        return value * Math.PI / 180;
    }


}
