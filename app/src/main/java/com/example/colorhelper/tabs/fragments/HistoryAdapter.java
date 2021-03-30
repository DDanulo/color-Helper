package com.example.colorhelper.tabs.fragments;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.colorhelper.History;
import com.example.colorhelper.R;

import java.util.List;

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.ViewHolder> {

    private final LayoutInflater inflater;
    private final List<History> histories;

    HistoryAdapter(Context context, List<History> histories){
        this.histories = histories;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public HistoryAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HistoryAdapter.ViewHolder holder, int position) {
        History history = histories.get(position);
        holder.frameLayout.setBackgroundColor(history.getColorResourse());
        holder.colorHex.setText(history.getColorHex());
        holder.ColorRGB.setText(history.getColorRGB());

    }

    @Override
    public int getItemCount() {
        return histories.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        final FrameLayout frameLayout;
        final TextView colorHex;
        final TextView ColorRGB;
        ViewHolder(View view){
            super(view);
            frameLayout = (FrameLayout) view.findViewById(R.id.historycolorViewer);
            colorHex = (TextView) view.findViewById(R.id.historyTextHEX);
            ColorRGB = (TextView) view.findViewById(R.id.historyTextRGB);

        }
    }
}
