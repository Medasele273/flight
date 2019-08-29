package se.lexicon.flight.service;

import se.lexicon.flight.domain.Airline;

import java.util.List;

public interface AirlineService {

    void addAirline(Airline airline);

    Airline getAirline(String id);

    void removeAirline(String id);

    List<Airline> getAirlines();
}
