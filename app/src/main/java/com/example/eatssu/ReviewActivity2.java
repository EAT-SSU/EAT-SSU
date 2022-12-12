package com.example.eatssu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;

public class ReviewActivity2 extends AppCompatActivity {
    float sendRating;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review2);
        TextView menuName = findViewById(R.id.menu);
        Button buttonNext = findViewById(R.id.btnNext);
        Button btnTag1 =  findViewById(R.id.choose1);
        Button btnTag2 =  findViewById(R.id.choose2);
        Button btnTag3 =  findViewById(R.id.choose3);
        Button btnTag4 =  findViewById(R.id.choose4);
        Button btnTag5 =  findViewById(R.id.choose5);
        Button btnTag6 =  findViewById(R.id.choose6);
        Button btnTag7 =  findViewById(R.id.choose7);
        Button btnTag8 =  findViewById(R.id.choose8);
        Button btnTag9 =  findViewById(R.id.choose9);
        Button btnTag10 =  findViewById(R.id.choose10);


        RatingBar ratingBar = findViewById(R.id.ratingBar);
        TextView countstar = findViewById(R.id.countstar);
        Intent intent = getIntent();
        String getMenu = intent.getStringExtra("Menu");



        menuName.setText(getMenu);

        countstar.setText("0");

        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {

                countstar.setText((int)rating+"");
                sendRating=ratingBar.getRating();

            }

        });

        buttonNext.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(ReviewActivity2.this,ReviewActivity3.class);
                intent.putExtra("rating", sendRating);
                intent.putExtra("Menu",getMenu);
                startActivity(intent);
            }
        }
        );

      btnTag1.setOnClickListener(new View.OnClickListener() {
          boolean isBtn1Selected= false;
          @Override
          public void onClick(View v) {
              btnTag1.setSelected(!btnTag1.isSelected());
              isBtn1Selected=(!isBtn1Selected);
          }
      });

        btnTag2.setOnClickListener(new View.OnClickListener() {
            boolean isBtn2Selected= false;
            @Override
            public void onClick(View v) {
                btnTag2.setSelected(!btnTag2.isSelected());
                isBtn2Selected=(!isBtn2Selected);
            }
        });
        btnTag3.setOnClickListener(new View.OnClickListener() {
            boolean isBtn3Selected= false;
            @Override
            public void onClick(View v) {
                btnTag3.setSelected(!btnTag3.isSelected());
                isBtn3Selected=(!isBtn3Selected);
            }
        });
        btnTag4.setOnClickListener(new View.OnClickListener() {
            boolean isBtn4Selected= false;
            @Override
            public void onClick(View v) {
                btnTag4.setSelected(!btnTag4.isSelected());
                isBtn4Selected=(!isBtn4Selected);
            }
        });
        btnTag5.setOnClickListener(new View.OnClickListener() {
            boolean isBtn5Selected= false;
            @Override
            public void onClick(View v) {
                btnTag5.setSelected(!btnTag5.isSelected());
                isBtn5Selected=(!isBtn5Selected);
            }
        });
        btnTag6.setOnClickListener(new View.OnClickListener() {
            boolean isBtn6Selected= false;
            @Override
            public void onClick(View v) {
                btnTag6.setSelected(!btnTag6.isSelected());
                isBtn6Selected=(!isBtn6Selected);
            }
        });
        btnTag7.setOnClickListener(new View.OnClickListener() {
            boolean isBtn7Selected= false;
            @Override
            public void onClick(View v) {
                btnTag7.setSelected(!btnTag7.isSelected());
                isBtn7Selected=(!isBtn7Selected);
            }
        });
        btnTag8.setOnClickListener(new View.OnClickListener() {
            boolean isBtn8Selected= false;
            @Override
            public void onClick(View v) {
                btnTag8.setSelected(!btnTag8.isSelected());
                isBtn8Selected=(!isBtn8Selected);
            }
        });
        btnTag9.setOnClickListener(new View.OnClickListener() {
            boolean isBtn9Selected= false;
            @Override
            public void onClick(View v) {
                btnTag9.setSelected(!btnTag9.isSelected());
                isBtn9Selected=(!isBtn9Selected);
            }
        });
        btnTag10.setOnClickListener(new View.OnClickListener() {
            boolean isBtn10Selected= false;
            @Override
            public void onClick(View v) {
                btnTag10.setSelected(!btnTag10.isSelected());
                isBtn10Selected=(!isBtn10Selected);
            }
        });


    }


}