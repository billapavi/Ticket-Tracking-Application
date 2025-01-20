package com.application.trackingapi.util;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
public class TrackingNumberResponse {

    private String trackingNumber;

    private String createdAt;

    public String getTrackingNumber() {
        return trackingNumber;
    }

    public void setTrackingNumber(String trackingNumber) {
        this.trackingNumber = trackingNumber;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }
}
