package com.example.eatssu;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.nav_bottom);
        getSupportFragmentManager().beginTransaction().replace(R.id.main_container_fragment, new HomeFragment()).commitAllowingStateLoss();

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.menu_board: {
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.main_container_fragment, new BoardFragment())
                                .commit();
                        return true;
                    }
                    case R.id.menu_home: {
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.main_container_fragment, new HomeFragment())
                                .commit();
                        return true;
                    }
                    case R.id.menu_mypage: {
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.main_container_fragment, new MypageFragment())
                                .commit();
                        return true;
                    }
                }
                return false;
            }

        });
        bottomNavigationView.setSelectedItemId(R.id.menu_home);
    }
}
