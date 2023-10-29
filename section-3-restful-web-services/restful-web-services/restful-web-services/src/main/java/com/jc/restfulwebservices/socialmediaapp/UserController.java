package com.jc.restfulwebservices.socialmediaapp;

import com.jc.restfulwebservices.socialmediaapp.exceptions.UserNotFoundException;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class UserController {  // The video calls this class "UserResource"
    private UserDaoService service;

    public UserController(UserDaoService service) {
        this.service = service;
    }

    @GetMapping("/users")
    public List<User> retrieveAllUsers() {
        return service.findAll();
    }

    @GetMapping("/users/{id}")
    public User retrieveUser(@PathVariable int id) {
        User user = service.findUserById(id);

        if (user == null) {
            throw new UserNotFoundException("id: " + id);
        }

        return user;
    }

    @PostMapping("/users")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
        User savedUser = service.save(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()  // get current path e.g. "/users"...
                        .path("/{id}")// ...and add "/{id}" path...
                        .buildAndExpand(savedUser.getId()) // ...and replace id with the created user's id
                        .toUri();  // convert to URI, which you can see in header of the response
        return ResponseEntity.created(location).build();  // Can see "201 Created" in response status
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable int id) {
        service.deleteUserById(id);
    }
}
