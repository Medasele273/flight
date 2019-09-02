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

import java.util.Collection;
import java.util.List;

public class FlightServiceTest {

    FlightDao flightDao = new FlightDaoImpl();

    FlightService flightService = new FlightServiceImpl(flightDao);


    @Test
    public void testAddFlight(){

        Flight flight1=Flight.builder().withFlightNo("EK1")
                .withFlightName("AirBus A380-800")
                .withAirline(Airline.builder()
                        .withId("01")
                        .withAirlineName("Emirates")
                        .withAirlineCode("UAE1")
                        .build())
                .withTrip(Trip.ROUND_TRIP)
                .withFromCity("Dubai")
                .withToCity("London")
                .withDepartureDate("09-09-2019")
                .withReturningDate("30-09-2019")
                .withClassType(ClassType.BUSINESS)
                .withTotalSeat(10)
                .withTicketPrice(20000d)
                .build();

      flightDao.addFlight(flight1);

     Collection <Flight> flights = flightService.searchFlightByAirlineName("Emirates");

      //  Assert.assertEquals(flights,flight1);

        System.out.println(flights);

    }

    @Test
    public void testToGetAllFlights(){

        Flight flight1= Flight.builder().withFlightNo("01")
                .withFlightName("Ethio Airway")
                .withAirline(Airline.builder()
                        .withId("1111")
                        .withAirlineName("Ethiopia Airline")
                        .withAirlineCode("ETH")
                        .build())
                .withTrip(Trip.ONE_WAY)
                .withFromCity("ADD")
                .withToCity("STO")
                .withDepartureDate("2019-09-10")
                //.withReturningDate("2019-09-20")
                .withClassType(ClassType.ECONOMY)
                .withTicketPrice(5000d)
                .withTotalSeat(10)
                .build();

        Flight flight2=Flight.builder().withFlightNo("EK1")
                .withFlightName("AirBus A380-800")
                .withAirline(Airline.builder()
                        .withId("01")
                        .withAirlineName("Emirates")
                        .withAirlineCode("UAE1")
                        .build())
                .withTrip(Trip.ROUND_TRIP)
                .withFromCity("Dubai")
                .withToCity("London")
                .withDepartureDate("09-09-2019")
                .withReturningDate("30-09-2019")
                .withClassType(ClassType.ECONOMY)
                .withTotalSeat(10)
                .withTicketPrice(5000d)
                .build();

        flightDao.addFlight(flight1);
        flightDao.addFlight(flight2);

        List<Flight> flights =flightService.getFlights();

        System.out.print(flights);
    }
}
