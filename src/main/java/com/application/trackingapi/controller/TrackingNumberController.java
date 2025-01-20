package com.application.trackingapi.controller;

import com.application.trackingapi.service.TrackingNumberService;
import com.application.trackingapi.util.TrackingNumberResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/api/v1")
public class TrackingNumberController {

    @Autowired
    TrackingNumberService trackingNumberService;


    @GetMapping("/next-tracking-number")
    @Async
    public CompletableFuture<TrackingNumberResponse>getNextTrackingNumber(
            @RequestParam String origin_country_id,
            @RequestParam String destination_country_id,
            @RequestParam String weight,
            @RequestParam String created_at,
            @RequestParam String customer_id,
            @RequestParam String customer_name,
            @RequestParam String customer_slug
    ) {
        String trackingNumber = trackingNumberService.generateTrackingNumber(
                origin_country_id, destination_country_id, weight, created_at, customer_id, customer_name, customer_slug
        );
        ZonedDateTime now = ZonedDateTime.now();
        String timestamp = now.format(DateTimeFormatter.ISO_OFFSET_DATE_TIME);

        TrackingNumberResponse trackingNumberResponse = new TrackingNumberResponse();
        trackingNumberResponse.setTrackingNumber(trackingNumber);
        trackingNumberResponse.setCreatedAt(timestamp);

        return CompletableFuture.completedFuture(trackingNumberResponse);
    }
}
