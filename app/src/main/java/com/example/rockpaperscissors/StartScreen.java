package com.example.rockpaperscissors;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class StartScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_screen);

        }

        //Starts the game
        public void StartButton(View view){

            Intent n = new Intent(this, MainActivity.class);
            startActivity(n);

        }

        //Exits the app
        public void ExitButton(View view){

            finish();
            finishAffinity();
            System.exit(0);

        }

    }