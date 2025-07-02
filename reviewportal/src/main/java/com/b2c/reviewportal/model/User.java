package com.b2c.reviewportal.model;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "app_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull(message = " Id cannot be null")
    private int id;
    @Column(nullable = false,unique = false)
    @NotNull(message = " Id cannot be null")
    private String username;
    @Column(nullable = false)
    @NotNull(message = " Id cannot be null")
    private String password;
    @OneToMany(mappedBy = "user")
    List<Review> reviewsOfUser = new ArrayList<>();


//Getters and Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public List<Review> getReviewsOfUser() {
        return reviewsOfUser;
    }
    public void setReviewsOfUser(List<Review> reviewsOfUser) {
        this.reviewsOfUser = reviewsOfUser;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", reviewsOfUser=" + reviewsOfUser +
                '}';
    }
}