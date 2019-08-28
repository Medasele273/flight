package se.lexicon.flight.dao;

import se.lexicon.flight.domain.Passenger;

import java.util.Optional;

public interface PassengerDao {

    void addPassenger(Passenger passenger);

    Optional<Passenger> read(String passengerId);

    Passenger searchAndGetPassenger(String passengerId);
}
