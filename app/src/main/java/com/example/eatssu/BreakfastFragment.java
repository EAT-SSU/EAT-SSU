package com.example.eatssu;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

public class BreakfastFragment extends Fragment {
    private RecyclerView recyclerView;
    private RecyclerView recyclerView2;
    private RecyclerView recyclerView3;
    private RecyclerView.Adapter rvAdapter;
    private RecyclerView.LayoutManager layoutmanager;
    private FirebaseFirestore db;
    private ArrayList<Menu> arrayList = new ArrayList<>();
    private ProgressDialog progressDialog;

    private View view;
    private ImageButton haksikBtn;
    private ImageButton dodamBtn;
    private ImageButton gisikBtn;

    public BreakfastFragment() {}

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_breakfast,container,false);

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

        progressDialog = new ProgressDialog(getActivity());
        progressDialog.setCancelable(false);
        progressDialog.setMessage("Fetching data");
        progressDialog.show();
        ArrayList<Menu> arraryList = new ArrayList<Menu>();
        rvAdapter = new MenuAdapter(arrayList, getActivity());
        recyclerView = view.findViewById(R.id.rv_breakfast_haksik);
        recyclerView2 = view.findViewById(R.id.rv_breakfast_dodam);
        recyclerView3 = view.findViewById(R.id.rv_breakfast_gisik);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(rvAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));


        db = FirebaseFirestore.getInstance();
        EventChangeListener();

        return view;
    }

    private void EventChangeListener() {
        db.collection("menus").orderBy("2022.12.03(토)", Query.Direction.ASCENDING)
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
                        for (DocumentChange dc : value.getDocumentChanges()) {
                            if(dc.getType() == DocumentChange.Type.ADDED) {
                                arrayList.add(dc.getDocument().toObject(Menu.class));
                            }
                            rvAdapter.notifyDataSetChanged();
                            if(progressDialog.isShowing()) {
                                progressDialog.dismiss();
                            }
                        }
                    }
                });
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initData(view);
    }

    public void initData(View view) {
        recyclerView = view.findViewById(R.id.rv_breakfast_haksik);
        recyclerView.setHasFixedSize(true); //리사이클러뷰 기존 성능 강화
        arrayList = new ArrayList<>();
    }

}