package com.example.connect3game;

import androidx.appcompat.app.AppCompatActivity;
import androidx.gridlayout.widget.GridLayout;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // 0: yellow, 1: red, 2: empty
    private int activePlayer = 0;
    private int[] gameState = {2, 2, 2, 2, 2, 2, 2, 2, 2};
    private final int[][] winningPositions = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8}, {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, {0, 4, 8}, {2, 4, 6}};
    private boolean isGameActive = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void buttonTapped(View view) {
        //1. Get the tag of pressed view
        ImageView pressedView = (ImageView) view;
        String tagStr = pressedView.getTag().toString();
        int tag = Integer.parseInt(tagStr);
        Log.i("MainActivity", "Button tapped with tag: " + tag);

        //2. Prevent user interaction if game is over or the view is not empty state
        if (!isGameActive || gameState[tag] != 2) return;

        //3. Update gameState with the value of activePlayer
        gameState[tag] = activePlayer;

        //4. if first player is played show yellow counter, otherwise red
        int resource;
        if (activePlayer == 0) {
            resource = R.drawable.yellow;
            activePlayer = 1;
        } else {
            resource = R.drawable.red;
            activePlayer = 0;
        }
        pressedView.setImageResource(resource);

        // 5. Animate counter move
        pressedView.setTranslationY(-1500f);
        pressedView.animate().translationYBy(1500f).setDuration(500);

        //6. Check any one of the winning positions is fulfilled
        //7. if so, finish the game
        //8. show toast message
        for (int[] winningPosition : winningPositions) {
            if (gameState[winningPosition[0]] == gameState[winningPosition[1]]
                    && gameState[winningPosition[1]] == gameState[winningPosition[2]]
                    && gameState[winningPosition[0]] != 2) {
                isGameActive = false;

                //Toast.makeText(this, winner + " has won!", Toast.LENGTH_SHORT).show();
                TextView winnerTextView = (TextView) findViewById(R.id.winnerTextView);
                String winner = gameState[winningPosition[0]] == 0 ? "Yellow" : "Red";
                winnerTextView.setText(winner + " has won!");
                winnerTextView.setVisibility(View.VISIBLE);

                Button playAgainButton = (Button) findViewById(R.id.playAgain);
                playAgainButton.setVisibility(View.VISIBLE);

                // !! New way to listen button click instead of using onClick attribute of the view like we used so far!!!
                playAgainButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // Make text view and button invisible
                        winnerTextView.setVisibility(View.INVISIBLE);
                        playAgainButton.setVisibility(View.INVISIBLE);

                        // Find grid layout and then clear all image views on it
                        GridLayout gridLayout = (GridLayout) findViewById(R.id.gridLayout);
                        for (int i = 0; i < gridLayout.getChildCount(); i++) {
                            ImageView imageView = (ImageView) gridLayout.getChildAt(i);
                            imageView.setImageDrawable(null);
                        }

                        // Reset all values to initial value
                        activePlayer = 0;
                        for (int i = 0; i < gameState.length; i++) {
                            gameState[i] = 2;
                        }
                        isGameActive = true;
                    }
                });
            }
        }
    }
}