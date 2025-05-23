package com.b2c.reviewportal.model;

import jakarta.persistence.*;

@Entity
public class BusinessOwner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false,unique = false)
    private String ownerName;

    @Column(nullable = false)
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
