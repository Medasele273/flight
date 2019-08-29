package se.lexicon.flight.domain;

import java.util.Objects;

public class Ticket {

    private String ticketNo;

    private Passenger passenger;

    private Flight flight;

    private Ticket(){

    }

    private Ticket(Builder builder){
        this.ticketNo= Objects.requireNonNull(builder.ticketNo,"ticketNo should not null");
        this.passenger= Objects.requireNonNull(builder.passenger,"passenger should not null");
        this.flight= Objects.requireNonNull(builder.flight,"flight should not null");
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

    public static Builder builder(){
        return new Builder();
    }

    public static class Builder implements se.lexicon.flight.commonBuilder.Builder<Ticket>{

         private String ticketNo;

         private Passenger passenger;

         private Flight flight;


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



        @Override
        public Ticket build() {
            return new Ticket(this);
        }
    }
}
