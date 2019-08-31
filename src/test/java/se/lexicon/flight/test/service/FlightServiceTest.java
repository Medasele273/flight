package se.lexicon.flight.test.service;

import org.junit.Assert;
import org.junit.Test;
import se.lexicon.flight.dao.FlightDao;
import se.lexicon.flight.daoImpl.FlightDaoImpl;
import se.lexicon.flight.domain.Airline;
import se.lexicon.flight.domain.ClassType;
import se.lexicon.flight.domain.Flight;
import se.lexicon.flight.domain.Trip;
import se.lexicon.flight.service.FlightService;
import se.lexicon.flight.serviceImpl.FlightServiceImpl;

import java.util.List;

public class FlightServiceTest {

    FlightDao flightDao = new FlightDaoImpl();

    FlightService flightService = new FlightServiceImpl(flightDao);


    @Test
    public void testAddFlight(){


        Flight flight1=Flight.builder().withFlightNo("EK1")
                .withFlightName("AirBus A380-800")
                .withFromCity("Dubai")
                .withToCity("London")
                .withTotalSeat(10)
                .withTrip(Trip.ROUND_TRIP)
                .withClassType(ClassType.ECONOMY)
                .withTicketPrice(5000d)
                .withAirline(Airline.builder()
                        .withId("01")
                        .withAirlineName("Emirates")
                        .withAirlineCode("UAE1")
                        .build())
                .build();

      flightDao.addFlight(flight1);

      Flight flight = flightService.searchFlightByFlightNo("EK1");

        Assert.assertEquals(flight,flight1);

        System.out.println(flight);

    }

    @Test
    public void testToGetAllFlights(){

        Flight flight1 =Flight.builder().withFlightNo("EK1")
                .withFlightName("AirBus A380-800")
                .withFromCity("Dubai")
                .withToCity("London")
                .withTotalSeat(10)
                .withTrip(Trip.ROUND_TRIP)
                .withClassType(ClassType.ECONOMY)
                .withTicketPrice(5000d)
                .withAirline(Airline.builder()
                        .withId("01")
                        .withAirlineName("Emirates")
                        .withAirlineCode("UAE1")
                        .build())
                .build();

        Flight flight2 = Flight.builder().withFlightNo("01")
                .withFlightName("Eth Airway")
                .withAirline(Airline.builder()
                        .withId("1111")
                        .withAirlineName("Ethiopia Airline")
                        .withAirlineCode("ETH")
                        .build())
                .withClassType(ClassType.ECONOMY)
                .withFromCity("ADD")
                .withToCity("STO")
                .withTicketPrice(5000d)
                .withTrip(Trip.ONE_WAY)
                .withTotalSeat(10)
                .build();

        flightDao.addFlight(flight1);
        flightDao.addFlight(flight2);

        List<Flight> flights =flightService.getFlights();

        System.out.print(flights);
    }
}
