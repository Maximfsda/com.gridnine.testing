package com.gridnine.testing;

import java.time.LocalDateTime;

public class Segment {
    private final LocalDateTime departureDate;
    private final LocalDateTime arrivalDate;

    public Segment(LocalDateTime dep, LocalDateTime arr) {
        departureDate = dep;
        arrivalDate = arr;
    }

    public LocalDateTime getDepartureDate() {
        return departureDate;
    }

    public LocalDateTime getArrivalDate() {
        return arrivalDate;
    }

    @Override
    public String toString() {
        return "Segment{" +
                "depDate=" + departureDate +
                ", arrDate=" + arrivalDate +
                '}';
    }
}
