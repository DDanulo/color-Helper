package com.example.colorhelper.tabs.fragments;

import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.colorhelper.R;
import com.example.colorhelper.tabs.MainActivity;

public class InfoFragment extends Fragment {

    TextView twHexValue;
    TextView twRGBValue;
    TextView twHSVValue;
    TextView twCMYKValue;
    FrameLayout colorChoosen;

    String colorValue;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_info, container, false);
    }

    @Override
    public void onResume() {
        super.onResume();

        colorValue = ((MainActivity) requireActivity()).color;

        twHexValue.setText(String.format("#%s", colorValue));
        twRGBValue.setText(RGBValue());
        twHSVValue.setText(HSVValue());
        twCMYKValue.setText(rgbToCmyk());
        colorChoosen.setBackgroundColor(Color.parseColor("#"+colorValue));

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        twHexValue = getView().findViewById(R.id.HEX);
        twRGBValue = getView().findViewById(R.id.rgb);
        twHSVValue = getView().findViewById(R.id.hsv);
        twCMYKValue = getView().findViewById(R.id.cmyk);
        colorChoosen = getView().findViewById(R.id.frameLayout8);

    }
    public String RGBValue(){
        String rS1 = colorValue.substring(0,2);
        String gS1 = colorValue.substring(2,4);
        String bS1 = colorValue.substring(4,6);

        int r1 = Integer.parseInt(rS1, 16);
        int g1 = Integer.parseInt(gS1, 16);
        int b1 = Integer.parseInt(bS1, 16);

        return r1 + "; " + g1 + "; " + b1;
    }

    public String HSVValue(){
        String rS1 = colorValue.substring(0,2);
        String gS1 = colorValue.substring(2,4);
        String bS1 = colorValue.substring(4,6);

        int r1 = Integer.parseInt(rS1, 16);
        int g1 = Integer.parseInt(gS1, 16);
        int b1 = Integer.parseInt(bS1, 16);

        int color = Color.rgb(r1, g1, b1);
        int red = Color.red(color);
        int green = Color.green(color);
        int blue = Color.blue(color);

        float[] hsv = new float[3];
        Color.RGBToHSV(red, green, blue, hsv);

        return String.format("%.2f", hsv[0]) + "; " + String.format("%.2f",hsv[1]) + "; " + String.format("%.2f",hsv[2]);
    }

    private String rgbToCmyk() {

        String rS1 = colorValue.substring(0,2);
        String gS1 = colorValue.substring(2,4);
        String bS1 = colorValue.substring(4,6);

        int r1 = Integer.parseInt(rS1, 16);
        int g1 = Integer.parseInt(gS1, 16);
        int b1 = Integer.parseInt(bS1, 16);


        double percentageR = r1 / 255.0 * 100;
        double percentageG = g1 / 255.0 * 100;
        double percentageB = b1 / 255.0 * 100;

        int k = (int) (100 - Math.max(Math.max(percentageR, percentageG), percentageB));

        if (k == 100) {
            return "0, 0, 0, 100";
        }

        int c = (int) ((100 - percentageR - k) / (100 - k) * 100);
        int m = (int) ((100 - percentageG - k) / (100 - k) * 100);
        int y = (int) ((100 - percentageB - k) / (100 - k) * 100);

        return c + "; " + m + "; " + y + "; " + k;
    }
}