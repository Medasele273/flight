package se.lexicon.flight.dao;

import se.lexicon.flight.domain.Ticket;

import java.util.Collection;

public interface TicketDao {

    void bookTicket(Ticket ticket);
     Ticket searchTicketByTicketNo(String ticketNo);
     Double ticketPrice();
     Collection<Ticket> getAllTickets();
}
