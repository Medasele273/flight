package se.lexicon.flight.domain;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import se.lexicon.flight.client.Client;
import se.lexicon.flight.client.ClientImpl;
import se.lexicon.flight.dao.AirlineDao;
import se.lexicon.flight.dao.FlightDao;
import se.lexicon.flight.dao.PassengerDao;
import se.lexicon.flight.dao.TicketDao;
import se.lexicon.flight.daoImpl.FlightDaoImpl;
import se.lexicon.flight.daoImpl.TicketDaoImpl;
import se.lexicon.flight.logIn.LogIn;
import se.lexicon.flight.logIn.LoginClassImpl;

import java.applet.AppletContext;
import java.util.Collection;
import java.util.Optional;

public class MainWithSpring {

    public static void main(String arg[]){


         // To check Passenger is present or not
        System.out.println("To Check if A Passenger is present");
        ApplicationContext applicationContext = new GenericXmlApplicationContext("DaoTire.xml","serviceTire.xml");
        PassengerDao passengerDao =applicationContext.getBean(PassengerDao.class);

        Optional<Passenger> optional = passengerDao.searchAndGetPassengerById("P1");
        System.out.println("isPresent:" + optional.isPresent());

        passengerDao.addPassenger(Passenger.builder().withPassengerId("P1")
        .withPassengerFirstName("Medhanie").withPassengerLastName("Weldeab").withEmail("aaaabbbab@gmail.com").build());

        optional =passengerDao.searchAndGetPassengerById("P1");
        System.out.println("isPresent:" + optional.isPresent());
        System.out.println(optional);

        // To ADD AirLine To our DataBase in our case MAP and  search Airline by Airline name
        System.out.println("=====================================================================================================================");
        AirlineDao airlineDao = applicationContext.getBean(AirlineDao.class);
        Airline airline1=Airline.builder().withId("01").withAirlineCode("LH").withAirlineName("Lufthansa").build();
        Airline airline2=Airline.builder().withId("02").withAirlineCode("ETH").withAirlineName("Ethiopian Airline").build();
        airlineDao.addAirline(airline1);
        airlineDao.addAirline(airline2);

        Airline airline3 =  airlineDao.searchAirlineByName("Lufthansa");
        System.out.println(airline3);

        TicketDao ticketDao =applicationContext.getBean(TicketDao.class);
        FlightDao flightDao =applicationContext.getBean(FlightDao.class);


        LogIn logIn = new LoginClassImpl();
      //  TicketDao ticketDao =new TicketDaoImpl();
       // FlightDao flightDao= new FlightDaoImpl();

        Users admin = Users.builder().withUserName("Admin").withPassword("Admin123").withRole("Administrator").build();
        System.out.println("To Log In As Admin");

        logIn.logInAsAdmin(admin);

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
                        .build()).withFood(Food.builder().withFoodName("Sea Food").withFoodPrice(1000d)
                        .build()).withSeat(Seat.builder().withSeatNo("ECO1").build()).build();
        ticketDao.bookTicket(ticket1);
        Double t= ticketDao.ticketPrice("P1");
        System.out.println("Ticket Price for one Person is :");
        System.out.println(t);

        System.out.println("===========================================");
        Users client1 = Users.builder().withUserName("Client").withPassword("Client123").withRole("Client").build();

        System.out.println("To Log In As Client");
        logIn.logInAsClient(client1);

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

        Collection<Flight> flight1 = flightDao.searchFlightByAirlineName("Ethiopia Airline");

        //  Assert.assertEquals(flight,flight1);
        System.out.println("Flight with flight Name " +flight1.iterator().next().getFlightName() );
        System.out.println(flight1);

        // Search Flight by

        System.out.println("===========================================================================================");
        System.out.println("Searching Flights By DepartureCity,ArriValCity and DepartureDate");

        Collection<Flight> flights1=flightDao.searchFlightByCityAndDate("Dubai","London","09-09-2019");
        System.out.println(flights1);
    }

}

