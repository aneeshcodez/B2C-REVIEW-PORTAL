package com.b2c.reviewportal.Testing;
import com.b2c.reviewportal.Dao.BusinessOwnerDAO;
import com.b2c.reviewportal.Dao.UserDAO;
import com.b2c.reviewportal.config.HibernateUtil;
import com.b2c.reviewportal.model.BusinessOwner;
import com.b2c.reviewportal.model.Businesses;
import com.b2c.reviewportal.model.Review;
import com.b2c.reviewportal.model.User;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class BusinessTest {
    public static void main(String[] args) {
        Businesses business = new Businesses();
        business.setName("foodpanda");
        business.setWebsite("foodpanda.com");
        business.setIndustry("Tech");

        //1.
        // Create a BusinessOwner instance
        BusinessOwner owner = new BusinessOwner();
        owner.setOwnerName("dayalan");
        owner.setPassword("day76");
        //Linking Owner to Business(I missed it)
        owner.setBusinesses(business);
        business.setBusinessOwner(owner);

        //2.
        Review review = new Review();
        review.setComment("good");
        review.setRating(4);
        review.setBusinesses(business);
        business.getReviewsOfBusiness().add(review);

        //3.
        User user = new User();
        user.setUsername("raina");
        user.setPassword("byeee");
        user.getReviewsOfUser().add(review);
        review.setUser(user);

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        session.persist(owner);
        session.persist(business);
        session.persist(review);
        transaction.commit();


        session.close();



    }

}


