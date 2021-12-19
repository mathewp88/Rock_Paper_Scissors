package com.example.rockpaperscissors;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    TextView UserSelectedTextView, CompSelectedTextView, WinLoseTextView, ScoreTextView;

    Random random;

    public int userScore;
    public int compScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        UserSelectedTextView = findViewById(R.id.UserSelectedTextView);
        CompSelectedTextView = findViewById(R.id.CompSelectedTextView);
        WinLoseTextView = findViewById(R.id.WinLoseTextView);
        ScoreTextView = findViewById(R.id.ScoreTextView);

        UserSelectedTextView.setText("");
        CompSelectedTextView.setText("");
        WinLoseTextView.setText("");

        random = new Random();

        userScore = 0;
        compScore = 0;
        ScoreTextView.setText("0 : 0");

    }

    // Selects rock paper or scissors
    public void RPS_Select(View view) {

        int userSelection = Integer.parseInt(view.getTag().toString());
        Log.i(TAG, "RPS_Select: " + userSelection);
        matchGame(userSelection);
    }

    //Resets the game to 0:0 score
    public void ResetButton(View view) {

        WinLoseTextView.setText("");
        UserSelectedTextView.setText("");
        CompSelectedTextView.setText("");
        userScore = 0;
        compScore = 0;
        setScoreTextView(userScore, compScore);

    }

    private void matchGame(int userSelection){

        int low = 1;
        int high = 3;

        int compSelection = random.nextInt(high) + low;

        if(userSelection == compSelection){
            //Tie
            WinLoseTextView.setText("Tie");
        } else if((userSelection - compSelection) % 3 == 1){
            //User Wins
            userScore++;
            WinLoseTextView.setText("Yay!, You Won.");
        }
        else{
            //Comp Wins
            compScore++;
            WinLoseTextView.setText("Oops, You Lost");
        }

        //Shows user selection
        switch (userSelection){

            case 1:
                UserSelectedTextView.setText("Rock");
                break;

            case 2:
                UserSelectedTextView.setText("Paper");
                break;

            case 3:
                UserSelectedTextView.setText("Scissors");
                break;
        }

        //shows computer selection
        switch (compSelection){

            case 1:
                CompSelectedTextView.setText("Rock");
                break;

            case 2:
                CompSelectedTextView.setText("Paper");
                break;

            case 3:
                CompSelectedTextView.setText("Scissors");
                break;
        }

        setScoreTextView(userScore, compScore);

        if(userScore == 5 || compScore == 5){
            //Pause for 750 milliseconds
            try {
                Thread.sleep(750);
            } catch (InterruptedException e) {e.printStackTrace();}
            //Go to Start Screen
            Intent i = new Intent(this, StartScreen.class);
            startActivity(i);
            }
        }

        //sets the score after a game
    private void setScoreTextView(int UserScore, int CompScore){
        ScoreTextView.setText(String.valueOf(UserScore) + " : " + String.valueOf(CompScore));
    }
}