package com.jc.restfulwebservices.socialmediaapp.repositories;

import com.jc.restfulwebservices.socialmediaapp.entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Integer> {

}