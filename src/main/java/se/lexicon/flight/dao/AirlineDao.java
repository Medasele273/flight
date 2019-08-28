package se.lexicon.flight.dao;

import se.lexicon.flight.domain.Airline;

import java.util.List;

public interface AirlineDao {

    void addAirline(Airline airline);

    Airline getAirline(String id);

    void deleteAirline(Airline airline);

    List<Airline> getAirlines();
}
