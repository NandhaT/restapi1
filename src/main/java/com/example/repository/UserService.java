package com.example.repository;

import com.example.model.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

@Service("userService")
public class UserService {
    private final List<User> userList;

    public UserService() {
        userList = new ArrayList<>();

//        User user1 = new User(1, "Nandha", "Nandha@gmail.com");
//        User user2 = new User(2, "Nikhil", "Nikhil@gmail.com");
//        User user3 = new User(3, "Daniel", "Daniel@gmail.com");
//        User user4 = new User(4, "Rishi", "Rishi@gmail.com");
//        User user5 = new User(5, "Pranav", "Pranav@gmail.com");
//
//        userList.addAll(Arrays.asList(user1, user2, user3, user4, user5));

    }

    public Optional<User> getUser(String id) {
        Optional optional = Optional.empty();
        for (User user: userList) {
            if (id.equals(user.getId())) {
                optional = Optional.of(user);
                return optional;
            }
        }
        return optional;
    }

    public User addUser(User user) {
        userList.add(user);
        return user;
    }

    public List<User> getUserList() {
        return userList;
    }
}
