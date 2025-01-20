package com.application.trackingapi.util;

import java.util.UUID;

public class TrackingNumberGenerator {

    public static String generateHash(String base) {
        return UUID.nameUUIDFromBytes(base.getBytes()).toString().toUpperCase().replaceAll("-", "");
    }
}
