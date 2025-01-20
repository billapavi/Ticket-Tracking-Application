package com.application.trackingapi.service;

import com.application.trackingapi.entity.TrackingNumber;
import com.application.trackingapi.repository.TrackingNumberRepository;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.UUID;

@Service
public class TrackingNumberService {

    private final TrackingNumberRepository trackingNumberRepository;

    public TrackingNumberService(TrackingNumberRepository trackingNumberRepository) {
        this.trackingNumberRepository = trackingNumberRepository;
    }

    public String generateTrackingNumber(String origin, String destination, String weight, String createdAt,
                                         String customerId, String customerName, String customerSlug) {
        String base = origin + destination + weight + customerId;
        String uniqueHash = UUID.nameUUIDFromBytes(base.getBytes()).toString().toUpperCase().replaceAll("-", "");

        String trackingNumber = uniqueHash.substring(0, Math.min(uniqueHash.length(), 16));
        while (trackingNumberRepository.existsByTrackingNumber(trackingNumber)) {
            trackingNumber = UUID.randomUUID().toString().toUpperCase().replaceAll("-", "").substring(0, 16);
        }

        TrackingNumber entity = new TrackingNumber(trackingNumber, ZonedDateTime.now());
        trackingNumberRepository.save(entity);

        return trackingNumber;
    }
}
