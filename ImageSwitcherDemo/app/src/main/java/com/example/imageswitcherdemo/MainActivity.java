package com.example.imageswitcherdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    boolean isFirstImageDisplayed = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView imageView = (ImageView) findViewById(R.id.imageView);
        imageView.setImageResource(R.drawable.landscape1);
        isFirstImageDisplayed = true;
    }

    public void changeImage(View view) {
        ImageView imageView = (ImageView) findViewById(R.id.imageView);
        if (isFirstImageDisplayed) {
            imageView.setImageResource(R.drawable.landscape2);
            isFirstImageDisplayed = false;
        } else {
            imageView.setImageResource(R.drawable.landscape1);
            isFirstImageDisplayed = true;
        }
    }
}