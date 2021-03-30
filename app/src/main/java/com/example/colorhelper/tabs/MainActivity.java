package com.example.colorhelper.tabs;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Switch;
import android.widget.TextView;

import com.example.colorhelper.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity  {

    private int tag = -1;

    public static String TAB_KEY = "Tab";


    public int getTag() {
        return tag;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tag = getIntent().getIntExtra(TAB_KEY, -1);

        ViewPageTabAdapter viewPageTabAdapter = new ViewPageTabAdapter(this);

        ViewPager2 viewPager = findViewById(R.id.view_pager);
        viewPager.setUserInputEnabled(false);
        viewPager.setAdapter(viewPageTabAdapter);
        viewPager.setCurrentItem(0, true);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_nav);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.related:
                        viewPager.setCurrentItem(0, true);
                        break;
                    case R.id.info:
                        viewPager.setCurrentItem(1, true);
                        break;
                    case R.id.history:
                        viewPager.setCurrentItem(2, true);
                        break;
                }
                return true;
            }
        });

    }


}
