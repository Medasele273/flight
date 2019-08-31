package se.lexicon.flight.admin;

import se.lexicon.flight.domain.Airline;
import se.lexicon.flight.domain.Flight;

public interface Admin {

    void addAirline(Airline airline);

    void removeAirlineById(String airlineId);

    void addFlight (Flight flight);

   // void cancelFlight();

}
