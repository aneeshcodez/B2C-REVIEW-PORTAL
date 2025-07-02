package com.b2c.reviewportal.Service;
import com.b2c.reviewportal.Dao.BusinessDAO;
import com.b2c.reviewportal.model.Business;
import jakarta.validation.Valid;

public class BusinessService {

    public static void registerBusiness(@Valid Business business){
        BusinessDAO.createBusiness(business);

    }

    public static void fetchAllBusiness(){
        BusinessDAO.fetchAllBusiness();
    }

    public static void fetchBusinessByName(String name){
        if(name!=null){
            BusinessDAO.findBusinessByName(name);
        }


    }

    public static void updateBusiness(Integer id , String name, String website){
        if (id!=null && name!=null && website !=null){
            BusinessDAO.updateBusiness( id , name,  website);

        }
    }

    public static void deleteBusiness(Integer id){
        if(id!=null){
            BusinessDAO.deleteBusiness(id);
        }

    }



}

// Service Layer must do :
//Validates data
//Applies business rules or conditions
//Calls DAO to talk to the database

//Get business details by name
//what to do if they 12.3 instead of 12 ,How and when should I handle that




