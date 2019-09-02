package se.lexicon.flight.serviceImpl;

import se.lexicon.flight.dao.FlightDao;
import se.lexicon.flight.domain.Flight;
import se.lexicon.flight.service.FlightService;

import java.util.Collection;
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
    public Collection<Flight> searchFlightByAirlineName(String airlineName) {
       return flightDao.searchFlightByAirlineName(airlineName);
    }

    @Override
    public Collection<Flight> searchFlightByCityAndDate(String fromCity, String toCity, String departureDate) {
        return flightDao.searchFlightByCityAndDate(fromCity,toCity,departureDate);
    }

    @Override
    public List<Flight> getFlights() {
        return flightDao.getFlights();
    }
}
