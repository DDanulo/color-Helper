package com.example.colorhelper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Switch;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    FloatingActionButton fab;
    BottomNavigationView bottomNavigationView;

    FrameLayout choosenColor;
    FrameLayout complementaryColor;
    FrameLayout leftAnalagous;
    FrameLayout rightAnalogous;
    FrameLayout centralAnalogous;

    String colorValue;
    TextView tw;
    TextView tw2;
    double anglerotation = 1d / 12;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottom_nav);
        tw = findViewById(R.id.textView);
        tw2 = findViewById(R.id.textView2);
        fab = findViewById(R.id.fab);

        rightAnalogous = findViewById(R.id.flRightAnalogous);
        centralAnalogous = findViewById(R.id.flAnalogous);
        choosenColor = findViewById(R.id.flColorChoosen);
        complementaryColor = findViewById(R.id.flCompColor);
        leftAnalagous = findViewById(R.id.flLeftAnalogous);
        fab.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.fab:
                Intent intent = new Intent(this, NewColorActivity.class);
                startActivityForResult(intent, 1);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        colorValue = data.getStringExtra("colorValue");
        choosenColor.setBackgroundColor(Color.parseColor("#"+colorValue));
//        tw.setText();
        centralAnalogous.setBackgroundColor(Color.parseColor("#"+colorValue));
        rightAnalogous.setBackgroundColor(Color.parseColor("#"+RightAnalogousColor()));
        leftAnalagous.setBackgroundColor(Color.parseColor("#"+ leftAnalogousColor()));
        complementaryColor.setBackgroundColor(Color.parseColor("#"+ComplementaryColor()));
    }

    public String leftAnalogousColor(){

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
//        tw.setText(String.valueOf(hsv[0]));
        float hue = hsv[0];
        float sat = hsv[1];
        float val = hsv[2];
        float anglerotation = 30f;

        hsv[0] -= anglerotation;
//        tw2.setText(String.valueOf(hsv[0]));
        int leftColor = Color.HSVToColor(hsv);
        red = Color.red(leftColor);
        green = Color.green(leftColor);
        blue = Color.blue(leftColor);

//        return red, green, blue;
        return Integer.toHexString(red) + "" + Integer.toHexString(green) + "" + Integer.toHexString(blue);
    }

    public String RightAnalogousColor(){

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
//        tw.setText(String.valueOf(hsv[0]));
        float hue = hsv[0];
        float sat = hsv[1];
        float val = hsv[2];
        float anglerotation = 30f;

        hsv[0] += anglerotation;
//        tw2.setText(String.valueOf(hsv[0]));
        int leftColor = Color.HSVToColor(hsv);
        red = Color.red(leftColor);
        green = Color.green(leftColor);
        blue = Color.blue(leftColor);

//        return red, green, blue;
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

        int x = Math.max(r1, Math.max(g1, b1)) + Math.min(r1, Math.min(g1, b1));
        int r2 =  x - r1;
        int g2 =  x - g1;
        int b2 =  x - b1;

        return Integer.toHexString(r2) + "" + Integer.toHexString(g2) + "" + Integer.toHexString(b2);
    }

}
