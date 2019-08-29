package se.lexicon.flight.service;

import se.lexicon.flight.domain.Airline;

import java.util.List;

public interface AirlineService {

    void addAirline(Airline airline);

    Airline searchAirlineById(String id);

    void removeAirlineById(String id);

    List<Airline> getAirlines();
}
