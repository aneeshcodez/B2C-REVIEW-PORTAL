package com.b2c.reviewportal.Testing;
import com.b2c.reviewportal.Dao.BusinessDAO;
import com.b2c.reviewportal.Dao.BusinessOwnerDAO;
import com.b2c.reviewportal.Dao.ReviewDAO;
import com.b2c.reviewportal.config.HibernateUtil;
import com.b2c.reviewportal.model.BusinessOwner;
import com.b2c.reviewportal.model.Business;
import com.b2c.reviewportal.model.Review;
import com.b2c.reviewportal.model.User;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Testing {
    public static void main(String[] args) {

        Business business = new Business();
        business.setName("ewfwwwiggy");
        business.setWebsite("rfwfwiggy.com");
        business.setIndustry("Tech");

        BusinessOwner owner = new BusinessOwner();
        owner.setOwnerName("wrfwroki");
        owner.setPassword("lorfwwwk76");

        Review review = new Review();
        review.setComment("OfwKAwY");
        review.setRating(2);

        User user = new User();
        user.setUsername("shawkfjy");
        user.setPassword("swrei");

        owner.setBusinesses(business);
        business.setBusinessOwner(owner);
        review.setBusinesses(business);
        review.setUser(user);

        BusinessOwnerDAO.registerOwner(owner);
        ReviewDAO.addReview(review);


    }

}





