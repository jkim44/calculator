package com.cs407.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class CalculatorResult extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator_result);
        textView=(TextView) findViewById(R.id.textView);
        Intent intent = getIntent();
        float number = getIntent().getFloatExtra("floatValueKey", 0.0f);
        textView.setText("" + number);
    }
}