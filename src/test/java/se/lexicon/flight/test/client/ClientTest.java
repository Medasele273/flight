package se.lexicon.flight.test.client;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import se.lexicon.flight.client.Client;
import se.lexicon.flight.client.ClientImpl;
import se.lexicon.flight.dao.AirlineDao;
import se.lexicon.flight.dao.FlightDao;
import se.lexicon.flight.dao.TicketDao;
import se.lexicon.flight.daoImpl.AirlineDaoImpl;
import se.lexicon.flight.daoImpl.FlightDaoImpl;
import se.lexicon.flight.daoImpl.TicketDaoImpl;
import se.lexicon.flight.domain.*;
import se.lexicon.flight.service.AirlineService;
import se.lexicon.flight.service.FlightService;
import se.lexicon.flight.service.TicketService;
import se.lexicon.flight.serviceImpl.AirlineServiceImpl;
import se.lexicon.flight.serviceImpl.FlightServiceImpl;
import se.lexicon.flight.serviceImpl.TicketServiceImpl;

import java.util.Collection;

public class ClientTest {

    // using Spring to avoid hard coding and provide loosely  coupling
    ApplicationContext applicationContext = new GenericXmlApplicationContext("ClientTire.xml","DaoTire.xml","serviceTire.xml");

    AirlineDao airlineDao = applicationContext.getBean(AirlineDao.class);
    FlightDao flightDao =applicationContext.getBean(FlightDao.class);
    TicketDao ticketDao =applicationContext.getBean(TicketDao.class);
    Client client =applicationContext.getBean(Client.class);

    // without spring
   /* AirlineDao airlineDao = new AirlineDaoImpl();
    FlightDao flightDao =new FlightDaoImpl();
    TicketDao ticketDao = new TicketDaoImpl();

    AirlineService airlineService =new AirlineServiceImpl(airlineDao);
    FlightService flightService=new FlightServiceImpl(flightDao);
    TicketService ticketService = new TicketServiceImpl(ticketDao);

    Client client = new ClientImpl(airlineService,flightService,ticketService);
*/
    @Test
    public void testSearchAirlineByName(){


        // create Airline

        Airline airline = Airline.builder().withId("001").withAirlineCode("AB389").withAirlineName("Sudan Airline").build();

        // Insert Airline to Dao
        airlineDao.addAirline(airline);

      //  A client  search Airline by airline Name
        System.out.println("Airline By Airline Name");

        Airline airline1 = client.searchAirlineByName("Sudan Airline");

       // Assert.assertEquals(airline,airline1);

        System.out.println(airline1);

    }

    @Test
    public void searchFlightByFlightName(){

        Flight flight= Flight.builder().withFlightNo("01")
                .withFlightName("Ethio Airway")
                .withAirline(Airline.builder()
                        .withId("1111")
                        .withAirlineName("Ethiopia Airline")
                        .withAirlineCode("ETH")
                        .build())
                .withClassType(ClassType.ECONOMY)
                .withFromCity("ADD")
                .withToCity("STO")
                .withDepartureDate("10-09-2019")
                .withTicketPrice(5000d)
                .withTrip(Trip.ONE_WAY)
                .withTotalSeat(10)
                .build();

        Flight flight2=Flight.builder().withFlightNo("AA1")
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
                .build();

         // Add Flight to Dao (Map)

        flightDao.addFlight(flight);
        flightDao.addFlight(flight2);

        // Fetch Flight from Dao(Map) by Flight Name

       Collection<Flight> flight1 = client.searchFlightByAirlineName("Ethiopia Airline");

      //  Assert.assertEquals(flight,flight1);
        System.out.println("Flight with flight Name " +flight1.iterator().next().getFlightName() );
        System.out.println(flight1);

        // Search Flight by

        System.out.println("===========================================================================================");
        System.out.println("Searching Flights By DepartureCity,ArriValCity and DepartureDate");

        Collection<Flight> flights1=client.searchFlightByCityAndDate("Dubai","London","09-09-2019");
        System.out.println(flights1);
    }

    @Test
    public void testBookTicket(){

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
                        .build()).withFood(Food.builder().withFoodName("Seafood paella, Spain").withFoodPrice(100d)
                        .build()).withSeat(Seat.builder().withSeatNo("BUO1").build()).build();


        ticketDao.bookTicket(ticket1);
        ticketDao.bookTicket(ticket2);

        // Search Ticket By Ticket No

        Ticket ticket = ticketDao.searchTicketByTicketNo("T02");


        System.out.println(ticket);

        Double t= ticketDao.ticketPrice("P1");
        System.out.println(t);

    }
}
