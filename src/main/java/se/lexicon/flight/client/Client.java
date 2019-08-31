package se.lexicon.flight.client;

import se.lexicon.flight.domain.Airline;
import se.lexicon.flight.domain.Flight;

public interface Client {

    Airline searchAirlineByName(String airlineName);

    Flight searchFlightByFlightNo(String flightNo);
}
