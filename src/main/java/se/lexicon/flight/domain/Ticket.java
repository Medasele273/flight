package se.lexicon.flight.domain;

import java.util.Objects;

public class Ticket {

    private String ticketNo;

    private Passenger passenger;

    private Flight flight;

    private Seat seat;

    private Food food;

    private Double totalPrice;

    private Ticket(){

    }

    private Ticket(Builder builder){
        this.ticketNo= Objects.requireNonNull(builder.ticketNo,"ticketNo should not null");
        this.passenger= Objects.requireNonNull(builder.passenger,"passenger should not null");
        this.flight= Objects.requireNonNull(builder.flight,"flight should not null");
        this.totalPrice=Objects.requireNonNull(builder.totalPrice,"totalPrice ");
    }

    public String getTicketNo(){
        return ticketNo;
    }

    public Passenger getPassenger(){
        return passenger;
    }

    public Flight getFlight(){
        return flight;
    }

    public Double getTotalPrice(){
        return seat.getSeatPrice() + food.getFoodPrice();
    }

    public static Builder builder(){
        return new Builder();
    }

    public static class Builder implements se.lexicon.flight.commonBuilder.Builder<Ticket>{

         private String ticketNo;

         private Passenger passenger;

         private Flight flight;

         private Double totalPrice;


        public Ticket.Builder withTicketNo(String ticketNo){
            this.ticketNo=ticketNo;
            return this;
        }

         public Ticket.Builder withPassenger(Passenger passenger){
             this.passenger=passenger;
             return this;
         }

        public Ticket.Builder withFlight(Flight flight){
            this.flight=flight;
            return this;
        }

        public Ticket.Builder withTotalPrice(Double totalPrice){
            this.totalPrice=totalPrice;
            return this;
        }

        @Override
        public Ticket build() {
            return new Ticket(this);
        }
    }
}
