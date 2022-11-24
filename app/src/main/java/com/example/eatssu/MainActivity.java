package com.example.eatssu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;

    Fragment fragment_home;
    Fragment fragment_board;
    Fragment fragment_mypage;
    Button dateBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragment_home = new HomeFragment();
        fragment_board = new BoardFragment();
        fragment_mypage = new MypageFragment();

        dateBtn = findViewById(R.id.main_date_btn);
        Calendar c = Calendar.getInstance();
        int mYear = c.get(Calendar.YEAR);
        int mMonth = c.get(Calendar.MONTH);
        int mDay = c.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override

            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                dateBtn.setText(year + "-" + (month + 1) + "-" + dayOfMonth);
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
