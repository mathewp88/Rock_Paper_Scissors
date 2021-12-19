package com.example.rockpaperscissors;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    TextView UserSelectedTextView, CompSelectedTextView, WinLoseTextView, ScoreTextView;

    Random random;

    int userScore = 0;
    int compScore = 0;

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
    }

    public void RPS_Select(View view) {

        int userSelection = Integer.parseInt(view.getTag().toString());
        Log.i(TAG, "RPS_Select: " + userSelection);
        matchGame(userSelection);
    }

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

    }

    private void setScoreTextView(int UserScore, int CompScore){
        ScoreTextView.setText(String.valueOf(UserScore) + " : " + String.valueOf(CompScore));
    }
}