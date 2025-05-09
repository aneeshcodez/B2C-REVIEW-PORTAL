package com.b2c.reviewportal.Dao;

import com.b2c.reviewportal.config.HibernateUtil;
import com.b2c.reviewportal.model.User;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class UserDAO {
    public static void addUser(User user){
        try {
            Session session = HibernateUtil.getSessionFactory()
                                           .openSession();
            Transaction transaction = session.beginTransaction();
            session.persist(user);
            transaction.commit();
            session.close();
        } catch (HibernateException e) {
            throw new RuntimeException(e);
        }

    }
}

// If you want test mannualy from test file
// How to wrap addUser with Try/Catch and handle errors properly with proper error message
// For this 2nd step ask Gpt ,how it is done usally for persisting something into DB and for all CRUD operations too


