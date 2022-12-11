package com.example.eatssu;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class MainVPAdapter extends FragmentStateAdapter {

    public MainVPAdapter(@NonNull Fragment fragment) {
        super(fragment);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            //1번째 탭
            case 0:
                return new BreakfastFragment();
            //2번째 탭
            case 1:
                return new LunchFragment();
            //3번째 탭
            case 2:
                return new DinnerFragment();
            default:
                return new LunchFragment();
        }

    }

    @Override
    public int getItemCount() {
        return 3;
    }


}