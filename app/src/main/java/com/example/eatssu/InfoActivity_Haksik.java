package com.example.eatssu;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;

public class InfoActivity_Haksik extends AppCompatActivity implements View.OnClickListener {
    private ImageButton mapBtn;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_info_haksik);

        mapBtn = findViewById(R.id.btn_map);
        mapBtn.setOnClickListener(this);

    }
    @Override
    public void onClick(View v) {

        if (v == mapBtn) { // 지도 연동
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:37.497103,126.956785"));
            startActivity(intent);
        }
    }

}