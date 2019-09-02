package se.lexicon.flight.FearCalculation;

import se.lexicon.flight.domain.ClassType;
import se.lexicon.flight.domain.Flight;
import se.lexicon.flight.domain.Ticket;

import java.util.Iterator;

public class Calculation {

    private Flight flight;

    int seat =flight.getTotalSeats();

    private ClassType seatType(int seatNo, double price) {
        if (seatNo <= 5 && price <= 20000.00) return ClassType.ECONOMY;
        else {
            return ClassType.BUSINESS;
        }
    }

}

   /* double price = 20000.00;
​
    boolean findFlight = false;
    int seat = flight.getNoOfSeat();
    int noOfSeat = 10;
​
        ​
        while (!findFlight) {
​
        Flight reserve = null;
​
        for (Flight flight1 : flights) {
​
​
            // if (flight1.getSeatType().equals(SeatType.ECONOMYCLASS)) {
​
​
            if (flight1.getSeatType().equals(SeatType.ECONOMYCLASS) ?
                    flight1.getPrice() <= price :
                    flight1.getPrice() >= price) {
​
                reserve = searchedFlight
                        (flight1, flight1.getSeatType(),flight1.getPrice(), flight1.getNoOfSeat());
​
                if (reserve.getSeatType().equals(noOfSeat) &&
                        reserve.getFlightNumber().equals(flight1.getPrice()))
                    break;
​
​
            } else {
​
​
                // loop end;
                //  if (searchFlight == null) {
​
            }
        }
        int seatAvailable = 0;
        if (reserve != null) {
            seatAvailable = noOfSeat - reserve.getNoOfSeat();
        }
        findFlight = seatAvailable <= 10;
        seat = seatAvailable > 0 ? reserve.getNoOfSeat() : noOfSeat;
        flightDao.create(Flight.builder().withFlightNumber(flight.getFlightNumber())
                .withDestination(flight.getDestination()).withOrigin(flight.getOrigin()).build());
​
    }
}
​
        *//* Flight flight = makeReservation(Flight.builder().withFlightNumber()
            .withId(.getId())
            .withTime(reserve.getTime())
            .withDate(reserve.getDate())
            .withCustomerId(reserve.getCustomerId())
            .withSeatNo(reserve.getNoOfItems())
            .withSeatType(reserve.getSide())
            .withPrice(reserve.getMinMaxValue())
            .withNoAvilableSeat(reserve.getnoAvilableSeat() - noOfSeat)
            .build());*//*
        ​
        ​
        ​
        ​
        ​
        // private Flight chooseFlight(int seatAvailible, double price, Flight searchedFlight, Flight otherFlight) {
        ​
        ​
private Flight searchedFlight(Flight flight, SeatType seatType,double price,int seatNo) {
        ​
        if (flight.getFlightNumber().equals(seatType((int) price, seatNo))) {
        return flight;
        ​
        }
        ​
        ​
        ​
        *//* if (searchedFlight.getFlightNumber().equals(value(20000.0)) &&
                 searchedFlight.getNoOfSeat()(seatAvailable)) {
             return searchedFlight.equals(SeatType.BUSINESSCLASS);
         } else return searchedFlight.equals(SeatType.ECONOMYCLASS);
​
        }*//*
        ​
        return null; // to be revised
        }
        ​
        *//* private SeatType value(double price) {
     ​
             if (price >= 20000.0) return SeatType.BUSINESSCLASS;
     ​
             else {
                 return SeatType.ECONOMYCLASS;
             }*//*
        ​
        ​
private SeatType seatType(int seatNo,double price) {
        if (seatNo <= 5 &&  price<= 20000.00) return SeatType.ECONOMYCLASS;
        else {
        return SeatType.BUSINESSCLASS;
        }
        }
        }

}
*/