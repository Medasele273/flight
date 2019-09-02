package se.lexicon.flight.dao;

import se.lexicon.flight.domain.Airline;

import java.util.List;

public interface AirlineDao {

    void addAirline(Airline airline);

    Airline searchAirlineByName(String airlineName);

    void removeAirlineByAirlineName(String airlineName);

    List<Airline> getAirlines();
}
