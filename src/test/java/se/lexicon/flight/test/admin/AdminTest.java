package se.lexicon.flight.test.admin;

import org.junit.Test;
import se.lexicon.flight.admin.Admin;
import se.lexicon.flight.admin.AdminImpl;
import se.lexicon.flight.dao.AirlineDao;
import se.lexicon.flight.dao.FlightDao;
import se.lexicon.flight.dao.PassengerDao;
import se.lexicon.flight.dao.UsersDao;
import se.lexicon.flight.daoImpl.AirlineDaoImpl;
import se.lexicon.flight.daoImpl.FlightDaoImpl;
import se.lexicon.flight.daoImpl.PassengerDaoImpl;
import se.lexicon.flight.daoImpl.UsersImpl;
import se.lexicon.flight.domain.*;
import se.lexicon.flight.test.service.AirlineServiceTest;

import java.util.Collection;

public class AdminTest {

    AirlineDao airlineDao = new AirlineDaoImpl();
    FlightDao flightDao = new FlightDaoImpl();
    PassengerDao passengerDao=new PassengerDaoImpl();
    UsersDao usersDao=new UsersImpl();
    Admin admin= new AdminImpl();

    @Test
    public void testAirline(){

        //To Add Air line To DAo (Map)

        Airline airline1=Airline.builder().withId("01").withAirlineCode("LH").withAirlineName("Lufthansa").build();
        Airline airline2=Airline.builder().withId("02").withAirlineCode("ETH").withAirlineName("Ethiopian Airline").build();

        // To Add Airlines to DAO
        airlineDao.addAirline(airline1);
        airlineDao.addAirline(airline2);

        // To get List Of Airline we have

        Collection<Airline> airlines =airlineDao.getAirlines();
        System.out.println("List of Airlines :");
        System.out.println(airlines);

        // To Remove AirLine

        airlineDao.removeAirlineByAirlineName("Ethiopian Airline");

        // List of Airlines After Removing Airline
        Collection<Airline> airlines1=airlineDao.getAirlines();
        System.out.println("List of Airlines After Removing :");
        System.out.println(airlines1);

    }

    @Test
    public void testFlight(){

        Flight flight1=Flight.builder().withFlightNo("EK1")
                .withFlightName("AirBus A380-800")
                .withAirline(Airline.builder()
                        .withId("01")
                        .withAirlineName("Emirates")
                        .withAirlineCode("UAE1")
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

        Flight flight3= Flight.builder().withFlightNo("ETH01")
                .withFlightName("Eth Airway")
                .withAirline(Airline.builder()
                        .withId("1111")
                        .withAirlineName("Ethiopia Airline")
                        .withAirlineCode("ETH")
                        .build())
                .withTrip(Trip.ONE_WAY)
                .withFromCity("ADD")
                .withToCity("STO")
                .withDepartureDate("20-09-2019")
                //.withReturningDate("30-09-2019")
                .withClassType(ClassType.BUSINESS)
                .withTicketPrice(20000d)
                .withTotalSeat(10)
                .build();

        // Add Flights to Dao(Map)

        flightDao.addFlight(flight1);
        flightDao.addFlight(flight2);
        flightDao.addFlight(flight3);
        System.out.println("===========================================================================================");
        System.out.println("List of Flights That we have " );
        Collection<Flight> flights = flightDao.getFlights();
        System.out.println(flights);
        System.out.println("============================================================================================");

        // To Remove Flights

        flightDao.cancelFlight("ETH01");
        System.out.println("List of Flights After Removing ");
        Collection<Flight> flights1=flightDao.getFlights();
        System.out.println(flights1);
    }
}
