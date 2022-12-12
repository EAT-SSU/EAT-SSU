package com.example.eatssu;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class MypageFragment extends Fragment {

    private FirebaseAuth firebaseAuth;
    private GoogleSignInClient mGoogleSignInClient;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_mypage,container,false);

        firebaseAuth = FirebaseAuth.getInstance();

        TextView ID = view.findViewById(R.id.tv_mp_id);
        TextView EMAIL = view.findViewById(R.id.tv_mp_email);

        String uid=firebaseAuth.getCurrentUser().getUid();
        uid= uid.substring(0,4);

        EMAIL.setText(firebaseAuth.getCurrentUser().getEmail());
        ID.setText("ID "+ uid);

        Button signOutButton = view.findViewById(R.id.sign_out_button);
        signOutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signOut();
            }
        });

        return view;
    }

    private void signOut() {
        // Firebase sign out
        firebaseAuth.signOut();
        Intent intent = new Intent(getActivity(),loginActivity.class);
        getParentFragmentManager().beginTransaction().remove(MypageFragment.this).commit();
        startActivity(intent);
    }

    private void revokeAccess() {
        // Firebase sign out
        firebaseAuth.signOut();
    }
}