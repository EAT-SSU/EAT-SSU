package com.example.eatssu;

import android.annotation.SuppressLint;
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
        private final TextView 메뉴;
        private final TextView price;
        private final TextView rate;


        public ViewHolder(View view) {
            super(view);
            // Define click listener for the ViewHolder's View
            메뉴 = (TextView) view.findViewById(R.id.item_edt_contents);
            price = (TextView) view.findViewById(R.id.item_edt_price);
            rate = (TextView) view.findViewById(R.id.item_edt_rate);

        }

        public TextView Menu() {
           return 메뉴;
        }

    }

    public MenuAdapter(){} //생성자

    @NonNull
    @Override
    public MenuAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.haksik_recyclerview_data, parent, false);
        MenuAdapter.ViewHolder holder = new MenuAdapter.ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MenuAdapter.ViewHolder viewholder, int position) {
        viewholder.메뉴.setText(arrayList.get(position).getMenu().toString());
        viewholder.price.setText("5000");
        viewholder.rate.setText("4.5");
    }

    @Override
    public int getItemCount() {
        return (arrayList !=null? arrayList.size():0);
    }
}
