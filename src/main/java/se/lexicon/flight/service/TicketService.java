package se.lexicon.flight.service;

import se.lexicon.flight.domain.Ticket;

import java.util.Collection;

public interface TicketService {

    void bookTicket(Ticket ticket);
    Ticket searchTicket(String ticketNO);
    Collection<Ticket> getAllTickets();
    Double ticketPrice();
    Double totalIncome();
}
