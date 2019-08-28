package se.lexicon.flight.dao;

import se.lexicon.flight.domain.Passenger;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class PassengerDaoImpl implements PassengerDao {

     private Map<String,Passenger> passengers =new HashMap<>();
    
    @Override
    public void addPassenger(Passenger passenger) {
        if(passengers.containsKey(passenger.getPassengerId())){
            throw new RuntimeException("Passenger is Exist");
        }

        passengers.put(passenger.getPassengerId(),passenger);

    }

    @Override
    public Optional<Passenger> read(String passengerId) {
        return Optional.ofNullable(passengers.get(passengerId));
    }

    @Override
    public Passenger searchAndGetPassenger(String passengerId) {
       return passengers.get(passengerId);
    }
}
