package com.b2c.reviewportal.Dao;

import com.b2c.reviewportal.config.HibernateUtil;
import com.b2c.reviewportal.model.Business;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;



public class BusinessDAO {
    public static void createBusiness(Business business){
        Transaction transaction=null;
        try {
            Session session = HibernateUtil.getSessionFactory()
                                           .openSession();
            transaction = session.beginTransaction();
            session.persist(business);
            transaction.commit();
            session.close();
            // The thing is, In case of an Exception if we rollback the Transaction even before it was started ,it would give
            // us NullPointer Exception so we verify if the Transaction was started by verifying Transaction's Obj(transaction) is not null
        } catch (Exception e) {
            if (transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public static List<Business> fetchAllBusiness(){
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

    public static Business findBusinessByName(String name){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        String hql = "FROM Business WHERE name = :name";
        Query<Business> query = session.createQuery(hql, Business.class);
        query.setParameter("name",name);

        Business business = query.uniqueResult();
        transaction.commit();
        session.close();
        return business;

//        Transaction transaction=null;
//        Business businessObj = null;
//        try {
//            Session session = HibernateUtil.getSessionFactory()
//                                           .openSession();
//            transaction = session.beginTransaction();
//            businessObj = session.get(Business.class,id);
//            transaction.commit();
//            session.close();
//        }catch (Exception e) {
//            if (transaction != null){
//                transaction.rollback();
//            }
//            e.printStackTrace();
//        }
//        return businessObj;

    }

    public static void updateBusiness(int id , String name, String website){
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

    public static void deleteBusiness(int id){
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



