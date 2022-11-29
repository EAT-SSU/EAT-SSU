package com.example.eatssu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.HashMap;

public class SignUpActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        mAuth = FirebaseAuth.getInstance();
        findViewById(R.id.btn_summit).setOnClickListener(onClickListener);
    }


    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (v.getId() == R.id.btn_summit) {
                signUp();
            }
        }
    };


    private void signUp(){
        String email=((EditText)findViewById(R.id.edt_sEmailAddress)).getText().toString().trim();
        String password=((EditText)findViewById(R.id.et_Password)).getText().toString().trim();
        String passwordCheck=((EditText)findViewById(R.id.edt_Password2)).getText().toString().trim();

        if(email.length()>0 && password.length()>0 && passwordCheck.length()>0){
            if(password.equals(passwordCheck)){//비밀번호 체크
                mAuth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    Toast.makeText(SignUpActivity.this, "회원가입에 성공했습니다." ,Toast.LENGTH_SHORT).show();

                                    //가입이 이루어져을시 가입 화면을 빠져나감.
                                    Intent intent = new Intent(SignUpActivity.this, MainActivity.class);
                                    startActivity(intent);
                                    //finish();
                                    //Toast.makeText(SignUpActivity.this, "회원가입에 성공하셨습니다.", Toast.LENGTH_SHORT).show();
                                } else {
                                    if(task.getException().toString() !=null){
                                        Toast.makeText(SignUpActivity.this, "회원가입에 실패했습니다." ,Toast.LENGTH_SHORT).show();
                                    }
                                }
                            }
                        });
            }
            else{
                Toast.makeText(SignUpActivity.this, "비밀번호가 일치하지 않습니다." ,Toast.LENGTH_SHORT).show();
            }
        }
        else{
            Toast.makeText(SignUpActivity.this, "아아디와 비밀번호를 확인해주세요." ,Toast.LENGTH_SHORT).show();
        }
    }
}