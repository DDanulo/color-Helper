package com.example.colorhelper;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class NewColorActivity extends AppCompatActivity implements View.OnClickListener{

    EditText et;
    Button add;
    public String colorValueHex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_color);

        et = findViewById(R.id.editTextColorValue);
        add = findViewById(R.id.btAddColor);

        add.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btAddColor:
                Intent data = new Intent();
                data.putExtra("colorValue", et.getText().toString());
                setResult(RESULT_OK, data);
                finish();
                break; 
        }
    }
}