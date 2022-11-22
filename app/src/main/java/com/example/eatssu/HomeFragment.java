package com.example.eatssu;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.util.Log;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.Arrays;
import java.util.List;

public class HomeFragment extends Fragment {

    private TabLayout tabLayout;
    private ViewPager2 viewPager2;
    private MainVPAdapter adapter;
    private View view;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_home,container,false);
        tabLayout = view.findViewById(R.id.tab_main);
        viewPager2 = view.findViewById(R.id.vp_main);
        adapter = new MainVPAdapter(this);

        viewPager2.setAdapter(adapter);

        final List<String> tabElement = Arrays.asList("아침", "점심", "저녁");
//        tabLayout.addTab(tabLayout.newTab().setText("아침"));
//        tabLayout.addTab(tabLayout.newTab().setText("점심"));
//        tabLayout.addTab(tabLayout.newTab().setText("저녁"));

        new TabLayoutMediator(tabLayout, viewPager2, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                TextView textView = new TextView(getContext());
                textView.setText(tabElement.get(position));
                tab.setCustomView(textView);
            }
        } ).attach();
        Log.d("tab", "pass");
        return view;

    }
}
