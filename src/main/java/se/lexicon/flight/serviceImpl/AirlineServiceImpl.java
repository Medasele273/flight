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
    public Airline getAirline(String id) {
        return airlineDao.getAirline(id);
    }

    @Override
    public void removeAirline(String id){
        airlineDao.removeAirline(id);
    }

    @Override
    public List<Airline> getAirlines(){
       return airlineDao.getAirlines();
    }

}
