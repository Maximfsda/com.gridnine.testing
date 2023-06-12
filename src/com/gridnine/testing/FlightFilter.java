package com.gridnine.testing;

import java.time.LocalDateTime;
import java.util.List;

public interface FlightFilter {
    List<Flight> filter(List<Flight> flights);
}

class DepartureBeforeNow implements FlightFilter {
    @Override
    public List<Flight> filter(List<Flight> flights) {
        LocalDateTime now = LocalDateTime.now();
        flights.removeIf(flight -> flight.getSegments().get(0).getDepartureDate().isBefore(now));
        return flights;
    }
}

class ArrivalBeforeDeparture implements FlightFilter {
    @Override
    public List<Flight> filter(List<Flight> flights) {
        flights.removeIf(flight ->
                flight.getSegments().stream().anyMatch(segment ->
                        segment.getArrivalDate().isBefore(segment.getDepartureDate())));
        return flights;
    }
}

class GroundTimeExceedsTwoHours implements FlightFilter {
    @Override
    public List<Flight> filter(List<Flight> flights) {
        flights.removeIf(flight -> {
            int groundTime = 0;
            List<Segment> segments = flight.getSegments();
            for (int i = 0; i < segments.size() - 1; i++) {
                Segment currentSegment = segments.get(i);
                Segment nextSegment = segments.get(i + 1);
                groundTime += currentSegment.getArrivalDate().until(nextSegment.getDepartureDate()).toHours();
            }
            return groundTime > 2;
        });
        return flights;
    }
}
