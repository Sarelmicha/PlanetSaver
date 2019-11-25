package com.example.hw_sarelmicha;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.io.Serializable;

public class OpenScreen extends AppCompatActivity {

    private Button newGameBtn;
    private Button exitBtn;
    private MediaPlayer mediaPlayer;
    private boolean isNewGameOccurred = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_open_screen);

        //Initialize Buttons
       newGameBtn = (Button)findViewById(R.id.newGameBtn);
       exitBtn = (Button)findViewById(R.id.exitBtn);

        startSoundtrack();
        addListenersButtons();

    }

    @Override
    protected void onPause() {
        Log.d("CHECK", "onPause:im on pause now! ");
        super.onPause();
    }

    @Override
    protected void onResume() {
        Log.d("CHECK", "onPause:im on resume now! ");
        isNewGameOccurred = false;
        mediaPlayer.start();
        super.onResume();
    }

    @Override
    protected void onStop() {
        Log.d("CHECK", "onPause:im on stop now! ");
        if(!isNewGameOccurred) {
            mediaPlayer.pause();
        } 

        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.d("CHECK", "onPause:im on desttory now! ");
        super.onDestroy();
    }


    void startSoundtrack(){
        mediaPlayer = MediaPlayer.create(this, R.raw.gamemusic);
        mediaPlayer.setLooping(true);
        mediaPlayer.start();
    }

    private void addListenersButtons(){

        newGameBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                newGame();
            }
        });

        exitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                exitGame();
            }
        });
    }

    private void resumeGame() {
        Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }

    private void newGame() {
        Intent intent = new Intent(this, MainActivity.class);
        isNewGameOccurred = true;
        startActivity(intent);
    }

    public static void exitGame() {
        System.exit(0);
    }
}
