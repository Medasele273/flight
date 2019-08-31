package se.lexicon.flight.admin;

import se.lexicon.flight.dao.AirlineDao;
import se.lexicon.flight.dao.FlightDao;
import se.lexicon.flight.dao.PassengerDao;
import se.lexicon.flight.dao.UsersDao;
import se.lexicon.flight.domain.Airline;
import se.lexicon.flight.domain.Flight;

public class AdminImpl implements Admin {

    private AirlineDao airlineDao;

    private FlightDao flightDao;

    private PassengerDao passengerDao;

    private UsersDao  usersDao;

    @Override
    public void addAirline(Airline airline) {
        airlineDao.addAirline(airline);

    }

    @Override
    public void removeAirlineById(String airlineId) {
        airlineDao.removeAirlineById(airlineId);

    }

    @Override
    public void addFlight(Flight flight) {
        flightDao.addFlight(flight);

    }
}
