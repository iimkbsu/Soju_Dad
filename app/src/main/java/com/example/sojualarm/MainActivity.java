package com.example.sojualarm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.media.MediaPlayer;
import android.view.View;
import android.widget.Chronometer;
import android.os.SystemClock;


public class MainActivity extends AppCompatActivity {

    private Chronometer chronometer;
    private boolean running;
    private long pauseOffset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        chronometer = findViewById(R.id.chronometer);
        chronometer.setFormat("%s");

        findViewById(R.id.button_send).setOnClickListener(mClickListener);
    }

    View.OnClickListener mClickListener = new View.OnClickListener(){

        @Override
        public void onClick(View view){

            if(!running){
                chronometer.setBase(SystemClock.elapsedRealtime()-pauseOffset);
                chronometer.start();
                running = true;
            }

            MediaPlayer mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.sound);
            mediaPlayer.start();


            switch (view.getId()){
                case R.id.button_send:

                    new AlertDialog.Builder(MainActivity.this)
                            .setTitle("선언문")
                            .setMessage("나는 술을 마시고\n큰 소리를 내지 않을 것이며\n화내지 않을 것을\n선언합니다.")
                            .setNeutralButton("닫기", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {

                                }
                            })
                            .show();
                    break;


            }

        }
    };
}