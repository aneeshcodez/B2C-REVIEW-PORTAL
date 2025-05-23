package com.b2c.reviewportal.Dao;
import com.b2c.reviewportal.config.HibernateUtil;
//import com.b2c.reviewportal.model.Businesses;
import com.b2c.reviewportal.model.Business;
import com.b2c.reviewportal.model.Review;
import com.b2c.reviewportal.model.User;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;


public class ReviewDAO {
    public static void addReview(Review review){
        try {
            Session session = HibernateUtil.getSessionFactory()
                    .openSession();
            Transaction transaction = session.beginTransaction();
            session.merge(review);
            transaction.commit();
            session.close();
        } catch (HibernateException e) {
            throw new RuntimeException(e);
        }

    }
    public static List<Review> fetchReviewsByBusiness(int business_id){
        try {
            Session session = HibernateUtil.getSessionFactory()
                                           .openSession();
            Transaction transaction = session.beginTransaction();

            Business business = session.get(Business.class,business_id);

            Hibernate.initialize(business.getReviewsOfBusiness());
            List<Review> reviewsOfBusiness = business.getReviewsOfBusiness();


            transaction.commit();
            session.close();

            System.out.println(reviewsOfBusiness);
            return reviewsOfBusiness;
        } catch (HibernateException e) {
            throw new RuntimeException(e);
        }



    }
    public static void deleteReview(int review_id){
        try {
            Session session = HibernateUtil.getSessionFactory()
                    .openSession();
            Transaction transaction = session.beginTransaction();
            User user = session.get(User.class,review_id);
            session.remove(user);
            transaction.commit();
            session.close();
        } catch (HibernateException e) {
            throw new RuntimeException(e);
        }

    }

}


