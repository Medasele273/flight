package se.lexicon.flight.daoImpl;

import se.lexicon.flight.dao.AirlineDao;
import se.lexicon.flight.domain.Airline;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class AirlineDaoImpl implements  AirlineDao {

    private Map<String,Airline> airlines = new HashMap<>();

    public AirlineDaoImpl(){

    }

    @Override
    public void addAirline(Airline airline) {
        if(airlines.containsKey(airline.getAirlineName())) {
            throw new RuntimeException ("Airline is Exist");
        }
         airlines.put(airline.getAirlineName(),airline);
       // airlineDao.addAirline(airline);

    }

    @Override
    public Airline searchAirlineByName(String airlineName) {
        if (!airlines.containsKey(airlineName)) {
            throw new RuntimeException("Airline is not Exist");
        }
            Airline airline = airlines.get(airlineName);
           return airline;
    }

    @Override
    public void removeAirlineByAirlineName(String airlineName) {
        if(airlines.containsKey(airlineName)) {
            airlines.remove(airlineName);
        }else {
            System.out.println("No Airline is Available By " + airlineName);
        }

    }

    @Override
    public List<Airline> getAirlines() {
        return airlines.values().stream().map(airline -> Airline.builder()
                                         .withId(airline.getId())
                                         .withAirlineCode(airline.getAirlineCode())
                                         .withAirlineName(airline.getAirlineName())
                                          .build()).collect(Collectors.toList());
    }
}
