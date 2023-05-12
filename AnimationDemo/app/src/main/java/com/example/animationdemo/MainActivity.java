package com.example.animationdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private ImageView bartImageView;
    private ImageView homerImageView;
    private boolean isBartShowing = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bartImageView = (ImageView) findViewById(R.id.imageView);
        homerImageView = (ImageView) findViewById(R.id.imageView2);

        bartImageView.setX(-1000);
        bartImageView.animate().rotation(3600).setDuration(1000); // rotation = dondurme
        bartImageView.animate().translationXBy(1000).setDuration(1000); // translation = hareket etme
        homerImageView.setScaleX(0.5f);
    }

    public void play(View view) {
        if (isBartShowing) {
            homerImageView.setScaleX(0.5f);
            bartImageView.animate().alpha(0.0f).setDuration(1000); // alpha = gorunulebilirlik
            homerImageView.animate().alpha(1.0f).setDuration(1000);
            homerImageView.animate().scaleX(1f).setDuration(1000); // scale = buyutup kucultme
            isBartShowing = false;
        } else {
            bartImageView.animate().alpha(1.0f).setDuration(1000);
            homerImageView.animate().alpha(0.0f).setDuration(1000);
            homerImageView.animate().rotation(3600).setDuration(1000);
            isBartShowing = true;
        }


//        float bartAlpha = isBartShowing ? 0.0f : 1.0f;
//        float homerAlpha = isBartShowing ? 1.0f : 0.0f;
//        bartImageView.animate().alpha(bartAlpha).setDuration(1000);
//        homerImageView.animate().alpha(homerAlpha).setDuration(1000);
//        isBartShowing = !isBartShowing;

    }
}