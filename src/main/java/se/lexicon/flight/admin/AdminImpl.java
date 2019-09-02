package se.lexicon.flight.admin;

import se.lexicon.flight.dao.AirlineDao;
import se.lexicon.flight.dao.FlightDao;
import se.lexicon.flight.dao.PassengerDao;
import se.lexicon.flight.dao.UsersDao;
import se.lexicon.flight.domain.Airline;
import se.lexicon.flight.domain.Flight;
import se.lexicon.flight.domain.Passenger;
import se.lexicon.flight.domain.Users;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AdminImpl implements Admin {

    private AirlineDao airlineDao;

    private FlightDao flightDao;

    private PassengerDao passengerDao;

    private UsersDao  usersDao;
    private Map<Object,Object> objectMap = new HashMap<>();


    @Override
    public void addAirline(Airline airline) {
        airlineDao.addAirline(airline);

    }

    @Override
    public void removeAirlineByAirlineName(String airlineName) {
        if(airlineDao.getAirlines().contains(airlineName)){
            airlineDao.removeAirlineByAirlineName(airlineName);
        }
        System.out.println("No Airline is Found By " +airlineName);
    }

    @Override
    public void addFlight(Flight flight) {
        flightDao.addFlight(flight);

    }

    @Override
    public List<Flight> getFlights() {
        return flightDao.getFlights();
    }

    @Override
    public Collection<Airline> getAirlines() {
        return airlineDao.getAirlines();
    }

    @Override
    public void cancelFlight(String flightNo) {
       flightDao.cancelFlight(flightNo);
       }


    @Override
    public Collection<Passenger> getAllPassengers() {
        if (passengerDao.getPassengers().isEmpty()){
            System.out.println("No passengers Available");
        }
        return passengerDao.getPassengers();
    }

    @Override
    public Collection<Users> getAllUsers() {
        if (usersDao.findListOfUsers().isEmpty()){
            System.out.println("Sorry no users Available");
        }
        return usersDao.findListOfUsers();
    }
}
