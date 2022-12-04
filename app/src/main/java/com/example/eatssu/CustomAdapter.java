package com.example.eatssu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.CustomViewHolder>{
//public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {

    //private String[] localDataSet;
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


    @NonNull
    @Override
    //실제 리스트뷰가 어댑터에 연결된 다음에 뷰 홀더를 최초로 만들어낸다.
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.board_item, parent, false);
        CustomViewHolder holder = new CustomViewHolder(view);
        return holder;
    }
    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
//        Glide.with(holder.itemView)
//                .load(arrayList.get(position).getProfile())
//                .into(holder.iv_profile);

        holder.id.setText(String.valueOf(arrayList.get(position).getId()));
        holder.title.setText(arrayList.get(position).getTitle());
        holder.content.setText(arrayList.get(position).getContent());
        holder.messageCount.setText(String.valueOf(arrayList.get(position).getMessageCount()));
        holder.likeCount.setText(String.valueOf(arrayList.get(position).getLikeCount())); //int형일때
    }

    @Override
    public int getItemCount() {
        // 삼항 연산자
        return (arrayList != null ? arrayList.size() : 0);
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        TextView content;
        TextView id;
        TextView likeCount;
        TextView messageCount;

        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            this.title = itemView.findViewById(R.id.tv_title);
            this.content = itemView.findViewById(R.id.tv_content);
            this.id = itemView.findViewById(R.id.tv_id);
            this.likeCount = itemView.findViewById(R.id.tv_likeCount);
            this.messageCount = itemView.findViewById(R.id.tv_messageCount);
        }
    }
}


    /*
    public class CustomViewHolder extends RecyclerView.ViewHolder {
        private final TextView title;
        private final TextView content;
        private final TextView id;
        private final TextView likeCount;
        private final TextView messageCount;
        //private final TextView datetime;
        //private final ImageView image;

        public CustomViewHolder(View view) {
            super(view);
            // Define click listener for the ViewHolder's View


            class Board {
                private String title;
                private String content;
                private int id;
                private int likeCount;
                private int messageCount;
                private int datetime;
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
        }
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

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {

    }

    @Override
    public void onBindViewHolder(@NonNull CustomAdapter.CustomAdapter holder, int position) {

    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int position) {
        /*Glide.with(viewHolder.itemView)
                .load(arrayList.get(position).getImage())
                .into(viewHolder.image);
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
}*/