package se.lexicon.flight.daoImpl;

import se.lexicon.flight.dao.UsersDao;
import se.lexicon.flight.domain.Users;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class UsersImpl implements UsersDao {

    private Map<String,Users> userList = new HashMap<>();

    @Override
    public void addUser(Users user) {
        if(userList.containsKey(user.getUserName())){
            throw new RuntimeException("User is Already Exist ");
        }
        userList.put(user.getUserName(),user);

    }

    @Override
    public Collection<Users> findListOfUsers() {
        return userList.values().stream().
                        map(user -> Users.builder()
                        .withUserName(user.getUserName())
                        .withPassword(user.getPassword())
                        .withRole(user.getRole()).build()).collect(Collectors.toList());
    }
}
