package com.example.eatssu;

import android.view.View;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

public  class ReviewHolder extends RecyclerView.ViewHolder{
    TextView mID;
    TextView mContext;
    RatingBar mRating;
    TextView mDate;


    public ReviewHolder(@NonNull View view) {
        super(view);
        mID = view.findViewById(R.id.userName);
        mContext = view.findViewById(R.id.reviewContext);
        mRating = view.findViewById(R.id.personalRate);
        mDate = view.findViewById(R.id.date);
    }

    void bind(@NonNull ReviewList reviewList){
        mID.setText(String.valueOf(reviewList.getID()));
        mContext.setText(String.valueOf(reviewList.getContext()));
        mRating.setRating(reviewList.getRating());
        mDate.setText(reviewList.getDate());
    }

}