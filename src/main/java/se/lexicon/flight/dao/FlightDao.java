package se.lexicon.flight.dao;

import se.lexicon.flight.domain.Airline;
import se.lexicon.flight.domain.Flight;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface FlightDao {

    void addFlight(Flight flight);

   Flight searchFlight(String flightNo);

    List<Flight> getFlights();
}
