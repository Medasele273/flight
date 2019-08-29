package se.lexicon.flight.daoImpl;

import se.lexicon.flight.dao.FlightDao;
import se.lexicon.flight.domain.Flight;

import java.util.HashMap;
import java.util.Map;

public class FlightDaoImpl implements FlightDao {

    private Map<String,Flight> flights = new HashMap<>();

    @Override
    public void addFlight(Flight flight) {

    }

    @Override
    public void searchFlight(String flightNo) {

    }
}
