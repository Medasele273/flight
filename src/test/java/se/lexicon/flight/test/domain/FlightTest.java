package se.lexicon.flight.test.domain;

import org.junit.Assert;
import org.junit.Test;
import se.lexicon.flight.domain.Airline;
import se.lexicon.flight.domain.ClassType;
import se.lexicon.flight.domain.Flight;
import se.lexicon.flight.domain.Trip;

public class FlightTest {

    @Test
    public void flightTest(){
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
                      .withTicketPrice(5000d)
                      .withTrip(Trip.ONE_WAY)
                      .withTotalSeat(10)
                      .build();
        Assert.assertEquals("1",flight.getFlightNo());

        System.out.println(flight);
    }
}
