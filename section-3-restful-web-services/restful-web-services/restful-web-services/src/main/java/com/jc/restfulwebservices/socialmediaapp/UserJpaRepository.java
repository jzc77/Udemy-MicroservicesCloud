package com.jc.restfulwebservices.socialmediaapp;

import com.jc.restfulwebservices.socialmediaapp.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserJpaRepository extends JpaRepository<User, Integer> {

}
