package com.example.colorhelper;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Switch;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    FloatingActionButton fab;
    BottomNavigationView bottomNavigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottom_nav);
        

        fab = findViewById(R.id.fab);
        fab.setOnClickListener(this);
    }







    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.fab:
                Intent intent = new Intent(this, NewColorActivity.class);
                startActivity(intent);
                break;
        }
    }
}




















































//        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
//            @Override
//            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//                switch (item.getItemId()) {
//                    case R.id.info:
//                        Intent intent = new Intent(MainActivity.this, Info.class);
//                        startActivity(intent);
//                        break;
//                    case R.id.related:
//                        Intent intent1 = new Intent(MainActivity.this, MainActivity.class);
//                        startActivity(intent1);
//                        break;
//                    case R.id.history:
//                        Intent intent2 = new Intent(MainActivity.this, HistoryActivity.class);
//                        startActivity(intent2);
//                        break;
//                }
//                return true;
//            }
//        });