package com.example.eatssu;

import static android.content.ContentValues.TAG;

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

        EditText emailEditText = findViewById(R.id.edt_sEmailAddress);
        EditText passwordEditText = findViewById(R.id.edt_Password1);
        EditText password2EditText = findViewById(R.id.edt_Password2);


        Button signupButton = findViewById(R.id.btn_summit);
        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = emailEditText.getText().toString().trim();
                String password= passwordEditText.getText().toString().trim();
                String passwordCheck=password2EditText.getText().toString().trim();

                signUp(email, password,passwordCheck);
            }
        });
    }

    private void signUp(String email, String password,String passwordCheck) {
        if(email.length()>0 && password.length()>0 && passwordCheck.length()>0){
            if(password.equals(passwordCheck)){//비밀번호 체크
                mAuth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    // Sign in success, update UI with the signed-in user's information
                                    Log.d(TAG, "createUserWithEmail:success");
                                    FirebaseUser user = mAuth.getCurrentUser();
                                    updateUI(user);

                                    Intent intent = new Intent(SignUpActivity.this, MainActivity.class);
                                    //Log.d("login-success",uid);
                                    startActivity(intent);
                                } else {
                                    // If sign in fails, display a message to the user.
                                    //Log.w(TAG, "createUserWithEmail:failure", task.getException());
                                    Log.d(TAG, "createUserWithEmail:failure");
                                    Toast.makeText(getApplicationContext(), "Authentication failed.",
                                            Toast.LENGTH_SHORT).show();
                                    updateUI(null);
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


    private void updateUI(FirebaseUser user) {
        if (user == null) return;

        Log.d(TAG, "email: " + user.getEmail());
        Log.d(TAG, "uid: " + user.getUid());
    }
}