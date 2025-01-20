package com.application.trackingapi.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TrackingNumber {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String trackingNumber;

    @Column(nullable = false)
    private ZonedDateTime createdAt;

    public TrackingNumber(String trackingNumber, ZonedDateTime now) {
        this.trackingNumber = trackingNumber;
        this.createdAt = now;
    }
}
