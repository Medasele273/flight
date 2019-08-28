package se.lexicon.flight.test.domain;

import org.junit.Assert;
import org.junit.Test;
import se.lexicon.flight.domain.Airline;

public class AirlineTest {

    @Test
    public void airlineTest(){

        Airline airline = Airline.builder().withId("1111").withAirlineCode("ETH").withAirlineName("Ethiopian Airline").build();
        Assert.assertEquals("ETH",airline.getAirlineCode());
    }
}
