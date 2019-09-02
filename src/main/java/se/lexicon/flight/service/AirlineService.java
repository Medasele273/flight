package se.lexicon.flight.service;

import se.lexicon.flight.domain.Airline;

import java.util.List;

public interface AirlineService {

    void addAirline(Airline airline);

    Airline searchAirlineByName(String airlineName);

    void removeAirlineByAirlineName(String airlineName);

    List<Airline> getAirlines();
}
