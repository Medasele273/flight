package se.lexicon.flight.dao;

import se.lexicon.flight.domain.Airline;

import java.util.List;

public interface AirlineDao {

    void addAirline(Airline airline);

    Airline searchAirlineByName(String airlineName);

    void removeAirlineById(String id);

    List<Airline> getAirlines();
}
