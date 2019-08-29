package se.lexicon.flight.domain;

import java.util.HashSet;
import java.util.Set;

public class EconomyClass {

     private  Set<Food> menu = new HashSet<>();
     private  Set<Seat> seats = new HashSet<>();

    private EconomyClass(){

    }

    private  EconomyClass(Builder builder){
        this.menu=builder.menu;
        this.seats=builder.seats;
    }

    public Set<Food> getMenu(){
        return menu;
    }

    public Set<Seat> getSeats(){
        return seats;
    }

    public static Builder builder(){
        return new Builder();
    }

    public static class Builder implements se.lexicon.flight.commonBuilder.Builder<EconomyClass>{

        private Set<Food> menu = new HashSet<>();
        private Set<Seat> seats = new HashSet<>();

        public EconomyClass.Builder withMenu(Set<Food> menu){
            this.menu=menu;
            return this;
        }

        public EconomyClass.Builder withSeats(Set<Seat> seats){
            this.seats=seats;
            return this;
        }
        @Override
        public EconomyClass build() {
            return new EconomyClass(this);
        }
    }
}
