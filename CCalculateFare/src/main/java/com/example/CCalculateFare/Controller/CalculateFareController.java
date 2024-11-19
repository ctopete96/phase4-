package com.example.CCalculateFare.Controller;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Configuration
public class CalculateFareController {

    @GetMapping("/CalculateFare")
    public ResponseEntity<Double> CalculateFare(@RequestParam String fromLocation, @RequestParam String toLocation) {
        if (fromLocation == null || toLocation == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        
        double fare = calculateFareBetweenLocations(fromLocation, toLocation);
        return new ResponseEntity<>(fare, HttpStatus.OK);
    }

    private double calculateFareBetweenLocations(String fromLocation, String toLocation) {
        double baseFare = 5.0;
        double perMileRate = 1.5;
        double distance = getDistance(fromLocation, toLocation);
        return baseFare + (perMileRate * distance);
    }

    private double getDistance(String fromLocation, String toLocation) {
        return 10.0; // Placeholder for distance calculation
    }
}
