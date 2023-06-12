package com.gridnine.testing;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Flight> flights = FlightBuilder.createFlights();
        FlightFilter departureBeforeNow = new DepartureBeforeNow();
        FlightFilter arrivalBeforeDeparture = new ArrivalBeforeDeparture();
        FlightFilter groundTimeExceedsTwoHours = new GroundTimeExceedsTwoHours();

        FlightFilterProcessor processor = new FlightFilterProcessor(Arrays.asList(
                departureBeforeNow,
                arrivalBeforeDeparture,
                groundTimeExceedsTwoHours));

        List<Flight> filteredFlights = processor.filterFlights(flights);

        System.out.println("Filtered flights:");
        for (Flight flight : filteredFlights) {
            System.out.println(flight);
        }
    }
}