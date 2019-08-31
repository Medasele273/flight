package se.lexicon.flight.test.dao;

import org.junit.Test;
import se.lexicon.flight.dao.PassengerDao;
import se.lexicon.flight.daoImpl.PassengerDaoImpl;
import se.lexicon.flight.domain.Passenger;

import java.util.List;
import java.util.Optional;

public class PassengerDaoTest {



    @Test
    public void testAddPassenger(){

        PassengerDao passengerDao = new PassengerDaoImpl();

        Passenger passenger1 =Passenger.builder()
                .withPassengerId("P1")
                .withPassengerFirstName("John")
                .withPassengerLastName("Alberto")
                .withEmail("JohnAlberto@gmail.com").build();

        Passenger passenger2 =Passenger.builder()
                .withPassengerId("P2")
                .withPassengerFirstName("Ali")
                .withPassengerLastName("Mussa")
                .withEmail("alimussa@gmail.com").build();

        Passenger passenger3 =Passenger.builder()
                .withPassengerId("P3")
                .withPassengerFirstName("David")
                .withPassengerLastName("Markus")
                .withEmail("davidmarkus@gmail.com").build();

        // Add to the Dao to save it in DataBase in our Case it is Map

        passengerDao.addPassenger(passenger1);
        passengerDao.addPassenger(passenger2);
        passengerDao.addPassenger(passenger3);

       // To search A Passenger by PassengerId from DataBase(Map)

        Optional<Passenger> passenger =passengerDao.searchAndGetPassengerById("P1");
        System.out.println("A passenger with Id " + passenger.get().getPassengerId() + " is " + passenger);

        System.out.println();

        // To get List of Passengers that we have in our DataBase(Map)

        List<Passenger> passengers = passengerDao.getPassengers();
        System.out.println(passengers);

    }
}
