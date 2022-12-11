package com.example.eatssu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.paging.PagingConfig;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.firebase.ui.firestore.paging.FirestorePagingAdapter;
import com.firebase.ui.firestore.paging.FirestorePagingOptions;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

public class ReviewActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private FirestorePagingAdapter<ReviewList,ReviewHolder> adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review);
        recyclerView = findViewById(R.id.reviewRecyclerView);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager); //LayoutManager 설정


        Button buttonNext = findViewById(R.id.reviewGoButton);
        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ReviewActivity.this, ReviewActivity2.class);
                startActivity(intent);
            }
        });

        Query baseQuery = FirebaseFirestore.getInstance().collection("ReviewMenu").orderBy("timestamp", Query.Direction.DESCENDING);
        PagingConfig config = new PagingConfig(4, 2, false);
        FirestorePagingOptions<ReviewList> options = new FirestorePagingOptions.Builder<ReviewList>()
                .setLifecycleOwner(this)
                .setQuery(baseQuery, config, ReviewList.class)
                .build();

        adapter = new FirestorePagingAdapter<ReviewList, ReviewHolder>(options) {
            @Override
            protected void onBindViewHolder(@NonNull ReviewHolder holder, int position, @NonNull ReviewList model) {
                holder.bind(model);
            }

            @NonNull
            @Override
            public ReviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.review_item, parent, false);
                return new ReviewHolder(view);
            }
        };

        RecyclerView recyclerView = findViewById(R.id.reviewRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);


    }
    @Override
    protected void onStart(){
        super.onStart();
        adapter.startListening();
    }

    @Override
    protected  void onStop() {
        super.onStop();
        adapter.stopListening();
    }
        }

