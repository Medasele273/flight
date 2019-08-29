package se.lexicon.flight.daoImpl;

import se.lexicon.flight.dao.PassengerDao;
import se.lexicon.flight.domain.Passenger;

import java.util.HashMap;
import java.util.List;
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
    public Optional<Passenger> searchAndGetPassengerById(String passengerId) {
        return Optional.ofNullable(passengers.get(passengerId));
    }

   /* @Override
    public Passenger searchAndGetPassenger(String passengerId) {
       return passengers.get(passengerId);
    }
*/
    @Override
    public List<Passenger> getPassengers(){
        return passengers.values().stream().map(passenger -> Passenger.builder()
                                            .withPassengerId(passenger.getPassengerId())
                                            .withPassengerFirstName(passenger.getPassengerFirstName())
                                             .withPassengerLastName(passenger.getPassengerLastName())
                                             .withEmail(passenger.getEmail()).build()).collect(Collectors.toList());
    }
}
