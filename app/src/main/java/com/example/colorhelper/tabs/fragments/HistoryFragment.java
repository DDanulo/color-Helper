package com.example.colorhelper.tabs.fragments;

import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.colorhelper.History;
import com.example.colorhelper.R;
import com.example.colorhelper.tabs.MainActivity;

import java.util.ArrayList;

public class HistoryFragment extends Fragment implements View.OnClickListener {

    ArrayList<History> histories = new ArrayList<History>();
    EditText insert;

    String colorValue;
    int i = -1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_history2, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setInitialData();
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recycle);
        insert = (EditText) view.findViewById(R.id.insertCode);
        Button add = (Button) view.findViewById(R.id.addCode);
        add.setOnClickListener(this);

        HistoryAdapter adapter = new HistoryAdapter(view.getContext(), histories);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onResume() {
        super.onResume();
//        colorValue = ((MainActivity) requireActivity()).color;
//        setInitialData();

        histories.add(new History(((MainActivity) requireActivity()).color, RGBValue(),
                Color.parseColor("#"+((MainActivity) requireActivity()).color)));
//        histories.add(new History(colorValue, RGBValue(), Color.parseColor("#"+colorValue)));
    }

    public String RGBValue(){
        String rS1 = (((MainActivity) requireActivity()).color).substring(0,2);
        String gS1 = (((MainActivity) requireActivity()).color).substring(2,4);
        String bS1 = (((MainActivity) requireActivity()).color).substring(4,6);

        int r1 = Integer.parseInt(rS1, 16);
        int g1 = Integer.parseInt(gS1, 16);
        int b1 = Integer.parseInt(bS1, 16);

        return r1 + "; " + g1 + "; " + b1;
    }



    private void setInitialData(){

        histories.add(i+1, new History(((MainActivity) requireActivity()).color, RGBValue(), Color.parseColor("#"+((MainActivity) requireActivity()).color)));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.addCode:
                MainActivity mainActivity = (MainActivity) requireActivity();
                mainActivity.color = insert.getText().toString();
                break;

        }

    }
}