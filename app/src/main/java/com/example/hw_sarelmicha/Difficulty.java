package com.example.hw_sarelmicha;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class Difficulty extends AppCompatActivity {

    private final int EASY_MODE = 3;
    private final int HARD_MODE = 4;
    private final int EXPERT_MODE = 5;
    private Button easyBtn;
    private Button hardBtn;
    private Button expertBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_difficulty);

        setIds();
        setClickListeners();

    }

    @Override
    protected void onPause() {
        OpenScreen.mediaPlayer.pause();;
        super.onPause();
    }

    @Override
    protected void onResume() {
        OpenScreen.mediaPlayer.start();
        super.onResume();
    }

    private void setIds(){

        easyBtn = (Button)findViewById(R.id.easy_btn);
        hardBtn = (Button)findViewById(R.id.hard_btn);
        expertBtn = (Button)findViewById(R.id.expert_btn);
    }

    private void setClickListeners(){

        easyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                passDifficultyToAnotherActivity(EASY_MODE);
            }
        });


        hardBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                passDifficultyToAnotherActivity(HARD_MODE);
            }
        });


        expertBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                passDifficultyToAnotherActivity(EXPERT_MODE);
            }
        });

    }

    private void passDifficultyToAnotherActivity(int difficulty){

        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("difficulty",difficulty);
        startActivity(intent);
        finish();
    }




}