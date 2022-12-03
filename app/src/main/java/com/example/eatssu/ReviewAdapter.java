package com.example.eatssu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ReviewAdapter extends RecyclerView.Adapter<ReviewAdapter.ViewHolder> {

    private ArrayList<String> localDataSet;

    //====================뷰홀더 클래스==========================
    public static class ViewHolder extends RecyclerView.ViewHolder{
        private final TextView userId;

        public ViewHolder(@NonNull View textView){
            super(textView);

            userId = textView.findViewById(R.id.userName);
        }
        public TextView getTextView(){return userId;}
    }
    //=========================================================

    //=======================생성자==============================
    //생성자를 통해서 데이터를 전달받도록 함
    public ReviewAdapter(ArrayList<String> dataSet){
        localDataSet = dataSet;
    }
    //=============================================================

    @NonNull
    @Override //뷰홀더 객체를 생성하여 리턴함
    public ReviewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.review_item,parent,false);
        ReviewAdapter.ViewHolder viewHolder = new ReviewAdapter.ViewHolder(view);

        return viewHolder;
    }

    @Override //뷰홀더 안의 내용을 position에 해당되는 데이터로 교체
    public void onBindViewHolder(@NonNull ReviewAdapter.ViewHolder holder, int position) {

        String text = localDataSet.get(position);
        holder.userId.setText(text);
    }

    @Override //전체 데이터의 개수를 리턴
    public int getItemCount() {
        return localDataSet.size();
    }
}
