package com.b2c.reviewportal.Testing;
import com.b2c.reviewportal.Dao.UserDAO;
import com.b2c.reviewportal.config.HibernateUtil;
import com.b2c.reviewportal.model.User;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class BusinessTest {
    public static void main(String[] args) {
        UserDAO.deleteUser(4);


    }
}


