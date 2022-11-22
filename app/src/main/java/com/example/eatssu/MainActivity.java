package com.example.eatssu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;

    Fragment fragment_home;
    Fragment fragment_board;
    Fragment fragment_mypage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragment_home = new HomeFragment();
        fragment_board = new BoardFragment();
        fragment_mypage = new MypageFragment();

        NavigationBarView navigationBarView= findViewById(R.id.nav_bottom);
        getSupportFragmentManager().beginTransaction().replace(R.id.main_container_fragment, fragment_home).commitAllowingStateLoss();

        navigationBarView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.menu_board:
                        Log.d("board", "click");
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.main_container_fragment, fragment_board)
                                .commitAllowingStateLoss();
                        return true;

                    case R.id.menu_home:
                        Log.d("home", "click");
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.main_container_fragment, fragment_home)
                                .commitAllowingStateLoss();
                        return true;

                    case R.id.menu_mypage:
                        Log.d("mypage", "click");
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.main_container_fragment, fragment_mypage)
                                .commitAllowingStateLoss();
                        return true;

                }
                return false;
            }
        });
    }
}
