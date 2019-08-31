package se.lexicon.flight.test.domain;

import org.junit.Assert;
import org.junit.Test;
import se.lexicon.flight.domain.Food;

public class FoodTestBuilder {

    @Test
    public void foodTest(){
        Food food = Food.builder().withFoodName("Sea Food").withFoodPrice(500d).build();
        Assert.assertEquals(Double.valueOf(500d),food.getFoodPrice());
    }
}
