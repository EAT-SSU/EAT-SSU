package com.example.eatssu;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class DodamAdapter extends RecyclerView.Adapter<DodamAdapter.ViewHolder> {

    private static ArrayList<Dodam> arrayList2;
    private Context context;

    public DodamAdapter(ArrayList<Dodam> arrayList, Context context) {
        this.arrayList2 = arrayList;
        this.context = context;
    }
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView 메뉴;


        public ViewHolder(View view) {
            super(view);
            메뉴 = (TextView) view.findViewById(R.id.item_edt_dodamcontents);
        }

        public TextView getMenu() {
            return 메뉴;
        }


    }

    public DodamAdapter(){} //생성자

    @NonNull
    @Override
    public DodamAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.dodam_recyclerview_data, parent, false);
        DodamAdapter.ViewHolder holder = new DodamAdapter.ViewHolder(view);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ReviewActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                int position = holder.getAbsoluteAdapterPosition();
                if (position != RecyclerView.NO_POSITION) {
                    String item = String.valueOf(arrayList2.get(position).get메뉴());
                    intent.putExtra("Menu", item);
                    context.startActivity(intent);
                }
            }
        });

        return holder;
    }


    @Override
    public void onBindViewHolder(@NonNull DodamAdapter.ViewHolder viewholder, int position) {
//        viewholder.중식1.setText(arrayList2.get(position).get중식1());
//        viewholder.중식4.setText(arrayList2.get(position).get중식4());
//        viewholder.석식1.setText(arrayList2.get(position).get석식1());
        viewholder.메뉴.setText(arrayList2.get(position).get메뉴());
//        viewholder.price.setText("5000");
//        viewholder.price.setText("5000");
//        viewholder.price.setText("5000");
//        viewholder.rate.setText("4.5");
//        viewholder.rate.setText("4.5");
//        viewholder.rate.setText("4.5");
    }

    @Override
    public int getItemCount() {

        return (arrayList2 !=null? arrayList2.size():0);
    }
}

