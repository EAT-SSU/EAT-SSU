package com.example.eatssu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ReviewAdapter extends RecyclerView.Adapter<ReviewAdapter.ViewHolder> {

    //private ArrayList<String> localDataSet;
    private ArrayList<ReviewList> arrayList;

    //====================뷰홀더 클래스==========================
    public static class ViewHolder extends RecyclerView.ViewHolder{
        private final TextView userId;
        private final TextView reviewContext;
        private final RatingBar rating;
        private final TextView date;


        public ViewHolder(@NonNull View view) {
            super(view);
            userId = view.findViewById(R.id.userName);
            reviewContext = view.findViewById(R.id.reviewContext);
            rating = view.findViewById(R.id.personalRate);
            date = view.findViewById(R.id.date);


        }
    }
    //=========================================================

    //=======================생성자==============================
    //생성자를 통해서 데이터를 전달받도록 함
    public ReviewAdapter(ArrayList<ReviewList> arrayList) {
        this.arrayList = arrayList;
    }
    //=============================================================

    @NonNull
    @Override //뷰홀더 객체를 생성하여 리턴함
    public ReviewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.review_item,parent,false);
        ReviewAdapter.ViewHolder viewHolder = new ReviewAdapter.ViewHolder(view);

        return viewHolder;
    }

    @Override //뷰홀더 안의 내용을 position에 해당되는 데이터로 교체
    public void onBindViewHolder(@NonNull ReviewAdapter.ViewHolder holder, int position) {

        ReviewList item = arrayList.get(position);
        holder.userId.setText(item.getUserId());
        holder.rating.setRating(item.getRating());
        holder.reviewContext.setText(item.getReviewContext());
        holder.date.setText(String.valueOf(item.getDate()));


    }

    @Override //전체 데이터의 개수를 리턴
    public int getItemCount() {
        return arrayList.size();
    }
}
