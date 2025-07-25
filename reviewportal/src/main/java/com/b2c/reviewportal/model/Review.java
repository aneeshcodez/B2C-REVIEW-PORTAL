package com.b2c.reviewportal.model;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull(message = " Id cannot be null")
    private int id;

    @Column(nullable = false, length = 1000)
    @NotNull(message = " Comment cannot be null")
    private String comment;

    @Column(nullable = false)
    @NotNull(message = " rating cannot be null")
    private int rating;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "business_id")
    private Business business;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "User_id")
    private User user;


//Getters and setters


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
    public Business getBusinesses() {
        return business;
    }

    public void setBusinesses(Business business) {
        this.business = business;
    }
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    @Override
    public String toString() {
        return "Review{" +
                "id=" + id +
                ", comment='" + comment + '\'' +
                ", rating=" + rating +
                ", business=" + business +
                ", user=" + user +
                '}';
    }
}
