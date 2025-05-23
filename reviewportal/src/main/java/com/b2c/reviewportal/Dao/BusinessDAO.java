package com.b2c.reviewportal.Dao;

import com.b2c.reviewportal.config.HibernateUtil;
import com.b2c.reviewportal.model.BusinessOwner;
import com.b2c.reviewportal.model.Business;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

/** Start by writing a method to save a new Businesses object to the database.*/

public class BusinessDAO {
    public static void createBusiness(Business business, BusinessOwner businessOwner){
        Transaction transaction=null;
        try {
            Session session = HibernateUtil.getSessionFactory()
                                           .openSession();
            transaction = session.beginTransaction();
            session.persist(business);
            transaction.commit();
            session.close();
        } catch (Exception e) {
            if (transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public static List<Business> fetchAllBusinesses(){
        List<Business> businessList = new ArrayList<>();
        Transaction transaction=null;
        try {
            String hib = "FROM Businesses";
            Session session = HibernateUtil.getSessionFactory()
                                           .openSession();
            transaction = session.beginTransaction();
            Query query = session.createQuery(hib, Business.class);
            businessList = query.list();
            transaction.commit();
            session.close();
        } catch (Exception e) {
            if (transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return businessList;
    }

    public static Business findBusinessById(int id){
        Transaction transaction=null;
        Business businessObj = null;
        try {
            Session session = HibernateUtil.getSessionFactory()
                                           .openSession();
            transaction = session.beginTransaction();
            businessObj = session.get(Business.class,id);
            transaction.commit();
            session.close();
        }catch (Exception e) {
            if (transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return businessObj;

    }

    public static void updateBusinesses(int id ,String name,String website){
        try {
            Session session = HibernateUtil.getSessionFactory()
                                           .openSession();
            Transaction transaction = session.beginTransaction();
            Business business = session.get(Business.class,id);
            if(name!=null){
                business.setName(name);
            }
            if(website!=null){
                business.setWebsite(website);
            }
            transaction.commit();
            session.close();
        } catch (HibernateException e) {
            throw new RuntimeException(e);
        }
    }

    public static void deleteBusinesses(int id){
        try {
            Session session = HibernateUtil.getSessionFactory()
                                            .openSession();
            Transaction transaction = session.beginTransaction();
            Business business = session.get(Business.class,id);
            session.remove(business);
            transaction.commit();
            session.close();
        } catch (HibernateException e) {
            throw new RuntimeException(e);
        }
    }

}



