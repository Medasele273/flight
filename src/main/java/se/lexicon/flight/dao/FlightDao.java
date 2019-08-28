package se.lexicon.flight.dao;

import se.lexicon.flight.domain.Flight;

public interface FlightDao {

    void addFlight(Flight flight);

    void searchFlight(String flightNo);
}
