package se.lexicon.flight.service;

import se.lexicon.flight.domain.Flight;

import java.util.List;

public interface FlightService {

    void addFlight(Flight flight);

    Flight searchFlightByFlightNo(String flightNO);

    List<Flight> getFlights();
}
