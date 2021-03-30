package com.example.colorhelper.tabs.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.colorhelper.History;
import com.example.colorhelper.R;

import java.util.ArrayList;

public class HistoryFragment extends Fragment {

    ArrayList<History> histories = new ArrayList<History>();

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

        HistoryAdapter adapter = new HistoryAdapter(view.getContext(), histories);
        recyclerView.setAdapter(adapter);
    }

    private void setInitialData(){
        histories.add(new History("#213f54", "200, 100, 50", 213554));
    }
}