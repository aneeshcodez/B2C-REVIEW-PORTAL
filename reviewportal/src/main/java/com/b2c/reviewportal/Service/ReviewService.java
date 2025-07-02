package com.b2c.reviewportal.Service;

import com.b2c.reviewportal.Dao.ReviewDAO;
import com.b2c.reviewportal.model.Review;
import jakarta.validation.Valid;

public class ReviewService {

    public static void addReview(@Valid Review review){
        ReviewDAO.addReview(review);
    }

    public static void findReviewsByBusiness(Integer business_id){
        if(business_id!=null){
            ReviewDAO.fetchReviewsByBusiness(business_id);
        }
    }

    public static void deleteReview(Integer review_id){
        if(review_id!=null){
            ReviewDAO.deleteReview(review_id);
        }
    }

}
