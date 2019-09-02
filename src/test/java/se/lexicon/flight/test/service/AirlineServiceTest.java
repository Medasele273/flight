package se.lexicon.flight.test.service;

import org.junit.Assert;
import org.junit.Test;
import se.lexicon.flight.dao.AirlineDao;
import se.lexicon.flight.daoImpl.AirlineDaoImpl;
import se.lexicon.flight.domain.Airline;
import se.lexicon.flight.service.AirlineService;
import se.lexicon.flight.serviceImpl.AirlineServiceImpl;

import java.util.List;

public class AirlineServiceTest {

    @Test
    public void testAddAirlineAndGetAirline(){

        AirlineDao airlineDao = new AirlineDaoImpl();

        //To create Airline

        Airline airline1=Airline.builder().withId("01").withAirlineCode("LH").withAirlineName("Lufthansa").build();
        Airline airline2=Airline.builder().withId("02").withAirlineCode("ETH").withAirlineName("Ethiopian Airline").build();

        // To Add Airlines to DAO
        airlineDao.addAirline(airline1);
        airlineDao.addAirline(airline2);

        AirlineService airlineService = new AirlineServiceImpl(airlineDao);

        // TO get One Airline by Name
        System.out.println("Search Airline By Name  "  );
        Airline airline = airlineService.searchAirlineByName("Lufthansa");
        System.out.println(airline);

        // To get All Airlines
        System.out.println("List of Airlines = " + airlineService.getAirlines().size());

        List<Airline> airlines= airlineService.getAirlines();
        System.out.print(airlines);

        Assert.assertEquals(2,airlineService.getAirlines().size());
    }


    @Test
    public void testRemoveAirline(){

        AirlineDao airlineDao = new AirlineDaoImpl();

        //To create Airline

        Airline airline3=Airline.builder().withId("03").withAirlineCode("LH").withAirlineName("Lufthansa").build();
        Airline airline4=Airline.builder().withId("04").withAirlineCode("ETH").withAirlineName("Ethiopian Airline").build();

        // To Add Airlines to DAO
        airlineDao.addAirline(airline3);
        airlineDao.addAirline(airline4);

        AirlineService airlineService = new AirlineServiceImpl(airlineDao);

        // To Check How many Airlines we have in Dao

        int size=airlineService.getAirlines().size();
        Assert.assertEquals(2,size);
        List<Airline> airlines=airlineService.getAirlines();
        System.out.println("List of Airlines before removing from Dao :");
        System.out.println("=================================================================================================");
        System.out.println(airlines);
        // To check how many Airlines we have after we remove from Dao

        airlineService.removeAirlineByAirlineName("Ethiopian Airline");
        System.out.println();
        int count=airlineService.getAirlines().size();
        Assert.assertEquals(1,count);
        List<Airline> airlines1=airlineService.getAirlines();
        System.out.println("List of Airlines After removing from Dao :");
        System.out.println("==================================================================================================");
        System.out.println(airlines1);

    }
}
