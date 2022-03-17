package com.example.colorhelper.tabs.fragments;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.example.colorhelper.NewColorActivity;
import com.example.colorhelper.R;
import com.example.colorhelper.tabs.MainActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;


public class RelativeFragmment extends Fragment implements View.OnClickListener{

    FloatingActionButton fab;
    BottomNavigationView bottomNavigationView;

    FrameLayout choosenColor;
    FrameLayout complementaryColor;
    FrameLayout leftAnalagous;
    FrameLayout rightAnalogous;
    FrameLayout centralAnalogous;
    FrameLayout leftSplitComp;
    FrameLayout cenatralSplitComp;
    FrameLayout rightSplitComp;
    FrameLayout leftTriadic;
    FrameLayout rightTriadic;
    FrameLayout centralTriadic;

    String colorValue;
    TextView tw;
    TextView tw2;
    double anglerotation = 1d / 12;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_relative, container, false);
    }

    @Override
    public void onResume() {
        super.onResume();
        MainActivity mainActivity = (MainActivity) requireActivity();
        colorValue = mainActivity.color;
        choosenColor.setBackgroundColor(Color.parseColor("#"+colorValue));
//        tw.setText();
        centralAnalogous.setBackgroundColor(Color.parseColor("#"+colorValue));
        cenatralSplitComp.setBackgroundColor(Color.parseColor("#"+colorValue));
        centralTriadic.setBackgroundColor(Color.parseColor("#"+colorValue));
        rightAnalogous.setBackgroundColor(Color.parseColor("#"+RightAnalogousColor()));
        leftAnalagous.setBackgroundColor(Color.parseColor("#"+ leftAnalogousColor()));
        complementaryColor.setBackgroundColor(Color.parseColor("#"+ComplementaryColor()));
        leftSplitComp.setBackgroundColor(Color.parseColor("#"+leftSplitCOmplementary()));
        rightSplitComp.setBackgroundColor(Color.parseColor("#"+rightSplitCOmplementary()));
        rightTriadic.setBackgroundColor(Color.parseColor("#"+rightTriadic()));
        leftTriadic.setBackgroundColor(Color.parseColor("#"+lefttriadic()));
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        bottomNavigationView = view.findViewById(R.id.bottom_nav);
        tw = view.findViewById(R.id.textView);
        tw2 = view.findViewById(R.id.textView2);
        fab = view.findViewById(R.id.fab);

        rightAnalogous = view.findViewById(R.id.flRightAnalogous);
        centralAnalogous = view.findViewById(R.id.flAnalogous);
        choosenColor = view.findViewById(R.id.flColorChoosen);
        complementaryColor = view.findViewById(R.id.flCompColor);
        leftAnalagous = view.findViewById(R.id.flLeftAnalogous);
        leftSplitComp = view.findViewById(R.id.flLeftSplitComp);
        rightSplitComp = view.findViewById(R.id.flRightSplitComp);
        cenatralSplitComp = view.findViewById(R.id.flSplitComp);
        leftTriadic = view.findViewById(R.id.flLeftTriadic);
        rightTriadic = view.findViewById(R.id.flRIghtTriadic);
        centralTriadic = view.findViewById(R.id.flCenteTriadic);

        fab.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.fab:
                Intent intent = new Intent(v.getContext(), NewColorActivity.class);
                startActivityForResult(intent, 1);
                break;
                
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        colorValue = data.getStringExtra("colorValue");
        MainActivity mainActivity = (MainActivity) requireActivity();
        mainActivity.color = colorValue;
        choosenColor.setBackgroundColor(Color.parseColor("#"+colorValue));
//        tw.setText();
        centralAnalogous.setBackgroundColor(Color.parseColor("#"+colorValue));
        cenatralSplitComp.setBackgroundColor(Color.parseColor("#"+colorValue));
        centralTriadic.setBackgroundColor(Color.parseColor("#"+colorValue));
        rightAnalogous.setBackgroundColor(Color.parseColor("#"+RightAnalogousColor()));
        leftAnalagous.setBackgroundColor(Color.parseColor("#"+ leftAnalogousColor()));
        complementaryColor.setBackgroundColor(Color.parseColor("#"+ComplementaryColor()));
        leftSplitComp.setBackgroundColor(Color.parseColor("#"+leftSplitCOmplementary()));
        rightSplitComp.setBackgroundColor(Color.parseColor("#"+rightSplitCOmplementary()));
        rightTriadic.setBackgroundColor(Color.parseColor("#"+rightTriadic()));
        leftTriadic.setBackgroundColor(Color.parseColor("#"+lefttriadic()));

    }

    public String leftAnalogousColor(){

        String rS1 = colorValue.substring(0,2);
        String gS1 = colorValue.substring(2,4);
        String bS1 = colorValue.substring(4,6);

        int r1 = Integer.parseInt(rS1, 16);
        int g1 = Integer.parseInt(gS1, 16);
        int b1 = Integer.parseInt(bS1, 16);

        if (r1 < 16){
            r1 = 16;
        }
        if (g1 < 16){
            g1 = 16;
        }
        if (b1 < 16){
            b1 = 16;
        }

        int color = Color.rgb(r1, g1, b1);
        int red = Color.red(color);
        int green = Color.green(color);
        int blue = Color.blue(color);

        float[] hsv = new float[3];
        Color.RGBToHSV(red, green, blue, hsv);

        float anglerotation = 30f;

        if(hsv[0] - anglerotation < 0){
            hsv[0] = hsv[0] - anglerotation + 360;
        }else{
            hsv[0] -= anglerotation;
        }

        int leftColor = Color.HSVToColor(hsv);
        red = Color.red(leftColor);
        green = Color.green(leftColor);
        blue = Color.blue(leftColor);

        return Integer.toHexString(red) + "" + Integer.toHexString(green) + "" + Integer.toHexString(blue);
    }

    public String RightAnalogousColor(){

        String rS1 = colorValue.substring(0,2);
        String gS1 = colorValue.substring(2,4);
        String bS1 = colorValue.substring(4,6);

        int r1 = Integer.parseInt(rS1, 16);
        int g1 = Integer.parseInt(gS1, 16);
        int b1 = Integer.parseInt(bS1, 16);

        if (r1 < 16){
            r1 = 16;
        }
        if (g1 < 16){
            g1 = 16;
        }
        if (b1 < 16){
            b1 = 16;
        }

        int color = Color.rgb(r1, g1, b1);
        int red = Color.red(color);
        int green = Color.green(color);
        int blue = Color.blue(color);

        float[] hsv = new float[3];
        Color.RGBToHSV(red, green, blue, hsv);

        float anglerotation = 30f;

        if(hsv[0] + anglerotation > 360){
            hsv[0] = (hsv[0]+anglerotation) - 360;
        }else{
            hsv[0] += anglerotation;
        }

        int leftColor = Color.HSVToColor(hsv);
        red = Color.red(leftColor);
        green = Color.green(leftColor);
        blue = Color.blue(leftColor);

        return Integer.toHexString(red) + "" + Integer.toHexString(green) + "" + Integer.toHexString(blue);
    }

    public String ComplementaryColor(){
        String rS1 = colorValue.substring(0,2);
        String gS1 = colorValue.substring(2,4);
        String bS1 = colorValue.substring(4,6);
//        int complColor = Integer.parseInt(colorValue, 16);
        int r1 = Integer.parseInt(rS1, 16);
        int g1 = Integer.parseInt(gS1, 16);
        int b1 = Integer.parseInt(bS1, 16);

        if (r1 < 16){
            r1 = 16;
        }
        if (g1 < 16){
            g1 = 16;
        }
        if (b1 < 16){
            b1 = 16;
        }

        int x = Math.max(r1, Math.max(g1, b1)) + Math.min(r1, Math.min(g1, b1));
        int r2 =  x - r1;
        int g2 =  x - g1;
        int b2 =  x - b1;

        return Integer.toHexString(r2) + "" + Integer.toHexString(g2) + "" + Integer.toHexString(b2);
//        return Integer.toString(r2) + "" + Integer.toString(g2) + "" + Integer.toString(b2);
    }

    public String leftSplitCOmplementary(){
        String rS1 = colorValue.substring(0,2);
        String gS1 = colorValue.substring(2,4);
        String bS1 = colorValue.substring(4,6);
//        int complColor = Integer.parseInt(colorValue, 16);
        int r1 = Integer.parseInt(rS1, 16);
        int g1 = Integer.parseInt(gS1, 16);
        int b1 = Integer.parseInt(bS1, 16);

        if (r1 < 16){
            r1 = 16;
        }
        if (g1 < 16){
            g1 = 16;
        }
        if (b1 < 16){
            b1 = 16;
        }

        int x = Math.max(r1, Math.max(g1, b1)) + Math.min(r1, Math.min(g1, b1));
        int r2 =  x - r1;
        int g2 =  x - g1;
        int b2 =  x - b1;

        int color = Color.rgb(r2, g2, b2);
        int red = Color.red(color);
        int green = Color.green(color);
        int blue = Color.blue(color);

        float[] hsv = new float[3];
        Color.RGBToHSV(red, green, blue, hsv);

        float anglerotation = 30f;

        if(hsv[0] - anglerotation < 0){
            hsv[0] = hsv[0] - anglerotation + 360;
        }else{
            hsv[0] -= anglerotation;
        }

        int leftColor = Color.HSVToColor(hsv);
        red = Color.red(leftColor);
        green = Color.green(leftColor);
        blue = Color.blue(leftColor);

        return Integer.toHexString(red) + "" + Integer.toHexString(green) + "" + Integer.toHexString(blue);
    }

    public String rightTriadic(){
        String rS1 = colorValue.substring(0,2);
        String gS1 = colorValue.substring(2,4);
        String bS1 = colorValue.substring(4,6);
//        int complColor = Integer.parseInt(colorValue, 16);
        int r1 = Integer.parseInt(rS1, 16);
        int g1 = Integer.parseInt(gS1, 16);
        int b1 = Integer.parseInt(bS1, 16);

        if (r1 < 16){
            r1 = 16;
        }
        if (g1 < 16){
            g1 = 16;
        }
        if (b1 < 16){
            b1 = 16;
        }

        int x = Math.max(r1, Math.max(g1, b1)) + Math.min(r1, Math.min(g1, b1));
        int r2 =  x - r1;
        int g2 =  x - g1;
        int b2 =  x - b1;

        int color = Color.rgb(r2, g2, b2);
        int red = Color.red(color);
        int green = Color.green(color);
        int blue = Color.blue(color);

        float[] hsv = new float[3];
        Color.RGBToHSV(red, green, blue, hsv);

        float anglerotation = 120f;

        if(hsv[0] + anglerotation > 360){
            hsv[0] = (hsv[0]+anglerotation) - 360;
        }else{
            hsv[0] += anglerotation;
        }

        int leftColor = Color.HSVToColor(hsv);
        red = Color.red(leftColor);
        green = Color.green(leftColor);
        blue = Color.blue(leftColor);

        return Integer.toHexString(red) + "" + Integer.toHexString(green) + "" + Integer.toHexString(blue);
    }

    public String rightSplitCOmplementary(){
        String rS1 = colorValue.substring(0,2);
        String gS1 = colorValue.substring(2,4);
        String bS1 = colorValue.substring(4,6);
//        int complColor = Integer.parseInt(colorValue, 16);
        int r1 = Integer.parseInt(rS1, 16);
        int g1 = Integer.parseInt(gS1, 16);
        int b1 = Integer.parseInt(bS1, 16);

        if (r1 < 16){
            r1 = 16;
        }
        if (g1 < 16){
            g1 = 16;
        }
        if (b1 < 16){
            b1 = 16;
        }

        int x = Math.max(r1, Math.max(g1, b1)) + Math.min(r1, Math.min(g1, b1));
        int r2 =  x - r1;
        int g2 =  x - g1;
        int b2 =  x - b1;

        int color = Color.rgb(r2, g2, b2);
        int red = Color.red(color);
        int green = Color.green(color);
        int blue = Color.blue(color);

        float[] hsv = new float[3];
        Color.RGBToHSV(red, green, blue, hsv);

        float anglerotation = 30f;

        if(hsv[0] + anglerotation >= 360){
            hsv[0] = (hsv[0]+anglerotation) - 360;
        }else{
            hsv[0] += anglerotation;
        }

        int leftColor = Color.HSVToColor(hsv);
        red = Color.red(leftColor);
        green = Color.green(leftColor);
        blue = Color.blue(leftColor);

        return Integer.toHexString(red) + "" + Integer.toHexString(green) + "" + Integer.toHexString(blue);
    }

    public String lefttriadic(){
        String rS1 = colorValue.substring(0,2);
        String gS1 = colorValue.substring(2,4);
        String bS1 = colorValue.substring(4,6);
//        int complColor = Integer.parseInt(colorValue, 16);
        int r1 = Integer.parseInt(rS1, 16);
        int g1 = Integer.parseInt(gS1, 16);
        int b1 = Integer.parseInt(bS1, 16);

        if (r1 < 16){
            r1 = 16;
        }
        if (g1 < 16){
            g1 = 16;
        }
        if (b1 < 16){
            b1 = 16;
        }

        int x = Math.max(r1, Math.max(g1, b1)) + Math.min(r1, Math.min(g1, b1));
        int r2 =  x - r1;
        int g2 =  x - g1;
        int b2 =  x - b1;

        int color = Color.rgb(r2, g2, b2);
        int red = Color.red(color);
        int green = Color.green(color);
        int blue = Color.blue(color);

        float[] hsv = new float[3];
        Color.RGBToHSV(red, green, blue, hsv);

        float anglerotation = 120f;

        if(hsv[0] - anglerotation < 0){
            hsv[0] = (hsv[0]-anglerotation) + 360;
        }else{
            hsv[0] -= anglerotation;
        }

        int leftColor = Color.HSVToColor(hsv);
        red = Color.red(leftColor);
        green = Color.green(leftColor);
        blue = Color.blue(leftColor);

        return Integer.toHexString(red) + "" + Integer.toHexString(green) + "" + Integer.toHexString(blue);
    }

}