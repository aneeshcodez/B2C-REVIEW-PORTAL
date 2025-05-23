package com.b2c.reviewportal.model;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "app_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false,unique = false)
    private String username;
    @Column(nullable = false)
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