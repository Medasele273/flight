package se.lexicon.flight.test.domain;

import org.junit.Assert;
import org.junit.Test;
import se.lexicon.flight.domain.Passenger;

public class PassengerTest {

    @Test
    public void testPassenger(){

        Passenger passenger =Passenger.builder().withPassengerId("1")
                            .withPassengerFirstName("AAA")
                            .withPassengerLastName("BBB")
                            .build();

        Assert.assertTrue("This should be True",passenger.getPassengerId().equals("1"));

    }
}
