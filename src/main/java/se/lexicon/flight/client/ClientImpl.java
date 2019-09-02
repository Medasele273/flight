package se.lexicon.flight.client;

import se.lexicon.flight.domain.Airline;
import se.lexicon.flight.domain.Flight;
import se.lexicon.flight.domain.Ticket;
import se.lexicon.flight.service.AirlineService;
import se.lexicon.flight.service.FlightService;
import se.lexicon.flight.service.TicketService;

import java.util.Collection;
import java.util.Objects;

public class ClientImpl implements Client {

    private AirlineService airlineService;

    private FlightService flightService;

    private TicketService ticketService;

    public ClientImpl(){

    }

    public ClientImpl(AirlineService airlineService,FlightService flightService,TicketService ticketService) {
        this.airlineService=Objects.requireNonNull(airlineService,"airlineService should not null");
        this.flightService= Objects.requireNonNull(flightService,"flightService should not null");
        this.ticketService= Objects.requireNonNull(ticketService,"ticketService should not null");
    }

    @Override
    public Airline searchAirlineByName(String airlineName) {
        return airlineService.searchAirlineByName(airlineName);
    }

    @Override
    public Collection<Flight> searchFlightByAirlineName(String airlineName){
        return flightService.searchFlightByAirlineName(airlineName);
    }

    @Override
    public Collection<Flight> searchFlightByCityAndDate(String fromCity, String toCity, String departureDate) {
        return flightService.searchFlightByCityAndDate(fromCity,toCity,departureDate);
    }

    @Override
    public void book(Ticket ticket) {
      ticketService.bookTicket(ticket);
    }
}
