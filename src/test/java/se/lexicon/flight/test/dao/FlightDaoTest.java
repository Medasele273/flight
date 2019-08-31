package se.lexicon.flight.test.dao;

import org.junit.Assert;
import org.junit.Test;
import se.lexicon.flight.dao.FlightDao;
import se.lexicon.flight.daoImpl.FlightDaoImpl;
import se.lexicon.flight.domain.Airline;
import se.lexicon.flight.domain.ClassType;
import se.lexicon.flight.domain.Flight;
import se.lexicon.flight.domain.Trip;

import java.util.Optional;

public class FlightDaoTest {

    @Test
    public void testAddFlight(){

        FlightDao flightDao =new FlightDaoImpl();

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
                         .withClassType(ClassType.ECONOMY)
                         .withTotalSeat(10)
                          .withTicketPrice(5000d)
                            .build();

        flightDao.addFlight(flight1);

       Flight flight=flightDao.searchFlight("Dubai");

        Assert.assertEquals(flight.getAirline().getAirlineName(),flight1.getAirline().getAirlineName());

       Assert.assertEquals(flight,flight1);

        System.out.println(flight);
    }
}
