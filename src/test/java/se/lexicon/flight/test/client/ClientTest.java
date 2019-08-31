package se.lexicon.flight.test.client;

import org.junit.Assert;
import org.junit.Test;
import se.lexicon.flight.client.Client;
import se.lexicon.flight.client.ClientImpl;
import se.lexicon.flight.dao.AirlineDao;
import se.lexicon.flight.dao.FlightDao;
import se.lexicon.flight.daoImpl.AirlineDaoImpl;
import se.lexicon.flight.daoImpl.FlightDaoImpl;
import se.lexicon.flight.domain.Airline;
import se.lexicon.flight.domain.ClassType;
import se.lexicon.flight.domain.Flight;
import se.lexicon.flight.domain.Trip;
import se.lexicon.flight.service.AirlineService;
import se.lexicon.flight.service.FlightService;
import se.lexicon.flight.serviceImpl.AirlineServiceImpl;
import se.lexicon.flight.serviceImpl.FlightServiceImpl;

public class ClientTest {


    AirlineDao airlineDao = new AirlineDaoImpl();
    FlightDao flightDao =new FlightDaoImpl();

    AirlineService airlineService =new AirlineServiceImpl(airlineDao);
    FlightService flightService=new FlightServiceImpl(flightDao);

    Client client = new ClientImpl(airlineService,flightService);

    @Test
    public void testSearchAirlineById(){


        // create Airline

        Airline airline = Airline.builder().withId("001").withAirlineCode("AB389").withAirlineName("Sudan Airline").build();

        // Insert Airline to Dao
        airlineDao.addAirline(airline);

      //  A client  search Airline by airline Name
        System.out.println("Airline By Airline Name");

        Airline airline1 = client.searchAirlineByName("Sudan Airline");

        Assert.assertEquals(airline,airline1);

        System.out.println(airline1);

    }

    @Test
    public void searchFlightByFlightNo(){

        Flight flight= Flight.builder().withFlightNo("01")
                .withFlightName("Eth Airway")
                .withAirline(Airline.builder()
                        .withId("1111")
                        .withAirlineName("Ethiopia Airline")
                        .withAirlineCode("ETH")
                        .build())
                .withClassType(ClassType.ECONOMY)
                .withFromCity("ADD")
                .withToCity("STO")
                .withDepartureDate("10-09-2019")
                .withTicketPrice(5000d)
                .withTrip(Trip.ONE_WAY)
                .withTotalSeat(10)
                .build();

         // Add Flight to Dao (Map)

        flightDao.addFlight(flight);

        // Fetch Flight from Dao(Map) by Flight number

        Flight flight1 = client.searchFlightByFlightNo("01");

        Assert.assertEquals(flight,flight1);
        System.out.println("Flight with flight number " +flight1.getFlightNo());
        System.out.println(flight1);
    }
}
