package com.example.timerdemo;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private SeekBar timerSeekBar;
    private TextView timerTextView;
    private Button goButton;

    private CountDownTimer timer;
    private boolean isTimerValid = false;

    private static final int MAX_DURATION = 300;
    private static final int INITIAL_DURATION = 60;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        timerSeekBar = findViewById(R.id.timerSeekBar);
        timerSeekBar.setMax(MAX_DURATION);
        timerSeekBar.setProgress(INITIAL_DURATION);
        timerSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int seconds, boolean fromUser) {
                Log.d("MainActivity", "Seekbar progress is " + seconds);
                updateTimerText(seconds);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        timerTextView = findViewById(R.id.timerTextView);
        timerTextView.setText(convertSecondsToTimeString(INITIAL_DURATION));

        goButton = findViewById(R.id.goButton);
        goButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isTimerValid) {
                    resetUI();
                    cancelTimer();
                } else {
                    updateUI();
                    startTimer();
                }
            }
        });
    }

    private String convertSecondsToTimeString(int progress) {
        int minutes = progress / 60;
        int seconds = progress % 60;
        return String.format("%02d:%02d", minutes, seconds);
    }

    private void updateTimerText(int seconds) {
        String timeString = convertSecondsToTimeString(seconds);
        timerTextView.setText(timeString);
    }

    private void startTimer() {
        timer = new CountDownTimer(timerSeekBar.getProgress() * 1000L, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                Log.d("MainActivity", ((int) millisUntilFinished / 1000) +" second is left");
                int seconds = (int) millisUntilFinished / 1000;
                updateTimerText(seconds);
            }

            @Override
            public void onFinish() {
                playSound();
                resetUI();
                cancelTimer();

            }
        };
        timer.start();
        isTimerValid = true;
    }

    private void cancelTimer() {
        timer.cancel();
        isTimerValid = false;
    }

    private void resetUI() {
        goButton.setText(R.string.go_button_title);
        timerSeekBar.setProgress(INITIAL_DURATION);
        timerSeekBar.setEnabled(true);
    }

    private void updateUI() {
        goButton.setText(R.string.stop_button_title);
        timerSeekBar.setEnabled(false);
    }

    private void playSound() {
        MediaPlayer mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.airhorn);
        mediaPlayer.start();
    }

    private void oldWayTimerCreation() {
        /*
        Handler handler = new Handler();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                Log.i("MainActivity", "Runnable run function is called");

                handler.postDelayed(this, 1000);
            }
        };
        handler.post(runnable);
         */
    }
}
