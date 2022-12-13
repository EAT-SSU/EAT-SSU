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

public class GisikAdapter extends RecyclerView.Adapter<GisikAdapter.ViewHolder>{
    private static ArrayList<Gisik> arrayList3;
    private Context context;

    public GisikAdapter(ArrayList<Gisik> arrayList, Context context) {
        this.arrayList3 = arrayList;
        this.context = context;
    }
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView 메뉴;


        public ViewHolder(View view) {
            super(view);
            메뉴 = (TextView) view.findViewById(R.id.item_edt_gisikcontents);
        }

        public TextView getMenu() {
            return 메뉴;
        }


    }

    public GisikAdapter(){} //생성자

    @NonNull
    @Override
    public GisikAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.gisik_recyclerview_data, parent, false);
        GisikAdapter.ViewHolder holder = new GisikAdapter.ViewHolder(view);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ReviewActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                int position = holder.getAbsoluteAdapterPosition();
                if (position != RecyclerView.NO_POSITION) {
                    String item = String.valueOf(arrayList3.get(position).get메뉴());
                    intent.putExtra("Menu", item);
                    context.startActivity(intent);
                }
            }
        });

        return holder;
    }


    @Override
    public void onBindViewHolder(@NonNull GisikAdapter.ViewHolder viewholder, int position) {
        viewholder.메뉴.setText(arrayList3.get(position).get메뉴());
    }

    @Override
    public int getItemCount() {

        return (arrayList3 !=null? arrayList3.size():0);
    }
}
