package se.lexicon.flight.daoImpl;

import se.lexicon.flight.dao.FlightDao;
import se.lexicon.flight.domain.Flight;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class FlightDaoImpl implements FlightDao {

    private Map<String,Flight> flights = new HashMap<>();

    @Override
    public void addFlight(Flight flight) {
        if(flights.containsKey(flight.getFlightNo())){
            throw new RuntimeException("Flight is Exist");
        }
        flights.put(flight.getFlightNo(),flight);

    }

    @Override
    public Flight searchFlight(String flightNo) {
      return flights.get(flightNo);
    }
    @Override
    public List<Flight> getFlights(){
        return flights.values().stream().collect(Collectors.toList());
    }
}
