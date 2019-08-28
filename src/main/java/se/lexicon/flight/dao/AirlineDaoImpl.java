package se.lexicon.flight.dao;

import se.lexicon.flight.domain.Airline;

import java.util.*;

public class AirlineDaoImpl implements  AirlineDao {

    private Map<String,Airline> airlines = new HashMap<>();

    private AirlineDao airlineDao;

    public AirlineDaoImpl(AirlineDao airlineDao){
        this.airlineDao= Objects.requireNonNull(airlineDao);
    }


    @Override
    public void addAirline(Airline airline) {
        if(airlines.containsKey(airline.getId())) {
            throw new RuntimeException ("Airline is Exist");
        }
         airlines.put(airline.getId(),airline);
        airlineDao.addAirline(airline);

    }

    @Override
    public Airline getAirline(String id) {
        Airline airline = airlines.get(id);
        return airline;
    }

    @Override
    public void deleteAirline(Airline airline) {
        airlines.remove(airline);

    }

    @Override
    public List<Airline> getAirlines() {
        return null;
    }
}
