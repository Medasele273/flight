package se.lexicon.flight.serviceImpl;

import se.lexicon.flight.dao.FlightDao;
import se.lexicon.flight.domain.Flight;
import se.lexicon.flight.service.FlightService;

import java.util.List;
import java.util.Objects;

public class FlightServiceImpl implements FlightService {

    private FlightDao flightDao;

    public FlightServiceImpl(FlightDao flightDao){
        this.flightDao = Objects.requireNonNull(flightDao);

    }
    @Override
    public void addFlight(Flight flight) {
        flightDao.addFlight(flight);

    }

    @Override
    public Flight searchFlightByFlightNo(String flightNO) {
       return flightDao.searchFlight(flightNO);
    }

    @Override
    public List<Flight> getFlights() {
        return flightDao.getFlights();
    }
}
