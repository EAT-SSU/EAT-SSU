package com.example.eatssu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.ViewHolder> {

    private ArrayList<Menu> arrayList;
    private Context context;

    public MenuAdapter(ArrayList<Menu> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView Dodam1;
        //private final TextView Dodam2;
//        private final TextView content;
//        private final TextView id;
//        private final TextView likeCount;

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
            Dodam1 = (TextView) view.findViewById(R.id.item_edt_contents);
//            content = (TextView) view.findViewById(R.id.tv_content);
//            id = (TextView) view.findViewById(R.id.tv_id);
//            likeCount = (TextView) view.findViewById(R.id.tv_likeCount);
        }

        public TextView getDodam1() {
            return Dodam1;
        }
//
//        public TextView getContent() {
//            return content;
//        }
//
//        public TextView getId() {
//            return id;
//        }
//
//        public TextView getLikeCount() {
//            return likeCount;
//        }

        /*
        public TextView getMessageCount() {
            return messageCount;
        }

        public TextView getDatetime() {
            return datetime;
        }*/
    }

    public MenuAdapter(){} //생성자

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.haksik_recyclerview_data, parent, false);
        MenuAdapter.ViewHolder holder = new MenuAdapter.ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewholder, int position) {
        viewholder.Dodam1.setText(arrayList.get(position).getDodam1());
    }

    @Override
    public int getItemCount() {
        return (arrayList !=null? arrayList.size():0);
    }
}
