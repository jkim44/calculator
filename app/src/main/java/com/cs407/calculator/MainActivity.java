package com.cs407.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText inputOne = findViewById(R.id.integerOne);
        final EditText inputTwo = findViewById(R.id.integerTwo);
        final TextView errorMessageTextView = findViewById(R.id.errorMessage);

        Button addition = findViewById(R.id.addition);
        Button subtraction = findViewById(R.id.subtraction);
        Button multiplication = findViewById(R.id.multiplication);
        Button division = findViewById(R.id.division);

        addition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculate(inputOne, inputTwo, errorMessageTextView, '+');
            }
        });

        subtraction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculate(inputOne, inputTwo, errorMessageTextView, '-');
            }
        });

        multiplication.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculate(inputOne, inputTwo, errorMessageTextView, '*');
            }
        });

        division.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculate(inputOne, inputTwo, errorMessageTextView, '/');
            }
        });
    }

    public void calculate(EditText inputOne, EditText inputTwo, TextView errorMessageTextView, char operation) {
        String integerOne = inputOne.getText().toString();
        String integerTwo = inputTwo.getText().toString();

        if (!integerOne.isEmpty() && !integerTwo.isEmpty()) {
            try {
                float floatOne = Float.parseFloat(integerOne);
                float floatTwo = Float.parseFloat(integerTwo);
                errorMessageTextView.setText("");
                errorMessageTextView.setVisibility(View.GONE);

                float result = 0;

                switch (operation) {
                    case '+':
                        result = floatOne + floatTwo;
                        break;
                    case '-':
                        result = floatOne - floatTwo;
                        break;
                    case '*':
                        result = floatOne * floatTwo;
                        break;
                    case '/':
                        if (floatTwo != 0) {
                            result = floatOne / floatTwo;
                        } else {
                            errorMessageTextView.setText("Divide by zero is invalid. Please try again");
                            errorMessageTextView.setVisibility(View.VISIBLE);
                            return; // Exit early if division by zero is attempted
                        }
                        break;
                }

                goToActivity(result);
            } catch (NumberFormatException e) {
                errorMessageTextView.setText("Invalid input. Enter a valid number.");
                errorMessageTextView.setVisibility(View.VISIBLE);
            }
        }
    }

    public void goToActivity(float result) {
        Intent intent = new Intent(this, CalculatorResult.class);
        intent.putExtra("floatValueKey", result);
        startActivity(intent);
    }
}