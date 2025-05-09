package com.b2c.reviewportal.config;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**The purpose of this class is to create a single instance
of SessionFactory which can be reused by the rest of the app*/

public class HibernateUtil {

    private static SessionFactory sessionFactory;

    // block of code that runs only once
    static{
        try {
            //Setting up Hibernate Manually
            Configuration config = new Configuration();
            config.configure("hibernate.cfg.xml");
            sessionFactory = config.buildSessionFactory();
        } catch (HibernateException e) {
            throw new RuntimeException(e);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}

