package com.example.firstapi.demo.controller;

import com.example.firstapi.demo.model.User;
import com.example.firstapi.demo.service.UserRepository;
import com.example.firstapi.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;



@RestController
public class UserController {
    @Autowired
    UserRepository userRepository;
//
//    private UserService userService;
//
//    @Autowired
//    public UserController(UserService userService) {
//        this.userService = userService;
//    }

//    @GetMapping(value = "/users")
//    public ResponseEntity<String> getUsers() {
//        List<User> userList = userService.getUserList();
//        return ResponseEntity.ok(userList.toString());
//    }

    @GetMapping(value = "/user/{id}")
    public ResponseEntity<User> getUserById (@PathVariable("id") String id)
    {
        //Optional<User> user = userService.getUser(id);
        Optional<User> user = userRepository.findUserById(id);

        if (user.isPresent()) {
            return new ResponseEntity<>(user.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

//    @PostMapping(value = "/createUser", consumes = "application/json", produces = "application/json")
//    public User createPerson(@RequestBody User user) {
//        return userService.addUser(user);
//    }

    @PostMapping(value = "/create", consumes = "application/json", produces = "application/json")
    public ResponseEntity<User> createPerson(@RequestBody User user) {
        try {
            User _user = userRepository.save(new User(user.getId(), user.getName(), user.getEmail()));
            return new ResponseEntity<>(_user, HttpStatus.CREATED);
        } catch(Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
//        if (userService.getUserList().contains(user)) {
//            return ResponseEntity.ok("User already exits.");
//        }
//        userService.addUser(user);
//        return ResponseEntity.ok("User created");
    }
}
