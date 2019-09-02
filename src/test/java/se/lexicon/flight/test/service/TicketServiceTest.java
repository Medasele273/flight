package se.lexicon.flight.test.service;

import org.junit.Test;
import se.lexicon.flight.dao.TicketDao;
import se.lexicon.flight.daoImpl.TicketDaoImpl;
import se.lexicon.flight.domain.*;
import se.lexicon.flight.service.TicketService;
import se.lexicon.flight.serviceImpl.TicketServiceImpl;

import java.util.Collection;

public class TicketServiceTest {

    @Test
    public void testTicket(){

        TicketDao ticketDao = new TicketDaoImpl();
        TicketService ticketService =new TicketServiceImpl(ticketDao);

        Ticket ticket1 = Ticket.builder().withTicketNo("T01").withFlight(Flight.builder().withFlightNo("AA1")
                .withFlightName(" AirBus A318")
                .withAirline(Airline.builder()
                        .withId("01")
                        .withAirlineName("American Airline")
                        .withAirlineCode("USA01")
                        .build())
                .withTrip(Trip.ROUND_TRIP)
                .withFromCity("Dubai")
                .withToCity("London")
                .withDepartureDate("09-09-2019")
                .withReturningDate("30-09-2019")
                .withClassType(ClassType.ECONOMY)
                .withTotalSeat(10)
                .withTicketPrice(5000d)
                .build())
                .withPassenger(Passenger.builder()
                        .withPassengerId("P1")
                        .withPassengerFirstName("John")
                        .withPassengerLastName("Alberto")
                        .withEmail("JohnAlberto@gmail.com")
                        .build()).withFood(Food.builder().withFoodName("Sea Food").withFoodPrice(500d)
                        .build()).withSeat(Seat.builder().withSeatNo("ECO1").build()).build();

        Ticket ticket2 = Ticket.builder().withTicketNo("T02").withFlight(Flight.builder().withFlightNo("AA1")
                .withFlightName(" AirBus A318")
                .withAirline(Airline.builder()
                        .withId("01")
                        .withAirlineName("American Airline")
                        .withAirlineCode("USA01")
                        .build())
                .withTrip(Trip.ROUND_TRIP)
                .withFromCity("Dubai")
                .withToCity("London")
                .withDepartureDate("09-09-2019")
                .withReturningDate("30-09-2019")
                .withClassType(ClassType.BUSINESS)
                .withTotalSeat(10)
                .withTicketPrice(20000d)
                .build())
                .withPassenger(Passenger.builder()
                        .withPassengerId("P1")
                        .withPassengerFirstName("John")
                        .withPassengerLastName("Alberto")
                        .withEmail("JohnAlberto@gmail.com")
                        .build()).withFood(Food.builder().withFoodName("Seafood paella, Spain").withFoodPrice(1000d)
                        .build()).withSeat(Seat.builder().withSeatNo("BUO1").build()).build();

        ticketDao.bookTicket(ticket1);
        ticketDao.bookTicket(ticket2);

        // Search Ticket by Ticket No
        Ticket ticket = ticketService.searchTicket("T01");

        System.out.println("==============================================================================================");

        System.out.println(ticket);

        System.out.println("==============================================================================================");
        System.out.println("All ticket that is Booked");

        Collection<Ticket> tickets =ticketService.getAllTickets();

        System.out.println(tickets);


        Double t= ticketService.ticketPrice();
        System.out.println("Ticket Price :");
        System.out.println(t);

        Double t2 =ticketService.totalIncome();
        System.out.println("Total Income");

        System.out.println(t2);

    }
}
