package se.lexicon.flight.logIn;

import se.lexicon.flight.domain.Users;

public interface LogIn {

    void logInAsAdmin(Users user);

    void logInAsClient(Users user);
}
