package com.jc.restfulwebservices.socialmediaapp.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
public class Post {

    @Id
    @GeneratedValue
    private Integer id;

    private String description;

    // Map Post.java to a user
    // Each user (User.java) should have a list of posts (Post.java)
    @ManyToOne(fetch = FetchType.LAZY)  // When we fetch the post, we don't want to fetch the user details associated with the post; SN: Cannot do 'mappedBy' here
    @JsonIgnore // Don't want user to be returned in response bean
    private User user;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", description='" + description + '\'' +
                '}';
    }
}
