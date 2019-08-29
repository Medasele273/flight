package se.lexicon.flight.domain;

import java.io.Serializable;
import java.util.Objects;

public class Passenger implements Serializable {

    private static final long serialVersionUID =1L;

    private String passengerId;

    private String passengerFirstName;

    private String passengerLastName;

    private String email;

    private Passenger(){

    }

    private Passenger(Builder builder){
        this.passengerId= Objects.requireNonNull(builder.passengerId,"passengerId should not be null");
        this.passengerFirstName= Objects.requireNonNull(builder.passengerFirstName,"passengerFirstName should not be null");
        this.passengerLastName= Objects.requireNonNull(builder.passengerLastName,"passengerLastName should not be null");
        this.email= Objects.requireNonNull(builder.email,"email should not be null");
    }

    public String getPassengerId(){
        return passengerId;
    }

    public String getPassengerFirstName(){
        return passengerFirstName;
    }

    public String getPassengerLastName(){
        return passengerLastName;
    }

    public String getEmail(){
        return email;
    }

    public static Builder builder(){
        return new Builder();
    }

    public static class Builder implements se.lexicon.flight.commonBuilder.Builder<Passenger>{

        private String passengerId;

        private String passengerFirstName;

        private String passengerLastName;

        private String email;

        public Passenger.Builder withPassengerId(String passengerId){
            this.passengerId=passengerId;
            return this;
        }

        public Passenger.Builder withPassengerFirstName(String passengerFirstName){
            this.passengerFirstName=passengerFirstName;
            return this;
        }

        public Passenger.Builder withPassengerLastName(String passengerLastName){
            this.passengerLastName=passengerLastName;
            return this;
        }

        public Passenger.Builder withEmail(String email){
            this.email=email;
            return this;
        }

        @Override
        public Passenger build() {
            return new Passenger(this);
        }
    }
}
