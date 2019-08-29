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

    @Override
    public void addAirline(Airline airline) {
        if(airlines.containsKey(airline.getId())) {
            throw new RuntimeException ("Airline is Exist");
        }
         airlines.put(airline.getId(),airline);
       // airlineDao.addAirline(airline);

    }

    @Override
    public Airline searchAirlineById(String id) {
        if (!airlines.containsKey(id)) {
            throw new RuntimeException("Airline is not Exist");
        }
            Airline airline = airlines.get(id);
           return airline;
    }

    @Override
    public void removeAirlineById(String id) {
        airlines.remove(id);

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
