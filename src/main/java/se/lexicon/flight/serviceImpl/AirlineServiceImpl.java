package se.lexicon.flight.serviceImpl;

import se.lexicon.flight.dao.AirlineDao;
import se.lexicon.flight.domain.Airline;
import se.lexicon.flight.service.AirlineService;

import java.util.List;
import java.util.Objects;

public class AirlineServiceImpl implements AirlineService {

    private AirlineDao airlineDao;

    public AirlineServiceImpl(AirlineDao airlineDao){
        this.airlineDao= Objects.requireNonNull(airlineDao);
    }
    @Override
    public void addAirline(Airline airline) {
        airlineDao.addAirline(airline);

    }

    @Override
    public Airline searchAirlineById(String id) {
        return airlineDao.searchAirlineById(id);
    }

    @Override
    public void removeAirlineById(String id){
        airlineDao.removeAirlineById(id);
    }

    @Override
    public List<Airline> getAirlines(){
       return airlineDao.getAirlines();
    }

}
