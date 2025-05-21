//package com.b2c.reviewportal.Dao;
//import com.b2c.reviewportal.config.HibernateUtil;
//import com.b2c.reviewportal.model.Businesses;
//import com.b2c.reviewportal.model.Review;
//import com.b2c.reviewportal.model.User;
//import org.hibernate.Session;
//import org.hibernate.Transaction;
//import jakarta.persistence.*;
//
//
//public class ReviewDAO {
//    public static void addReview(Review review, Businesses businesses){
//        Session session = HibernateUtil.getSessionFactory()
//                                       .openSession();
//        Transaction transaction = session.beginTransaction();
//        businesses.
//
//
//        session.persist(review);
//
//
//
//
//
//    }
//
//
//}



// For which busisness -> reviews are being posted?
// who is the user?

//1.Add a review
// add it in the list of reviews (for a particular business) how?
// add it the list of reviewsOfUser for a particular User
// Confusions:
//
