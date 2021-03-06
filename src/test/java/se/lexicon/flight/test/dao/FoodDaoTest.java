package se.lexicon.flight.test.dao;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import se.lexicon.flight.dao.AirlineDao;
import se.lexicon.flight.dao.FoodDao;
import se.lexicon.flight.daoImpl.FoodDaoImpl;
import se.lexicon.flight.domain.Food;

import java.util.Collection;

public class FoodDaoTest {

    @Test
    public void testFood(){

        ApplicationContext applicationContext = new GenericXmlApplicationContext("DaoTire.xml");
        FoodDao foodDao =applicationContext.getBean(FoodDao.class);

        Food food1 = Food.builder().withFoodName("Sea Food").withFoodPrice(500d).build();
        Food food2 = Food.builder().withFoodName("Som tam, Thailand").withFoodPrice(1500d).build();
        Food food3 = Food.builder().withFoodName("Chicken rice, Singapore").withFoodPrice(1000d).build();
        foodDao.addFood(food1);
        foodDao.addFood(food2);
        foodDao.addFood(food3);

        // To get all list that we have

        Collection<Food> foods=foodDao.getAllFood();

        System.out.println(foods);

    }
}
