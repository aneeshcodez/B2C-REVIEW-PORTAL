package com.b2c.reviewportal.Dao;

import com.b2c.reviewportal.config.HibernateUtil;
import com.b2c.reviewportal.model.Businesses;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

/** Start by writing a method to save a new Businesses object to the database.*/

public class BusinessesDAO {
    public static void saveBusinessObj(Businesses businesses){
        Transaction transaction=null;
        try {
            Session session = HibernateUtil.getSessionFactory()
                                           .openSession();
            transaction = session.beginTransaction();
            session.save(businesses);
            transaction.commit();
            session.close();
        } catch (Exception e) {
            if (transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public static List<Businesses> fetchAllBusinesses(){
        List<Businesses> businessesList = new ArrayList<>();
        Transaction transaction=null;
        try {
            String hib = "FROM Businesses";
            Session session = HibernateUtil.getSessionFactory()
                                           .openSession();
            transaction = session.beginTransaction();
            Query query = session.createQuery(hib,Businesses.class);
            businessesList = query.list();
            transaction.commit();
            session.close();
        } catch (Exception e) {
            if (transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return businessesList;
    }

    public static Businesses findBusinessById(int id){
        Transaction transaction=null;
        Businesses businessesObj = null;
        try {
            Session session = HibernateUtil.getSessionFactory()
                                           .openSession();
            transaction = session.beginTransaction();
            businessesObj = session.get(Businesses.class,id);
            transaction.commit();
            session.close();
        }catch (Exception e) {
            if (transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return businessesObj;

    }

}



