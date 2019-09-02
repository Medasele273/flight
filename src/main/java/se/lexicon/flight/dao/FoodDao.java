package se.lexicon.flight.dao;

import se.lexicon.flight.domain.Food;

import java.util.Collection;

public interface FoodDao {

    void addFood(Food food);

    Collection<Food> getAllFood();
}
