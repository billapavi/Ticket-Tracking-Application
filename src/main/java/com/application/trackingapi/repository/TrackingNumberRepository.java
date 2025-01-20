package com.application.trackingapi.repository;

import com.application.trackingapi.entity.TrackingNumber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrackingNumberRepository extends JpaRepository<TrackingNumber, Long> {

    boolean existsByTrackingNumber(String trackingNumber);
}
