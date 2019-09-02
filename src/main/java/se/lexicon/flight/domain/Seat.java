package se.lexicon.flight.domain;

import java.util.Objects;

public class Seat {

    private String seatNo;

   // private String seatClass;

   // private Double seatPrice;

    private Seat(){

    }

    private Seat(Builder builder){
        this.seatNo= Objects.requireNonNull(builder.seatNo,"seatNo should not be null");
       // this.seatClass= Objects.requireNonNull(builder.seatClass,"seatClass should not be null");
      //  this.seatPrice= Objects.requireNonNull(builder.seatPrice,"seatPrice should not be null");
    }

    public String getSeatNo(){
        return seatNo;
    }

    @Override
    public String toString() {
        return "Seat{" +
                "seatNo='" + seatNo + '\'' +
                '}';
    }

    /*public String getSeatClass(){
            return seatClass;
        }

        public Double getSeatPrice(){
            return seatPrice;
        }
    */
    public static Builder builder(){
        return new Builder();
    }

    public static class Builder implements se.lexicon.flight.commonBuilder.Builder<Seat>{

        private String seatNo;

        private String seatClass;

        private Double seatPrice;

        public Seat.Builder withSeatNo(String seatNo){
            this.seatNo =seatNo;
            return this;
        }

       /* public Seat.Builder withSeatClass(String seatClass){
            this.seatClass =seatClass;
            return this;
        }

        public Seat.Builder withSeatPrice(Double seatPrice){
            this.seatPrice =seatPrice;
            return this;
        }*/

        @Override
        public Seat build() {
            return new Seat(this);
        }
    }
}
