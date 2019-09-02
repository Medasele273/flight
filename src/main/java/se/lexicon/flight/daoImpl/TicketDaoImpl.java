package se.lexicon.flight.daoImpl;

import se.lexicon.flight.dao.TicketDao;
import se.lexicon.flight.domain.*;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.stream.Collectors;

public class TicketDaoImpl implements TicketDao {


    private Map<String,Ticket> tickets = new HashMap<>();

    @Override
    public void bookTicket(Ticket ticket) {
       if(tickets.containsKey(ticket.getTicketNo())){
           throw new RuntimeException("Ticket is Already Booked");
       }
       tickets.put(ticket.getTicketNo(),ticket);
    }

    @Override
    public Ticket searchTicketByTicketNo(String ticketNo) {
        if (!tickets.containsKey(ticketNo)) {
            throw new RuntimeException("Ticket is not Exist");
        }
        Ticket ticket = tickets.get(ticketNo);
        return ticket;
    }

    @Override
    public Double ticketPrice(String passengerId){
        Double flightPrice=0.0d;
        Double foodPrice=0.0d;
        Double totalPrice=0.0d;

  //Iterator<Ticket> iterator =tickets.values().iterator();
 //for (int i = 1; i<=tickets.size()+1;i++) {
        Iterator<Map.Entry<String, Ticket>> iterator = tickets.entrySet().stream().iterator();
       // while (iterator.hasNext()) {

            flightPrice=tickets.entrySet().stream().filter(x->passengerId.equalsIgnoreCase(passengerId)).map(x->x.getValue()).collect(Collectors.summingDouble(ticket1 -> ticket1.getFlight().getTicketPrice()));
            foodPrice=tickets.entrySet().stream().filter(x->passengerId.equalsIgnoreCase(passengerId)).map(x->x.getValue()).collect(Collectors.summingDouble(ticket1 -> ticket1.getFood().getFoodPrice()));
           // flightPrice = tickets.values().stream().iterator().next().getFlight().getTicketPrice();
            //flightPrice = tickets.values().stream().iterator().next().getFlight().getTicketPrice();
           // foodPrice = tickets.values().stream().iterator() .next().getFood().getFoodPrice();
            //  foodPrice=tickets.get(i).getFood().getFoodPrice();
       // }
             totalPrice = flightPrice + foodPrice;
// }
       // totalPrice = flightPrice + foodPrice;
       // System.out.println(totalPrice);
        return totalPrice;
    }

    @Override
    public Collection<Ticket> getAllTickets() {
      /*  return tickets.values().stream().map(t->Ticket.builder().withTicketNo(t.getTicketNo()).withSeat(
                Seat.builder().withSeatNo("").build()
                 ).withFlight(Flight.builder()
                .withFlightNo(t.getFlight().getFlightNo()).withFlightName(t.getFlight().getFlightName())
                .withDepartureDate(t.getFlight().getDepartureDate()).withReturningDate(t.getFlight().getReturningDate())
                .withFromCity(t.getFlight().getFromCity()).withToCity(t.getFlight().getToCity())
                .withAirline(Airline.builder().withId(t.getFlight().getAirline().getId()).withAirlineName(t.getFlight().getAirline().getAirlineName())
                        .withAirlineCode(t.getFlight().getAirline().getAirlineCode()).build())
                .withClassType(t.getFlight().getClassType()).withTotalSeat(t.getFlight().getTotalSeats())
                .withTrip(t.getFlight().getTrip()).withTicketPrice(t.getFlight().getTicketPrice()).build())
                .withFood(Food.builder().withFoodName(t.getFood().getFoodName()).withFoodPrice(t.getFood().getFoodPrice()).build())
                .withPassenger(Passenger.builder().withPassengerId(t.getPassenger().getPassengerId())
                        .withPassengerFirstName(t.getPassenger().getPassengerFirstName()).withPassengerLastName(t.getPassenger().getPassengerLastName())
                        .withEmail(t.getPassenger().getEmail()).build()).build()).collect(Collectors.toList());
    }*/
        return tickets.values().stream().collect(Collectors.toList());
    }
}
