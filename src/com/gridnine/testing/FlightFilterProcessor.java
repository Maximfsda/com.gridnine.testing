package com.gridnine.testing;

import java.util.ArrayList;
import java.util.List;

public class FlightFilterProcessor {
    private final List<FlightFilter> filters;

    public FlightFilterProcessor(List<FlightFilter> filters) {
        this.filters = filters;
    }

    public List<Flight> filterFlights(List<Flight> flights) {
        List<Flight> filteredFlights = new ArrayList<>(flights);
        for (FlightFilter filter : filters) {
            filteredFlights = filter.filter(filteredFlights);
        }
        return filteredFlights;
    }
}
