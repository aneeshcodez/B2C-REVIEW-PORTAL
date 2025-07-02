package com.b2c.reviewportal.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
public class BusinessOwner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull(message = " Id cannot be null")
    private int id;

    @Column(nullable = false,unique = false)
    @NotNull(message = " Ownername cannot be null")
    private String ownerName;

    @Column(nullable = false)
    @NotNull(message = " password cannot be null")
    private String password;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Business_id")
    private Business business;

    //Getters and Setters

    public Business getBusinesses() {
        return business;
    }

    public void setBusinesses(Business business) {
        this.business = business;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "BusinessOwner{" +
                "id=" + id +
                ", ownerName='" + ownerName + '\'' +
                ", password='" + password + '\'' +
                ", business=" + business +
                '}';
    }
}
