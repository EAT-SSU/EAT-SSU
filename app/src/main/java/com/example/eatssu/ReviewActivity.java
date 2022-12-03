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
        ArrayList<String> testDataSet = new ArrayList<>();

        for(int i=0;i<20;i++){
            testDataSet.add("Test Data" +i);
        }

        //===================================================================
        RecyclerView recyclerView = findViewById(R.id.reviewRecyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager((Context) this);

        recyclerView.setLayoutManager(linearLayoutManager); //LayoutManager 설정

        ReviewAdapter reviewAdapter = new ReviewAdapter(testDataSet);
        recyclerView.setAdapter(reviewAdapter);

    }


}