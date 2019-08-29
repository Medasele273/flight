package se.lexicon.flight.test.dao;

import org.junit.Assert;
import org.junit.Test;
import se.lexicon.flight.dao.AirlineDao;
import se.lexicon.flight.daoImpl.AirlineDaoImpl;
import se.lexicon.flight.domain.Airline;

public class AirlineDaoTest {

    @Test
    public void addAirlineTest(){

        AirlineDao airlineDao =new AirlineDaoImpl();

        Airline airline1=Airline.builder().withId("1").withAirlineName("Lufthansa").withAirlineCode("DLH").build();
        Airline airline2=Airline.builder().withId("2").withAirlineName("Ethiopian airlines").withAirlineCode("EH").build();
        airlineDao.addAirline(airline1);
        airlineDao.addAirline(airline2);

        Airline fetched =airlineDao.getAirline("1");

        Assert.assertEquals(airline1,fetched);
        Assert.assertEquals(2,airlineDao.getAirlines().size());
    }
}
