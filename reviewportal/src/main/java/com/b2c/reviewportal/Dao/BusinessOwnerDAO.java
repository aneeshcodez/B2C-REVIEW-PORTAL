package com.b2c.reviewportal.Dao;

import com.b2c.reviewportal.config.HibernateUtil;
import com.b2c.reviewportal.model.BusinessOwner;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class BusinessOwnerDAO {
    public static void registerOwner(BusinessOwner businessOwner){
        try {
            Session session = HibernateUtil.getSessionFactory()
                                           .openSession();
            Transaction transaction = session.beginTransaction();
            session.persist(businessOwner);
            transaction.commit();
            session.close();
        } catch (HibernateException e) {
            throw new RuntimeException(e);
        }
    }
    public static BusinessOwner fetchOwnerById(int id){
        BusinessOwner businessOwner;
        try {
            Session session = HibernateUtil.getSessionFactory()
                                            .openSession();
            Transaction transaction = session.beginTransaction();
            businessOwner = session.get(BusinessOwner.class,id);
            transaction.commit();
            session.close();
        } catch (HibernateException e) {
            throw new RuntimeException(e);
        }
        return businessOwner;
    }
    public static void updateOwner(int id,String ownername,String password){
        try {
            Session session = HibernateUtil.getSessionFactory()
                                           .openSession();
            Transaction transaction = session.beginTransaction();
            BusinessOwner businessOwner = session.get(BusinessOwner.class,id);
            if(ownername!=null){
                businessOwner.setOwnerName(ownername);
            }
            if(password!=null){
                businessOwner.setPassword(password);
            }
            transaction.commit();
            session.close();
        } catch (HibernateException e) {
            throw new RuntimeException(e);
        }

    }
    public static void deleteOwner(int id){
        try {
            Session session = HibernateUtil.getSessionFactory()
                                           .openSession();
            Transaction transaction = session.beginTransaction();
            BusinessOwner businessOwner = session.get(BusinessOwner.class,id);
            session.remove(businessOwner);
            transaction.commit();
            session.close();
        } catch (HibernateException e) {
            throw new RuntimeException(e);
        }
    }
}
