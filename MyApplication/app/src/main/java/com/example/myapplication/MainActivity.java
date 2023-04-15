package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle("EURO-TL Converter");
        ImageView image = (ImageView) findViewById(R.id.imageView);
        image.setImageResource(R.drawable.currency);
    }

    public void onButtonClick(View view) {
        Log.d("MainActivity", "Button clicked");

        EditText amountEditText = (EditText) findViewById(R.id.editTextNumberDecimal);
        String givenAmountStr = amountEditText.getText().toString();
        double givenAmountInEuro = Double.parseDouble(givenAmountStr);
        double calculatedAmountInTL = givenAmountInEuro * 20.50;
        String result = Double.toString(calculatedAmountInTL);
        String message = givenAmountStr + " EU makes " + result + " TL";
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}