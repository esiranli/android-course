package com.example.higherorlowerdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private int myRandomNumber;
    private Button playAgainButton;
    private EditText guessEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        generateRandomNumber();
        Log.i("MainActivity", String.valueOf(myRandomNumber));
    }

    public void sendNumber(View view) {
        Log.i("MainActivity", "Button pressed!");
        // Access to edit text
        guessEditText = (EditText) findViewById(R.id.guessEditText);
        // Read value from edit text
        String guessStringValue = guessEditText.getText().toString();

        // Message creation
        String message;
        // check given guess value is empty
        if (guessStringValue.isEmpty()) {
            message = "You should first give a number please!";
        } else {
            // Convert string guess value to integer
            int guessNumber = Integer.parseInt(guessStringValue);
            // Compare given number with random number
            if (guessNumber > myRandomNumber) {
                // show message as lower
                message = "Lower!";
            } else if (guessNumber < myRandomNumber) {
                message = "Higher!";
            } else {
                message = "You found it!";
                playAgainButton = (Button) findViewById(R.id.playAgainButton);
                playAgainButton.setVisibility(View.VISIBLE);
            }
        }
        // Show toast message
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    public void playAgain(View view) {
        generateRandomNumber();
        playAgainButton.setVisibility(View.GONE);
        guessEditText.setText("");
    }

    private void generateRandomNumber() {
        Random random = new Random();
        myRandomNumber = random.nextInt(20) + 1;
    }
}