package com.b2c.reviewportal.model;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

/** Create a Java class Business under the model package, and annotate it
 with the necessary Hibernate annotations to map it to a businesses table.*/

@Entity
public class Business {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true)
    private String name;
    @Column(nullable = false, unique = true)
    private String website;
    @Column(nullable = false)
    private String industry;
    @OneToOne(mappedBy = "business")
    private BusinessOwner businessOwner;
    @OneToMany(mappedBy = "business",cascade = CascadeType.ALL)
    public List<Review> reviewsOfBusiness = new ArrayList<>();


    //Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public BusinessOwner getBusinessOwner() {
        return businessOwner;
    }

    public void setBusinessOwner(BusinessOwner businessOwner) {
        this.businessOwner = businessOwner;
    }
    public List<Review> getReviewsOfBusiness() {
        return reviewsOfBusiness;
    }

    @Override
    public String toString() {
        return "Business{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", website='" + website + '\'' +
                ", industry='" + industry + '\'' +
                ", businessOwner=" + businessOwner +
                ", reviewsOfBusiness=" + reviewsOfBusiness +
                '}';
    }
}


