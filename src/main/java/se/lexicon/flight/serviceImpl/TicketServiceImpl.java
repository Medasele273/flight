package se.lexicon.flight.serviceImpl;

import se.lexicon.flight.dao.TicketDao;
import se.lexicon.flight.domain.Ticket;
import se.lexicon.flight.service.TicketService;

import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;

public class TicketServiceImpl implements TicketService {

    private TicketDao ticketDao;

    public TicketServiceImpl(TicketDao ticketDao){
        this.ticketDao= Objects.requireNonNull(ticketDao);
    }
    @Override
    public void bookTicket(Ticket ticket) {
        ticketDao.bookTicket(ticket);
        System.out.println("Book Successful");
    }

    @Override
    public Ticket searchTicket(String ticketNO) {
        return ticketDao.searchTicketByTicketNo(ticketNO);
    }

    @Override
    public Collection<Ticket> getAllTickets() {
        return ticketDao.getAllTickets();
    }

    @Override
    public Double ticketPrice(){
        Double flightPrice=0.0d;
        Double foodPrice=0.0d;
        Double totalPrice=0.0d;

        Iterator<Ticket> iterator = ticketDao.getAllTickets().iterator();

        while (iterator.hasNext()) {
            flightPrice = iterator.next().getFlight().getTicketPrice();

            foodPrice = iterator.next().getFood().getFoodPrice();
        }
        totalPrice = flightPrice + foodPrice;

        return totalPrice;
    }

}
