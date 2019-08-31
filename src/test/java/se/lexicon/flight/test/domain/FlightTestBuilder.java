package se.lexicon.flight.test.domain;

import org.junit.Assert;
import org.junit.Test;
import se.lexicon.flight.domain.Airline;
import se.lexicon.flight.domain.ClassType;
import se.lexicon.flight.domain.Flight;
import se.lexicon.flight.domain.Trip;

public class FlightTestBuilder {

    @Test
    public void flightTest(){

        Flight flight= Flight.builder().withFlightNo("01")
                      .withFlightName("Eth Airway")
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

        Assert.assertEquals("01",flight.getFlightNo());

        System.out.println(flight);
        System.out.println();
        System.out.println(flight1);
    }
}
