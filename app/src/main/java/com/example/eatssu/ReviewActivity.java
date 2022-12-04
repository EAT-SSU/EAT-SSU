package com.example.eatssu;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;

import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.List;

public class ReviewActivity extends AppCompatActivity {
    private RecyclerView recyclerView;

    private RecyclerView.Adapter adapter;
    private ArrayList<ReviewList> arrayList = new ArrayList<>();


    private FirebaseAuth auth;
    private FirebaseFirestore db;
    private DocumentReference docRef;

    private String userId;
    private String reviewContext;
    private float rating;
    private String date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review);
        Button buttonNext = findViewById(R.id.reviewGoButton);
        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ReviewActivity.this, ReviewActivity2.class);
                startActivity(intent);
            }
        });


        //=========================테스트를 위한 더미데이터 생성=====================
//        ArrayList<ReviewList> testDataSet = new ArrayList<>();
//
//        for(int i=0;i<10;i++){
//            testDataSet.add(new ReviewList("user", "이건 별로 맛이 없어요",(float) 3.0,"2022-07-04"));
//        }

        //===================================================================



        recyclerView = findViewById(R.id.reviewRecyclerView);
        arrayList = new ArrayList<>();

        recyclerView.setLayoutManager(new LinearLayoutManager(this)); //LayoutManager 설정

        adapter = new ReviewAdapter(arrayList);

        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);



    }


}

