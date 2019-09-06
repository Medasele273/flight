package se.lexicon.flight.test.dao;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import se.lexicon.flight.dao.FlightDao;
import se.lexicon.flight.daoImpl.FlightDaoImpl;
import se.lexicon.flight.domain.Airline;
import se.lexicon.flight.domain.ClassType;
import se.lexicon.flight.domain.Flight;
import se.lexicon.flight.domain.Trip;

import java.util.Collection;
import java.util.Optional;

public class FlightDaoTest {

    @Test
    public void testAddFlight(){

        //  I have Tow Flights with different  Airlines but same DepartureCity ArrivalCity and DepartureDate
        // I have one Flight also which is different from the others

        ApplicationContext applicationContext = new GenericXmlApplicationContext("DaoTire.xml");
        FlightDao flightDao =applicationContext.getBean(FlightDao.class);

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


        // To display All the flights that we have in DataBase(Map)

        Collection<Flight> flights=flightDao.getFlights();
        System.out.println("Flights That Are Available in DataBase(Map) :");
        System.out.println(flights);

        // To search Flight By AirlineName
        System.out.println("===========================================================================================");

      Collection <Flight> flight=flightDao.searchFlightByAirlineName("Ethiopia Airline");
       Assert.assertEquals(flight.iterator().next().getAirline().getAirlineName(),flight3.getAirline().getAirlineName());
      // Assert.assertEquals(flight,flight3);
        System.out.println("Available Flights by AirlineName");
       System.out.println(flight);
       System.out.println();
       System.out.println("===========================================================================================");
        System.out.println("Searching Flights By DepartureCity,ArriValCity and DepartureDate");

        Collection<Flight> flights1=flightDao.searchFlightByCityAndDate("ADD","STO","20-09-2019");
        System.out.println(flights1);


    }
}
