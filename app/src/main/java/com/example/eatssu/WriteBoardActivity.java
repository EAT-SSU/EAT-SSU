package com.example.eatssu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class WriteBoardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write_board);

        ImageButton backButton = (ImageButton) findViewById(R.id.btn_back);
        Button uploadBoardButton = (Button) findViewById(R.id.btn_uploadBoard);

        //뒤로가기
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent intetn = new Intent(SignUpActivity.this, MainActivity.class);

            }
        });

        //게시글 업로드
        uploadBoardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //text.setText(edit.getText());
                //replaceFragment(BoardFragment);

            }
        });

/*
        public void onFragmentChanged(int index){
            if(index == 0){
                getSupportFragmentManager().beginTransaction().replace(R.id.parentView,fragment02).commit();
            } else if(index == 1){
                getSupportFragmentManager().beginTransaction().replace(R.id.parentView,fragment01).commit();
            }
        }
*/

    }
}