package se.lexicon.flight.dao;

import se.lexicon.flight.domain.Passenger;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface PassengerDao {

    void addPassenger(Passenger passenger);

    Optional<Passenger> searchAndGetPassengerById(String passengerId);

 //   Passenger searchAndGetPassenger(String passengerId);

    Collection<Passenger> getPassengers();
}
