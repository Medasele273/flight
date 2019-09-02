package se.lexicon.flight.service;

import se.lexicon.flight.domain.Flight;

import java.util.Collection;
import java.util.List;

public interface FlightService {

    void addFlight(Flight flight);

   Collection<Flight> searchFlightByAirlineName(String airlineName);

    Collection<Flight> searchFlightByCityAndDate(String fromCity,String toCity,String departureDate);

    List<Flight> getFlights();
}
