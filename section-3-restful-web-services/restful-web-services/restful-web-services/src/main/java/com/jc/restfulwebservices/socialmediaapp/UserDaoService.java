package com.jc.restfulwebservices.socialmediaapp;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Component
public class UserDaoService {
    // Creating a static list to act as a database for now. Add to list with a static block.
    private static List<User> users = new ArrayList<>();

    private static int usersCount = 0;

    static {
        users.add(new User(++usersCount, "Adam", LocalDate.now().minusYears(30)));
        users.add(new User(++usersCount, "Eve", LocalDate.now().minusYears(25)));
        users.add(new User(++usersCount, "Jim", LocalDate.now().minusYears(20)));
    }

    public List<User> findAll() {
        return users;
    }

    public User findUserById(int id) {
        Predicate<? super User> predicate = user -> user.getId().equals(id);  // Checks if id of a user is equal to the id that is passed in
        return users.stream().filter(predicate).findFirst().orElse(null);  // Filtering a list based on a predicate
    }

    public User save(User user) {
        user.setId(++usersCount);
        users.add(user);
        return user;
    }

    public void deleteUserById(int id) {
        Predicate<? super User> predicate = user -> user.getId().equals(id);  // Checks if id of a user is equal to the id that is passed in
        users.removeIf(predicate);
    }

}
