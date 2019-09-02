package se.lexicon.flight.domain;

import java.util.Objects;

public class Ticket {

    private String ticketNo;

    private Passenger passenger;

    private Flight flight;

    private Seat seat;

    private Food food;

   // private Double ticketPrice;

    private Ticket(){


    }

    private Ticket(Builder builder){
        this.ticketNo= Objects.requireNonNull(builder.ticketNo,"ticketNo should not null");
        this.passenger= Objects.requireNonNull(builder.passenger,"passenger should not null");
        this.flight= Objects.requireNonNull(builder.flight,"flight should not null");
        this.food= Objects.requireNonNull(builder.food,"food should not null");
        this.seat= Objects.requireNonNull(builder.seat,"flight should not null");
       // this.ticketPrice=Objects.requireNonNull(builder.ticketPrice,"ticketPrice should not be Null ");
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

    public Seat getSeat(){
        return seat;
    }

    public Food getFood(){
        return food;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "ticketNo='" + ticketNo + '\'' +
                ", passenger=" + passenger +
                ", flight=" + flight +
                ", seat=" + seat +
                ", food=" + food +
                '}';
    }

    /* public Double getTicketPrice(){
        return ticketPrice;
    }*/

    public static Builder builder(){
        return new Builder();
    }

    public static class Builder implements se.lexicon.flight.commonBuilder.Builder<Ticket>{

         private String ticketNo;

         private Passenger passenger;

         private Flight flight;

         private Food food;
         private Seat seat;

         private Double ticketPrice;


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

      /*  public Ticket.Builder withTicketPrice(Double ticketPrice){
            this.ticketPrice=ticketPrice;
            return this;
        }
*/
        public Ticket.Builder withFood(Food food){
            this.food =food;
            return this;
        }

        public Ticket.Builder withSeat(Seat seat){
            this.seat=seat;
            return this;
        }

        @Override
        public Ticket build() {
            return new Ticket(this);
        }
    }
}
