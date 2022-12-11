package com.example.eatssu;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ReviewActivity extends AppCompatActivity {
    private RecyclerView recyclerView;

    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private ArrayList<ReviewList> arrayList = new ArrayList<>();
    private ProgressDialog progressDialog;
    private DatabaseReference databaseReference;

    private FirebaseDatabase database;
    private FirebaseAuth auth;
    private FirebaseFirestore db;
    private DocumentReference docRef;

    private String userId;
    private String reviewContext;
    private float rating;
    private String date;

    public ReviewActivity() {}
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
        database = FirebaseDatabase.getInstance();
        databaseReference = database.getReference("context"); // DB 테이블 연결 path:"Board"
        //addListenerForSingleValueEvent
        //addValueEventListener
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                // 파이어베이스 데이터베이스의 데이터를 받아오는 곳
                arrayList.clear(); // 기존 배열리스트가 존재하지않게 초기화
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) { // 반복문으로 데이터 List를 추출해냄
                    //databaseReference.setValue("이거슨 제목"); //값을 저장할때!

                    ReviewList reviewList = snapshot.getValue(ReviewList.class); // 만들어뒀던 User 객체에 데이터를 담는다.
                    arrayList.add(reviewList); // 담은 데이터들을 배열리스트에 넣고 리사이클러뷰로 보낼 준비

                    Log.d(TAG, String.valueOf(reviewList));
                }
                adapter.notifyDataSetChanged(); // 리스트 저장 및 새로고침해야 반영이 됨
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                // 디비를 가져오던중 에러 발생 시
                Log.e("Failed to read value.", String.valueOf(databaseError.toException())); // 에러문 출력
            }
        });


//        recyclerView = findViewById(R.id.reviewRecyclerView);
//        arrayList = new ArrayList<>();
//
//        recyclerView.setLayoutManager(new LinearLayoutManager(this)); //LayoutManager 설정
//
//        adapter = new ReviewAdapter(arrayList);
//        progressDialog = new ProgressDialog(this);
//        progressDialog.setCancelable(false);
//        progressDialog.setMessage("Fetching data");
//        progressDialog.show();
//        db = FirebaseFirestore.getInstance();
//        recyclerView.setHasFixedSize(true);
//        recyclerView.setAdapter(adapter);
       // EventChangeListener();


    }
    /*
    private void EventChangeListener() {
        db.collection("ReviewMenu").orderBy("date", Query.Direction.ASCENDING)
                .addSnapshotListener(new EventListener<QuerySnapshot>() {
                    @SuppressLint("NotifyDataSetChanged")
                    @Override
                    public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {
                        if (error != null) {
                            if (progressDialog.isShowing()) {
                                progressDialog.dismiss();
                            }
                            Log.e("Firestore error", error.getMessage());
                            return;
                        } else {
                            for (DocumentChange dc : Objects.requireNonNull(value).getDocumentChanges()) {
                                if (dc.getType() == DocumentChange.Type.ADDED) {
                                    arrayList.add(dc.getDocument().toObject(ReviewList.class));
                                }
                                adapter.notifyDataSetChanged();
                                if (progressDialog.isShowing()) {
                                    progressDialog.dismiss();
                                }
                            }
                        }
                    }
                });
    }*/
}

