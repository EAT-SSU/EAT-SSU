package com.example.eatssu;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;

public class InfoActivity_Dodam extends AppCompatActivity implements View.OnClickListener {
    private ImageButton mapBtn;

    @SuppressLint("MissingInflatedId")

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_info_dodam);

        mapBtn = findViewById(R.id.btn_map_dodam);
        mapBtn.setOnClickListener((View.OnClickListener) this);
    }
    @Override
    public void onClick(View view) {

        if (view == mapBtn) { // 지도 연동
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:37.49641,126.95818"));
            startActivity(intent);
        }

    }
}