package com.example.eatssu;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

class ReviewList {
    private String userId;
    private String reviewContext;
    private float rating;
    private String date;

    private ReviewList() {}

    public ReviewList(String userId, String reviewContext, float rating, String date){
        this.userId = userId;
        this.reviewContext = reviewContext;
        this.rating = rating;
        this.date = date;
    }

    public String getUserId(){ return userId;}
    public void  setUserId(String userid){ this.userId = userid;}

    public String getReviewContext(){return reviewContext;}
    public void setReviewContext(String reviewContext){this.reviewContext = reviewContext;}

    public float getRating(){return rating;}
    public void setRating(float rating){this.rating=rating;}

    public String getDate(){return date;}
    public void setYear(int year){this.date=date;}


}


