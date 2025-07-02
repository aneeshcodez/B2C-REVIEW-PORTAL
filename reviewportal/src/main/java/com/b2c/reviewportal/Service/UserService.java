package com.b2c.reviewportal.Service;

import com.b2c.reviewportal.Dao.UserDAO;
import com.b2c.reviewportal.model.User;
import jakarta.validation.Valid;

public class UserService {

    public static void addUser(@Valid User user){
        UserDAO.addUser(user);
    }

    public static void fetchUserById(Integer id){
        if(id!=null){
            UserDAO.retrieveUserById(id);
        }
    }

    public static void updateUser(Integer id,String username,String password){
        if(id!=null && username!=null && password !=null){
            UserDAO.updateUser(id,username,password);

        }

    }

    public static void deleteUser(Integer id){
        if(id!=null){
            UserDAO.deleteUser(id);
        }
    }
}
