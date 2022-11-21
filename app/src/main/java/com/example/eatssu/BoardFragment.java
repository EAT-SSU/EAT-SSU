package com.example.eatssu;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.viewbinding.ViewBinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;

import com.example.eatssu.databinding.FragmentBoardBinding;

public class BoardFragment extends Fragment {
    private ViewDataBinding binding;
    //Button goWriteButton;

    private View view;
    private Button goWriteButton;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_board,container,false);

        //binding = DataBindingUtil.inflate(inflater,R.layout.fragment_board,container,false);
        //View root = binding.getRoot();

        goWriteButton = (Button) view.findViewById(R.id.btn_goWrite);

        goWriteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),WriteBoardActivity.class);
                startActivity(intent);
            }
        });
        return view;
    }

//    final ArrayAdapter adapter = new ArrayAdapter(this,R.layout.content,R.id.tv_title);


}