package com.example.eatssu;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.annotations.NotNull;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.ktx.Firebase;

import java.util.HashMap;
import java.util.Map;

public class ReviewActivity3 extends AppCompatActivity {
    private FirebaseFirestore db;
    private String reviewContext;
    private String userId;
    private String date;
    private String putReview;
    private Float putRate;
    FirebaseAuth auth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review3);
        Intent intent = getIntent();
        Float getRating = intent.getFloatExtra("rating",0);
        Button buttonNext = findViewById(R.id.registReviewBtn);
        db = FirebaseFirestore.getInstance();
        //TextView userId =  findViewById(R.id.userName);
        EditText writeReview = findViewById(R.id.editText1); //리뷰 입력칸

        auth = FirebaseAuth.getInstance();
        //UID=auth.getCurrentUser().getUid();
        userId="exampleUserId";
        date="2022-ex-ample";


        buttonNext.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Map<String, Object> data = new HashMap<>();
                putReview = writeReview.getText().toString();
                putRate = getRating;
                data.put("ID",userId);
                data.put("context",putReview);
                data.put("date",date);
                data.put("rating",putRate);
                db.collection("ReviewMenu").add(data)
                        .addOnSuccessListener(new OnSuccessListener() {
                            @Override
                            public void onSuccess(Object o) {
                                Log.d(TAG, "DocumentSnapshot added with ID: " + putReview);
                            }

                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull @NotNull Exception e) {
                                Log.w(TAG, "Error adding document", e);

                            }
                        });

                Intent intent = new Intent(ReviewActivity3.this,ReviewActivity.class);
                startActivity(intent);

            }
        });


    }


}