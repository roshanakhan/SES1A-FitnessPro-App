package com.example.roshanakhan.myapplication;

import android.content.Intent;
import android.media.MediaPlayer;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;



public class MusicPlayer extends AppCompatActivity {
    private Button play,pause,search,spotify,stop;
    private MediaPlayer mediaPlayer;
    private EditText edittext;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.musicplayer);
        initView();



    }

    private void initView() {
        play = findViewById(R.id.btn_play);
        pause =findViewById(R.id.btn_pause);
        search = findViewById(R.id.btn_search);
        stop = findViewById(R.id.btn_stop);
        edittext = (EditText) findViewById(R.id.et1);
        spotify = findViewById(R.id.btn_spotify);




        //web player
        spotify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MusicPlayer.this, Spotify.class);
                startActivity(intent);
            }
        });



        //search
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputtext = edittext.getText().toString().toLowerCase();
                if (inputtext.length() == 0 )
                    Toast.makeText(MusicPlayer.this, "please type something", Toast.LENGTH_SHORT).show();
                else if ("android".contains(inputtext)) {
                    Toast.makeText(MusicPlayer.this, "music android found", Toast.LENGTH_SHORT).show();
                    mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.android);
                }
                else if ("fade".contains(inputtext)) {
                    Toast.makeText(MusicPlayer.this, "music fade found", Toast.LENGTH_SHORT).show();
                    mediaPlayer = MediaPlayer.create(getApplicationContext(),R.raw.daybreak);
                }
                else if ("daybreak".contains(inputtext)) {
                    Toast.makeText(MusicPlayer.this, "music daybreak found", Toast.LENGTH_SHORT).show();
                    mediaPlayer = MediaPlayer.create(getApplicationContext(),R.raw.daybreak);
                }
                else if ("higher".contains(inputtext)) {
                    Toast.makeText(MusicPlayer.this, "music higher found", Toast.LENGTH_SHORT).show();
                    mediaPlayer = MediaPlayer.create(getApplicationContext(),R.raw.higher);
                }
                else if ("intro".contains(inputtext)) {
                    Toast.makeText(MusicPlayer.this, "music intro found", Toast.LENGTH_SHORT).show();
                    mediaPlayer = MediaPlayer.create(getApplicationContext(),R.raw.intro);
                }
                else if ("life".contains(inputtext)) {
                    Toast.makeText(MusicPlayer.this, "music life found", Toast.LENGTH_SHORT).show();
                    mediaPlayer = MediaPlayer.create(getApplicationContext(),R.raw.life);
                }
                else if ("pdd".contains(inputtext)) {
                    Toast.makeText(MusicPlayer.this, "music pdd found", Toast.LENGTH_SHORT).show();
                    mediaPlayer = MediaPlayer.create(getApplicationContext(),R.raw.pdd);
                }
                else if ("shadows".contains(inputtext)) {
                    Toast.makeText(MusicPlayer.this, "music shadows found", Toast.LENGTH_SHORT).show();
                    mediaPlayer = MediaPlayer.create(getApplicationContext(),R.raw.shadows);
                }
                else if ("spectre".contains(inputtext)) {
                    Toast.makeText(MusicPlayer.this, "music spectre", Toast.LENGTH_SHORT).show();
                    mediaPlayer = MediaPlayer.create(getApplicationContext(),R.raw.spectre);
                }
                else if ("trip".contains(inputtext)) {
                    Toast.makeText(MusicPlayer.this, "music trip found", Toast.LENGTH_SHORT).show();
                    mediaPlayer = MediaPlayer.create(getApplicationContext(),R.raw.trip);
                }
                else if ("windfall".contains(inputtext)) {
                    Toast.makeText(MusicPlayer.this, "music windfall", Toast.LENGTH_SHORT).show();
                    mediaPlayer = MediaPlayer.create(getApplicationContext(),R.raw.windfall);
                }
                else
                    Toast.makeText(MusicPlayer.this, "music not found, please search on Spotify", Toast.LENGTH_SHORT).show();
            }
        });


        //play
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputtext = edittext.getText().toString().toLowerCase();
                if (inputtext.length() == 0)
                    Toast.makeText(MusicPlayer.this, "please type something", Toast.LENGTH_SHORT).show();
                else { try {
                    mediaPlayer.prepare();
                } catch (IllegalStateException e) {

                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                    mediaPlayer.start();
                }
            }
        });

        //pause
        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputtext = edittext.getText().toString().toLowerCase();
                if (inputtext.length() == 0)
                    Toast.makeText(MusicPlayer.this, "please type something", Toast.LENGTH_SHORT).show();
                else mediaPlayer.pause();
            }
        });

        //stop
        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputtext = edittext.getText().toString().toLowerCase();
                if (inputtext.length() == 0)
                    Toast.makeText(MusicPlayer.this, "please play a music", Toast.LENGTH_SHORT).show();
                else mediaPlayer.stop();
            }
        });
    }
}