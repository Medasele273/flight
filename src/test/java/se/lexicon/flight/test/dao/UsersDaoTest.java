package se.lexicon.flight.test.dao;

import org.junit.Test;
import se.lexicon.flight.dao.UsersDao;
import se.lexicon.flight.daoImpl.UsersImpl;
import se.lexicon.flight.domain.Users;

import java.util.Collection;

public class UsersDaoTest {

    @Test
    public void testAddUser(){
        UsersDao usersDao = new UsersImpl();

        //Create Users

        Users user1=Users.builder().withUserName("Admin").withPassword("Admin123").withRole("Admin").build();
        Users user2=Users.builder().withUserName("Client").withPassword("Client123").withRole("Client").build();
        Users user3=Users.builder().withUserName("User3").withPassword("user123").withRole("user").build();

        // Add Users to DataBase(Map)
        usersDao.addUser(user1);
        usersDao.addUser(user2);
        usersDao.addUser(user3);

        // Get All users that are in our dataBase(MaP)

        Collection<Users> users=usersDao.findListOfUsers();

        System.out.println(users);
    }
}
