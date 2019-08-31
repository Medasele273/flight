package se.lexicon.flight.logIn;

import se.lexicon.flight.admin.Admin;
import se.lexicon.flight.client.Client;
import se.lexicon.flight.domain.Users;

import java.util.Scanner;

public class LoginClassImpl implements LogIn{

    private static Scanner scanner = new Scanner((System.in));
    private static String admin;
    private static String password;
    private static String client;
  //  private static Users user;



    @Override
    public void logInAsAdmin(Users user) {

        boolean flag =false;

        do {
            System.out.println("Enter User Name");
            admin = scanner.nextLine();
            System.out.println("Enter Password");
            password = scanner.nextLine();

            if (user.getUserName().equals(admin) && user.getPassword().equals(password)) {
                System.out.println("You logged in As Administrator");
                       break;

            } else if (!user.getUserName().equals(admin) && user.getPassword().equals(password)) {
                System.out.println("You Entered wrong User Name");
                       flag=true;

            }else if(!user.getUserName().equals(admin) && !user.getPassword().equals(password)){
                System.out.println("You Entered wrong User Name and password");
                       flag=true;
            }else {

            }

        }while (flag);
    }


    @Override
    public void logInAsClient(Users user) {

        boolean flag =false;

        do {
            System.out.println("Enter User Name");
            client = scanner.nextLine();
            System.out.println("Enter Password");
            password = scanner.nextLine();

            if (user.getUserName().equals(client) && user.getPassword().equals(password)) {
                System.out.println("You logged in As Client");
                  break;

            } else if (!user.getUserName().equals(client) && user.getPassword().equals(password)) {
                System.out.println("You Entered wrong User Name");

            }else if(!user.getUserName().equals(client) && !user.getPassword().equals(password)){
                System.out.println("You Entered wrong User Name and password");
            }else {
                System.out.println("");
            }

        }while (!flag);
    }

}

