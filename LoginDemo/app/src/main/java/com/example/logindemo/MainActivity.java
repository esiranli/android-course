package com.example.logindemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void login(View view) {
        Log.i("MainActivity", "Login button pressed");
        EditText nameEditText = (EditText) findViewById(R.id.nameEditText);
        String name = nameEditText.getText().toString();

        EditText surnameEditText = (EditText) findViewById(R.id.surnameEditText);
        String surname = surnameEditText.getText().toString();

        String message = "Welcome " + name + " " + surname;
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}