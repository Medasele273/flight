package se.lexicon.flight.test.dao;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import se.lexicon.flight.dao.AirlineDao;
import se.lexicon.flight.daoImpl.AirlineDaoImpl;
import se.lexicon.flight.domain.Airline;

import java.util.List;

public class AirlineDaoTest {



    @Test
    public void addAirlineTest(){

        AirlineDao airlineDao =new AirlineDaoImpl();

        Airline airline1=Airline.builder().withId("1").withAirlineName("Lufthansa").withAirlineCode("DLH").build();
        Airline airline2=Airline.builder().withId("2").withAirlineName("Ethiopian airlines").withAirlineCode("EH").build();

        // Add Airlines to Dao in our case Map
        airlineDao.addAirline(airline1);
        airlineDao.addAirline(airline2);
        Assert.assertNotNull(airlineDao.searchAirlineByName("Lufthansa"));

        // Search Airline From dataBase(Map) by AirlineName

        Airline fetched =airlineDao.searchAirlineByName("Ethiopian airlines");
        System.out.println("Airline By " + fetched.getAirlineName()+ " is " +fetched);

        Assert.assertEquals(airline2.getAirlineName(),fetched.getAirlineName());

        // To check How many Airlines we have in our DataBase(Map) and print them

        List<Airline> airlines =airlineDao.getAirlines();
        Assert.assertEquals(2,airlineDao.getAirlines().size());

        System.out.println(airlines);
    }
}
