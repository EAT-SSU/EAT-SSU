package com.example.eatssu;

import java.util.ArrayList;

class ReviewList {
    private String userId;
    private String reviewContext;
    private float rating;
    private int year;
    private int month;
    private int day;

    public ReviewList(String userId, String reviewContext, float rating, int year, int month, int day){
        this.userId = userId;
        this.reviewContext = reviewContext;
        this.rating = rating;
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public String getUserId(){ return userId;}
    public void  setUserId(String userid){ this.userId = userid;}

    public String getReviewContext(){return reviewContext;}
    public void setReviewContext(String reviewContext){this.reviewContext = reviewContext;}

    public float getRating(){return rating;}
    public void setRating(float rating){this.rating=rating;}

    public int getYear(){return year;}
    public void setYear(int year){this.year=year;}

    public int getMonth(){return month;}
    public void setMonth(int month){this.month=month;}

    public int getDay(){return day;}
    public void setDay(int day){this.day=day;}


}


