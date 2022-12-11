package com.example.eatssu;


import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class ReviewList {

    private String ID;
    private String context;
    private float rating;
    private String date;

    public ReviewList() {}

    public ReviewList(String ID, String context, float rating, String date){
        this.ID = ID;
        this.context = context;
        this.rating = rating;
        this.date = date;
    }



    public String getID(){ return ID;}

    public String getContext(){return context;}

    public float getRating(){return rating;}

    public String getDate(){return date;}

}


