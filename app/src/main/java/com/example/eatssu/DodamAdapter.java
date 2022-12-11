package com.example.eatssu;

import android.content.Context;
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
        private final TextView 중식4;
        private final TextView 석식1;
        private final TextView 중식1;
//        private final TextView 메뉴;
        private final TextView price;
        private final TextView rate;


        public ViewHolder(View view) {
            super(view);
            // Define click listener for the ViewHolder's View
            중식1 = (TextView) view.findViewById(R.id.item_edt_dodamcontents);
            중식4 = (TextView) view.findViewById(R.id.item2_edt_dodamcontents);
            석식1 = (TextView) view.findViewById(R.id.item3_edt_dodamcontents);
//            메뉴 = (TextView) view.findViewById(R.id.item_edt_dodamcontents);
            price = (TextView) view.findViewById(R.id.item_edt_dodamprice);
            rate = (TextView) view.findViewById(R.id.item_edt_dodamrate);

        }

//        public TextView getMenu() {
//            return 메뉴;
//        }
        public TextView getJungsik1() {
            return 중식1;
        }
        public TextView getJungsik4() {
            return 중식4;
        }
        public TextView getSuksik1() {
            return 석식1;
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
        return holder;
    }


    @Override
    public void onBindViewHolder(@NonNull DodamAdapter.ViewHolder viewholder, int position) {
        viewholder.중식1.setText(arrayList2.get(position).getJungsik1());
        viewholder.중식4.setText(arrayList2.get(position).getJungsik4());
        viewholder.석식1.setText(arrayList2.get(position).getSuksik1());
        viewholder.price.setText("5000");
        viewholder.rate.setText("4.5");
    }

    @Override
    public int getItemCount() {
        return (arrayList2 !=null? arrayList2.size():0);
    }
}

