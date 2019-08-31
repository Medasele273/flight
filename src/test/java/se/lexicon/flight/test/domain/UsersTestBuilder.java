package se.lexicon.flight.test.domain;

import org.junit.Assert;
import org.junit.Test;
import se.lexicon.flight.domain.Users;
import se.lexicon.flight.logIn.LogIn;
import se.lexicon.flight.logIn.LoginClassImpl;

public class UsersTestBuilder {

    @Test
    public void usersTestBuilder(){

      LogIn loginClass = new LoginClassImpl();

        Users admin = Users.builder().withUserName("Admin").withPassword("Admin123").withRole("Administrator").build();

        Users client = Users.builder().withUserName("Client").withPassword("Client123").withRole("Client").build();

        Assert.assertEquals("Admin",admin.getUserName());

        Assert.assertEquals("Client",client.getUserName());

        System.out.println(admin);
        System.out.println();
        System.out.println(client);

      loginClass.logInAsAdmin(admin);


    }
}
