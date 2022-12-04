package com.example.eatssu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class ReviewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review);
        Button buttonNext = findViewById(R.id.reviewGoButton);
        buttonNext.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(ReviewActivity.this,ReviewActivity2.class);
                startActivity(intent);
            }
        });

        //=========================테스트를 위한 더미데이터 생성=====================
        ArrayList<ReviewList> testDataSet = new ArrayList<>();

        for(int i=0;i<10;i++){
            testDataSet.add(new ReviewList("user", "이건 별로 맛이 없어요",(float) 3.0,2022,7,4));

//            private String userId;
//            private String reviewContext;
//            private int starRate;
//            private int year;
//            private int month;
//            private int day;
        }

        //===================================================================
        RecyclerView recyclerView = findViewById(R.id.reviewRecyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);

        recyclerView.setLayoutManager(linearLayoutManager); //LayoutManager 설정

        ReviewAdapter reviewAdapter = new ReviewAdapter(testDataSet);
        recyclerView.setAdapter(reviewAdapter);

        //addItem("1234","맛잇다",(float)4.0,2022,3,15);
    }

//    public void addItem(String userId, String reviewContext, float starRate, int year, int month, int day){
//        ReviewList reviewItem = new ReviewList(userId,reviewContext,starRate,year,month,day);
//        reviewItem.setUserId(userId);
//        reviewItem.setReviewContext(reviewContext);
//        reviewItem.setStarRate(starRate);
//        reviewItem.setYear(year);
//        reviewItem.setMonth(month);
//        reviewItem.setDay(day);
//    }


}