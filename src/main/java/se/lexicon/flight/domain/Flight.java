package se.lexicon.flight.domain;

import java.io.Serializable;
import java.util.Objects;

public class Flight implements Serializable {

    private static final long serialVersionUID=1L;

    private String flightNo;

    private String flightName;

    private int totalSeats;

    private String fromCity;

    private String toCity;

    private Airline airline;

    private Trip trip;

    private ClassType classType;

    private Double ticketPrice;

    private Flight(){

    }

    private Flight(Builder builder){
        this.flightNo= Objects.requireNonNull(builder.flightNo,"flightId not be null");
        this.flightName= Objects.requireNonNull(builder.flightName,"flightName not be null");
        this.totalSeats= Objects.requireNonNull(builder.totalSeats,"totalSeats not be null");
        this.fromCity= Objects.requireNonNull(builder.fromCity,"fromCity not be null");
        this.toCity= Objects.requireNonNull(builder.toCity,"toCity not be null");
        this.airline= Objects.requireNonNull(builder.airline,"airline not be null");
        this.trip= Objects.requireNonNull(builder.trip,"trip not be null");
        this.classType= Objects.requireNonNull(builder.classType,"classType not be null");
        this.ticketPrice= Objects.requireNonNull(builder.ticketPrice,"ticketPrice not be null");
    }

    public String getFlightNo() {
        return flightNo;
    }

    public String getFlightName() {
        return flightName;
    }

    public int getTotalSeats() {
        return totalSeats;
    }

    public String getFromCity() {
        return fromCity;
    }

    public String getToCity() {
        return toCity;
    }

    public Airline getAirline() {
        return airline;
    }

    public Trip getTrip() {
        return trip;
    }

    public ClassType getClassType() {
        return classType;
    }

    public Double getTicketPrice() {
        return ticketPrice;
    }

    @Override
    public String toString() {
        return "Builder{" +
                "flightNo='" + flightNo + '\'' +
                ", flightName='" + flightName + '\'' +
                ", noOFSeats=" + totalSeats +
                ", fromCity='" + fromCity + '\'' +
                ", toCity='" + toCity + '\'' +
                ", airline=" + airline +
                ", trip=" + trip +
                ", classType=" + classType +
                ", ticketPrice=" + ticketPrice +
                '}';
    }

    public static Builder builder(){
        return new Builder();
    }

    public static class Builder implements se.lexicon.flight.commonBuilder.Builder<Flight>{

        private String flightNo;

        private String flightName;

        private int totalSeats;

        private String fromCity;

        private String toCity;

        private Airline airline;

        private Trip trip;

        private ClassType classType;

        private Double ticketPrice;



        public Flight.Builder withFlightNo(String flightNo){
            this.flightNo=flightNo;
            return this;
        }

        public Flight.Builder withFlightName(String flightName){
            this.flightName=flightName;
            return this;
        }

        public Flight.Builder withTotalSeat(int totalSeats){
            this.totalSeats=totalSeats;
            return this;
        }

        public Flight.Builder withFromCity(String fromCity){
            this.fromCity=fromCity;
            return this;
        }

        public Flight.Builder withToCity(String toCity){
            this.toCity=toCity;
            return this;
        }

        public Flight.Builder withAirline(Airline airline){
            this.airline=airline;
            return this;
        }

        public Flight.Builder withTrip(Trip trip){
            this.trip=trip;
            return this;
        }

        public Flight.Builder withClassType(ClassType classType){
            this.classType=classType;
            return this;
        }

        public Flight.Builder withTicketPrice(Double ticketPrice){
            this.ticketPrice=ticketPrice;
            return this;
        }
        @Override
        public Flight build() {
            return new Flight(this);
        }
    }
}
