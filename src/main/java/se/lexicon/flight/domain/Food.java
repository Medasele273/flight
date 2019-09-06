package se.lexicon.flight.domain;

import java.io.Serializable;
import java.util.Objects;

public class Food  {

    private String foodName;

    private Double foodPrice;

    private Food(){

    }

    private Food(Builder builder){
        this.foodName= Objects.requireNonNull(builder.foodName,"foodName should not null");
        this.foodPrice= Objects.requireNonNull(builder.foodPrice,"foodPrice should not null");
    }

    public String getFoodName(){
        return foodName;

    }

    public Double getFoodPrice(){
        return foodPrice;
    }

    @Override
    public String toString() {
        return "Food{" +
                "foodName='" + foodName + '\'' +
                ", foodPrice=" + foodPrice +
                '}'+ '\n';
    }

    public static Builder builder(){
        return new Builder();
    }

    public static class Builder implements se.lexicon.flight.commonBuilder.Builder<Food>{

        private String foodName;

        private Double foodPrice;

        public Food.Builder withFoodName(String foodName){
            this.foodName=foodName;
            return this;
        }

        public Food.Builder withFoodPrice(Double foodPrice){
            this.foodPrice=foodPrice;
            return this;
        }

        @Override
        public Food build() {
            return new Food(this);
        }
    }

}
