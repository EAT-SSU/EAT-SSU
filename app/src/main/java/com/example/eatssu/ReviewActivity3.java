package com.example.eatssu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ReviewActivity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review3);
        Button buttonNext = findViewById(R.id.registReviewBtn);
        buttonNext.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(ReviewActivity3.this,ReviewActivity.class);
                startActivity(intent);
            }
        });


    }


}