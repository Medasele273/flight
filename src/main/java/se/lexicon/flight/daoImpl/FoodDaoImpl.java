package se.lexicon.flight.daoImpl;

import se.lexicon.flight.dao.FoodDao;
import se.lexicon.flight.domain.Food;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class FoodDaoImpl implements FoodDao {

    private Map<String,Food>  foodMenu = new HashMap<>();

    @Override
    public void addFood(Food food) {
        foodMenu.put(food.getFoodName(),food);
    }

    @Override
    public Collection<Food> getAllFood() {
        return foodMenu.values().stream().map(food -> Food.builder()
                                 .withFoodName(food.getFoodName())
                                 .withFoodPrice(food.getFoodPrice()).build()).collect(Collectors.toList());
    }
}
