package com.jc.restfulwebservices.socialmediaapp;

import com.jc.restfulwebservices.socialmediaapp.entities.Post;
import com.jc.restfulwebservices.socialmediaapp.entities.User;
import com.jc.restfulwebservices.socialmediaapp.exceptions.UserNotFoundException;
import com.jc.restfulwebservices.socialmediaapp.repositories.PostRepository;
import com.jc.restfulwebservices.socialmediaapp.repositories.UserJpaRepository;
import jakarta.validation.Valid;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
public class UserJpaController {
    //private UserDaoService service;  // Don't need this anymore because JPA repository is used now

    private UserJpaRepository userRepository;
    private PostRepository postRepository;
    public UserJpaController(UserJpaRepository userRepository, PostRepository postRepository) {
        this.userRepository = userRepository;
        this.postRepository = postRepository;
    }

    @GetMapping("/jpa/users")
    public List<User> retrieveAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/jpa/users/{id}")
    public EntityModel<User> retrieveUser(@PathVariable int id) {
        Optional<User> user = userRepository.findById(id);

        if (user.isEmpty()) {
            throw new UserNotFoundException("id: " + id);
        }

        EntityModel<User> entityModel = EntityModel.of(user.get());
        WebMvcLinkBuilder link = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).retrieveAllUsers());
        entityModel.add(link.withRel("all-users"));
        return entityModel;
    }

    @PostMapping("/jpa/users")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
        User savedUser = userRepository.save(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()  // get current path e.g. "/jpa/users"...
                        .path("/{id}")// ...and add "/{id}" path...
                        .buildAndExpand(savedUser.getId()) // ...and replace id with the created user's id
                        .toUri();  // convert to URI, which you can see in header of the response
        return ResponseEntity.created(location).build();  // Can see "201 Created" in response status
    }

    @DeleteMapping("/jpa/users/{id}")
    public void deleteUser(@PathVariable int id) {
        userRepository.deleteById(id);
    }

    @GetMapping("/jpa/users/{id}/posts")
    public List<Post> retrievePostsForUser(@PathVariable int id) {
        // Find user. If user exists, find the user's posts.
        Optional<User> user = userRepository.findById(id);
        if(user.isEmpty()) {
            throw new UserNotFoundException("id: " + id);
        }

        return user.get().getPosts();
    }

    @PostMapping("/jpa/users/{id}/posts")
    public ResponseEntity<Post> createPostForUser(@PathVariable int id, @Valid @RequestBody Post post) {  // A method to create a post
        // Find user. If user exists, set the user to their post.
        Optional<User> user = userRepository.findById(id);
        if(user.isEmpty()) {
            throw new UserNotFoundException("id: " + id);
        }

        post.setUser(user.get());
        Post savedPost = postRepository.save(post);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()  // get current path e.g. "/jpa/users/{id}/posts"...
                .path("/{id}")// ...and add "/{id}" path...
                .buildAndExpand(savedPost.getId()) // ...and replace id with the found user's id
                .toUri();  // convert to URI, which you can see in header of the response
        return ResponseEntity.created(location).build();
    }
}
