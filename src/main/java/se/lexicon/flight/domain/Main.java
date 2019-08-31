package se.lexicon.flight.domain;

import se.lexicon.flight.logIn.LogIn;
import se.lexicon.flight.logIn.LoginClassImpl;

public class Main {

    public static void main(String arg[]){

        LogIn logIn = new LoginClassImpl();
        Users admin = Users.builder().withUserName("Admin").withPassword("Admin123").withRole("Administrator").build();
        //logIn.logInAsAdmin(admin);

        System.out.println("===========================================");
        Users client = Users.builder().withUserName("Client").withPassword("Client123").withRole("Client").build();

        logIn.logInAsClient(client);
    }
}