package se.lexicon.flight.domain;

import java.io.Serializable;
import java.util.Objects;

public class Airline implements Serializable {

    private static final long serialVersionUID=1L;

    private String id;

    private String airlineCode;

    private String airlineName;

    private Airline(){

    }

    private Airline(Builder builder){
        this.id= Objects.requireNonNull(builder.id,"id should not be null");
        this.airlineCode= Objects.requireNonNull(builder.airlineCode,"airlineCode should not be null");
        this.airlineName= Objects.requireNonNull(builder.airlineName,"airlineName should not be null");
    }

    public String getId(){
        return id;
    }

    public String getAirlineCode(){
        return airlineCode;
    }

    public String getAirlineName(){
        return airlineName;
    }

    @Override
    public String toString() {
        return "Airline{" +
                "id='" + id + '\'' +
                ", airlineCode='" + airlineCode + '\'' +
                ", airlineName='" + airlineName + '\'' +
                '}';
    }

    public static Builder builder(){
        return new Builder();
    }

    public static class Builder implements se.lexicon.flight.commonBuilder.Builder<Airline>{

        private String id;

        private String airlineCode;

        private String airlineName;

        public  Builder withId(String id){
            this.id=id;
            return this;
        }

        public Builder withAirlineCode(String airlineCode){
            this.airlineCode=airlineCode;
            return this;
        }

        public Builder withAirlineName(String airlineName){
            this.airlineName=airlineName;
            return this;
        }

        @Override
        public Airline build(){
            return new Airline(this);
        }
    }
}
