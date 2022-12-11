package com.example.eatssu;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import android.util.Log;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class HomeFragment extends Fragment {

//    private TabLayout tabLayout;
//    private ViewPager2 viewPager2;
    private MenuAdapter adapter;
    private DodamAdapter adapter2;
    private View view;
    private ImageButton haksikBtn;
    private ImageButton dodamBtn;
    private ImageButton gisikBtn;
    Button dateBtn;
    private ArrayList<Menu> arrayList = new ArrayList<>();
    private ArrayList<Dodam> arrayList2 = new ArrayList<>();

    private ProgressDialog progressDialog;
    private DatabaseReference databaseReference;
    private String datetext;
    FirebaseFirestore db;
    private FirebaseDatabase database;
    private RecyclerView recyclerView;
    private RecyclerView recyclerView2;
    private RecyclerView recyclerView3;
    private RecyclerView.LayoutManager layoutManager;

    private String 조식;
    private String 중식;
    private String 석식;
    private String 중식1;
    private String 중식4;
    private String 석식1;
    private String 메뉴;

    public HomeFragment() {}

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_home,container,false);
        progressDialog = new ProgressDialog(getActivity());
        progressDialog.setCancelable(false);
        progressDialog.setMessage("Fetching data");
        progressDialog.show();
//        tabLayout = view.findViewById(R.id.tab_main);
//        viewPager2 = view.findViewById(R.id.vp_main);
        adapter = new MenuAdapter(arrayList, getActivity());
        adapter2 = new DodamAdapter(arrayList2, getActivity());
        //adapter3 = new HaksikAdapter(arrayList2, getActivity());
//        viewPager2.setAdapter(adapter);
        dateBtn = view.findViewById(R.id.main_date_btn);
        db = FirebaseFirestore.getInstance();
        recyclerView = view.findViewById(R.id.rv1_haksikdata);
        recyclerView2 = view.findViewById(R.id.rv1_dodamdata);
        recyclerView3 = view.findViewById(R.id.rv1_gisikdata);
        recyclerView.setAdapter(adapter);
        recyclerView2.setAdapter(adapter2);
//        recyclerView3.setAdapter(adapter3);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView2.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView3.setLayoutManager(new LinearLayoutManager(getActivity()));

//        viewPager2.setSaveEnabled(false);
//        final List<String> tabElement = Arrays.asList("아침", "점심", "저녁");
//
//        new TabLayoutMediator(tabLayout, viewPager2, new TabLayoutMediator.TabConfigurationStrategy() {
//            @Override
//            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
//                TextView textView = new TextView(getContext());
//                textView.setText(tabElement.get(position));
//                tab.setCustomView(textView);
//            }
//        } ).attach();
//        Log.d("tab", "pass");


        Calendar c = Calendar.getInstance();
        int mYear = c.get(Calendar.YEAR);
        int mMonth = c.get(Calendar.MONTH);
        int mDay = c.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {
            @Override

            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                dateBtn.setText(year + "-" + (month + 1) + "-" + dayOfMonth);
                datetext = dateBtn.toString();

            }
        }, mYear, mMonth, mDay);

        dateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (dateBtn.isClickable()) {
                    datePickerDialog.show();
                }
            }
        });
        Location();
        return view;
    }
    private void Location() {
        haksikBtn = (ImageButton) view.findViewById(R.id.haksik_info);
        haksikBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),InfoActivity_Haksik.class); //fragment라서 activity intent와는 다른 방식
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent);
            }
        });

        dodamBtn = (ImageButton) view.findViewById(R.id.dodam_info);
        dodamBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),InfoActivity_Dodam.class); //fragment라서 activity intent와는 다른 방식
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent);
            }
        });

        gisikBtn = (ImageButton) view.findViewById(R.id.gisik_info);
        gisikBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),InfoActivity_Gisik.class); //fragment라서 activity intent와는 다른 방식
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        arrayList2.clear();
        arrayList.clear();
        EventChangeListener2();
        EventChangeListener();
    }

    private void EventChangeListener() {
        db.collection("숭실도담식당").document("2022.12.12").collection("메뉴").orderBy("메뉴", Query.Direction.ASCENDING)
                .addSnapshotListener(new EventListener<QuerySnapshot>() {
                    @Override
                    public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {
                        if(error != null) {
                            if(progressDialog.isShowing()) {
                                progressDialog.dismiss();
                            }
                            Log.e("Firestore error", error.getMessage());
                            return;
                        }
                        assert value != null;
                        for (DocumentChange dc : value.getDocumentChanges()) {
                            if(dc.getType() == DocumentChange.Type.ADDED) {
                                arrayList2.add(dc.getDocument().toObject(Dodam.class));
                            }
//                            recyclerView2.scrollToPosition(DodamAdapter.getItemCount());

                            if(progressDialog.isShowing()) {
                                progressDialog.dismiss();
                                adapter2.notifyDataSetChanged();
                            }
                        }
                    }
                });
    }

    private void EventChangeListener2() {
        db.collection("학생식당").document("2022.12.12").collection("메뉴").orderBy("메뉴", Query.Direction.DESCENDING)
                .addSnapshotListener(new EventListener<QuerySnapshot>() {
                    @Override
                    public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {
                        if(error != null) {
                            if(progressDialog.isShowing()) {
                                progressDialog.dismiss();
                            }
                            Log.e("Firestore error", error.getMessage());
                            return;
                        }
                        assert value != null;
                        for (DocumentChange dc : value.getDocumentChanges()) {
                            if(dc.getType() == DocumentChange.Type.ADDED) {
                                arrayList.add(dc.getDocument().toObject(Menu.class));
                            }

//                            recyclerView2.scrollToPosition(DodamAdapter.getItemCount());

                            if(progressDialog.isShowing()) {
                                progressDialog.dismiss();
                                adapter.notifyDataSetChanged();
                            }
                        }
                    }
                });
    }
}
