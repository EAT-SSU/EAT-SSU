package com.example.eatssu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class commentRVAdapter extends RecyclerView.Adapter<commentRVAdapter.ViewHolder> {

    private ArrayList<Comment> arrayList;
    private Context context;

    public commentRVAdapter(ArrayList<Comment> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.board_item,parent,false);
        ViewHolder cHolder = new ViewHolder(view);
        return cHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder cholder, int position) {
        cholder.cComments.setText(arrayList.get(position).getComments());
        cholder.cID.setText(arrayList.get(position).getId());
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView cID;
        TextView cComments;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            this.cID = itemView.findViewById(R.id.tv_commenterId);
            this.cComments=itemView.findViewById(R.id.tv_commenterComments);
        }
    }

    @Override
    public int getItemCount() {
        return (arrayList !=null? arrayList.size():0);
    }
}