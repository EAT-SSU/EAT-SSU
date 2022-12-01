package com.example.eatssu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import java.util.ArrayList;


public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {

    private ArrayList<Board> arrayList;
    private Context context;

    public CustomAdapter(ArrayList<Board> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView title;
        private final TextView content;
        private final TextView id;
        private final TextView likeCount;
        private final TextView messageCount;
        //private final TextView datetime;
        //private final ImageView image;

        public ViewHolder(View view) {
            super(view);
            // Define click listener for the ViewHolder's View

/*
            class Board {
                private String title;
                private String content;
                private int id;
                private int likeCount;
                private int messageCount;
                private int datetime;*/
            title = (TextView) view.findViewById(R.id.tv_title);
            content = (TextView) view.findViewById(R.id.tv_content);
            id = (TextView) view.findViewById(R.id.tv_id);
            likeCount = (TextView) view.findViewById(R.id.tv_likeCount);
            messageCount = (TextView) view.findViewById(R.id.tv_messageCount);
            //datetime = (TextView) view.findViewById(R.id.tv_time);
        }

        public TextView getTitle() {
            return title;
        }

        public TextView getContent() {
            return content;
        }

        public TextView getId() {
            return id;
        }

        public TextView getLikeCount() {
            return likeCount;
        }

        /*
        public TextView getMessageCount() {
            return messageCount;
        }

        public TextView getDatetime() {
            return datetime;
        }*/
    }

    public CustomAdapter(){} //생성자

    // Create new views (invoked by the layout manager)
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.board_item, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int position) {
        /*Glide.with(viewHolder.itemView)
                .load(arrayList.get(position).getImage())
                .into(viewHolder.image);*/
        viewHolder.id.setText(String.valueOf(arrayList.get(position).getId()));
        viewHolder.title.setText(arrayList.get(position).getTitle());
        viewHolder.content.setText(arrayList.get(position).getContent());
        viewHolder.messageCount.setText(String.valueOf(arrayList.get(position).getMessageCount()));
        viewHolder.likeCount.setText(String.valueOf(arrayList.get(position).getLikeCount())); //int형일때
        //viewHolder.datetime.setText(arrayList.get(position).getDatetime()); //int 형이 맞는지 몰르겟음

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        //삼항연산자
        return (arrayList !=null? arrayList.size():0);
    }
}