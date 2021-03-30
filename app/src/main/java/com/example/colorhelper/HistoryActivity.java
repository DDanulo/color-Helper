package com.example.colorhelper;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.colorhelper.tabs.fragments.HistoryAdapter;

import java.util.ArrayList;

public class HistoryActivity extends AppCompatActivity {

//    ArrayList<History> histories = new ArrayList<History>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

//        setInitialData();
//        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycle);
//
//        HistoryAdapter adapter = new HistoryAdapter(this, histories);
//        recyclerView.setAdapter(adapter);
    }

//    private void setInitialData(){
//        histories.add(new History("#213f54", "200, 100, 50", 213554));
//    }
}