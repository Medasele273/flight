package se.lexicon.flight.daoImpl;

import se.lexicon.flight.dao.FoodDao;
import se.lexicon.flight.domain.Food;

import java.util.HashMap;
import java.util.Map;

public class FoodDaoImpl implements FoodDao {

    private Map<String,Food>  foodMenu = new HashMap<>();

    @Override
    public void addFood(Food food) {
        foodMenu.put(food.getFoodName(),food);
    }
}
