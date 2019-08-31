package se.lexicon.flight.dao;

import se.lexicon.flight.domain.Users;

import java.util.Collection;

public interface UsersDao {

    void addUser(Users user);

    Collection<Users> findListOfUsers();
}
