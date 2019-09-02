package se.lexicon.flight.client;

import se.lexicon.flight.domain.Airline;
import se.lexicon.flight.domain.Flight;
import se.lexicon.flight.domain.Ticket;

import java.util.Collection;

public interface Client {

    Airline searchAirlineByName(String airlineName);

    Collection<Flight>searchFlightByAirlineName(String airlineName);

    Collection<Flight> searchFlightByCityAndDate(String fromCity,String toCity,String departureDate);

     void book(Ticket ticket);

}
