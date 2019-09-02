package se.lexicon.flight.admin;

import se.lexicon.flight.domain.Airline;
import se.lexicon.flight.domain.Flight;
import se.lexicon.flight.domain.Passenger;
import se.lexicon.flight.domain.Users;

import java.util.Collection;
import java.util.List;

public interface Admin {

    void addAirline(Airline airline);

    Collection<Airline> getAirlines();

    void removeAirlineByAirlineName(String airlineName);

    void addFlight(Flight flight);

    List<Flight> getFlights();

    void cancelFlight(String flightNo);

    Collection<Passenger> getAllPassengers();

    Collection<Users> getAllUsers();

}
