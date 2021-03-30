package com.example.colorhelper.tabs;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.colorhelper.tabs.fragments.HistoryFragment;
import com.example.colorhelper.tabs.fragments.InfoFragment;
import com.example.colorhelper.tabs.fragments.RelativeFragmment;

public class ViewPageTabAdapter extends FragmentStateAdapter {

    public ViewPageTabAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0:
                return new RelativeFragmment();
            case 1:
                return new InfoFragment();
            case 2:
                return new HistoryFragment();
        }
        return null;
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
