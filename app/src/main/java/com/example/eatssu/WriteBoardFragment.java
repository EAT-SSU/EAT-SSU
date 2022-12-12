package com.example.eatssu;

import static android.content.ContentValues.TAG;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.Timestamp;
import com.google.firebase.database.annotations.NotNull;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import com.google.firebase.auth.FirebaseAuth;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class WriteBoardFragment extends Fragment {

    FirebaseAuth auth;
    private FirebaseFirestore db;
    private DocumentReference docRef;
    //final String userId = String.valueOf(getId());
    private String puttitle;
    private String putcontent;
    //private String timestamp;
    //docRef = db.collection("Board").document("id");

    Fragment BoardFragment;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public WriteBoardFragment() {
        // Required empty public constructor
    }

    public static WriteBoardFragment newInstance(String param1, String param2) {
        WriteBoardFragment fragment = new WriteBoardFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_write_board, container, false);

    }

    public static String getCurrentTimeStamp(){
        try {

            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            String currentDateTime = dateFormat.format(new Date()); // Find todays date

            return currentDateTime;
        } catch (Exception e) {
            e.printStackTrace();

            return null;
        }
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        db = FirebaseFirestore.getInstance();
        Button uploadButton = view.findViewById(R.id.btn_uploadBoard);
        EditText title = view.findViewById(R.id.et_title);
        EditText content = view.findViewById(R.id.et_content);
        TextView likeCount = view.findViewById(R.id.write_id);
        TextView messageCount = view.findViewById(R.id.message_id);

        String date=getCurrentTimeStamp();
        auth = FirebaseAuth.getInstance();
        String uid=auth.getCurrentUser().getUid();

        String trimId=uid.substring(0,4);


        uploadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Map<String, Object> data1 = new HashMap<>();
                puttitle = title.getText().toString();
                putcontent = content.getText().toString();
                data1.put("title", puttitle);
                data1.put("content", putcontent);
                data1.put("id", uid);
                data1.put("trimUid",trimId);
                data1.put("likeCount", 0);
                data1.put("messageCount", 0);
                data1.put("timestamp",date);
//                db.document("id").set(data1);
                db.collection("Board").add(data1)
                        .addOnSuccessListener(new OnSuccessListener() {
                            @Override
                            public void onSuccess(Object o) {
                                Log.d(TAG, "DocumentSnapshot added with title: " + puttitle);
                                //Log.d(TAG, "DocumentSnapshot added with ID: ");
                            }

                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull @NotNull Exception e) {
                                Log.w(TAG, "Error adding document", e);

                            }


                        });
                //FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                //getParentFragmentManager().beginTransaction().remove(WriteBoardFragment.this).commit();
                //getParentFragmentManager().popBackStack();


                getParentFragmentManager().beginTransaction().remove(WriteBoardFragment.this).commit();
                //getParentFragmentManager().beginTransaction().replace(R.id.main_container_fragment, BoardFragment).commit();
//                getParentFragmentManager().beginTransaction().replace(R.id.main_container_fragment, BoardFragment).commitAllowingStateLoss();
            }
        });
    }
}