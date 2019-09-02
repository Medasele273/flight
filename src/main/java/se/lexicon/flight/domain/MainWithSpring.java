package se.lexicon.flight.domain;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import se.lexicon.flight.dao.AirlineDao;
import se.lexicon.flight.dao.PassengerDao;
import se.lexicon.flight.logIn.LogIn;
import se.lexicon.flight.logIn.LoginClassImpl;

import java.applet.AppletContext;
import java.util.Optional;

public class MainWithSpring {

    public static void main(String arg[]){

         // To check Passenger is present or not
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


        LogIn logIn = new LoginClassImpl();
        Users admin = Users.builder().withUserName("Admin").withPassword("Admin123").withRole("Administrator").build();
        System.out.println("To Log In As Admin");
        logIn.logInAsAdmin(admin);

        System.out.println("===========================================");
        Users client = Users.builder().withUserName("Client").withPassword("Client123").withRole("Client").build();
        System.out.println("To Log In As Client");
        logIn.logInAsClient(client);
    }
}
