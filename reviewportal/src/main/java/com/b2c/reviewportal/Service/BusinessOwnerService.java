package com.b2c.reviewportal.Service;
import com.b2c.reviewportal.Dao.BusinessOwnerDAO;
import com.b2c.reviewportal.model.BusinessOwner;
import jakarta.validation.Valid;

public class BusinessOwnerService {

    public static void createOwner(@Valid BusinessOwner businessOwner){
        BusinessOwnerDAO.registerOwner(businessOwner);
    }

    public static void findOwnerById(Integer id){
        if(id!=null){
            BusinessOwnerDAO.fetchOwnerById(id);
        }
    }

    public static void updateOwner(Integer id,String ownername,String password){
        if (id!=null && ownername!=null && password !=null){
            BusinessOwnerDAO.updateOwner(id,ownername,password);

        }

    }

    public static void deleteOwner(Integer id){
        if(id!=null){
            BusinessOwnerDAO.deleteOwner(id);
        }

    }
}
