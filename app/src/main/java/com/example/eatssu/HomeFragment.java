package com.example.eatssu;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.tabs.TabLayout;

public class HomeFragment extends Fragment {
    private TabLayout tabLayout;
    private ViewPager2 viewPager2;

    public void onCreateView(Bundle savedInstanceState) {

        tabLayout = tabLayout.findViewById(R.id.tab_main);
        viewPager2 = viewPager2.findViewById(R.id.vp_main);

//        adapter.addFragment(new Frag1());
//        adapter.addFragment(new Frag2());
//        adapter.addFragment(new Frag3());

//        val tabTitleArray = arrayOf(
//                "아침",
//                "점심",
//                "저녁",
//        )
    }
}
