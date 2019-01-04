package com.example.android.musicplayer;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Toast;

import static android.R.attr.button;

public class MainActivity extends AppCompatActivity {
    private MediaPlayer mediaplayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mediaplayer = MediaPlayer.create(this, R.raw.hello);

        Button playbutton = (Button) findViewById(R.id.play_button);
        playbutton.setOnClickListener(new View.OnClickListener() {
                                          @Override
                                          public void onClick(View view) {
                                              mediaplayer.start();
                                              mediaplayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                                                  @Override
                                                  public void onCompletion(MediaPlayer mediaPlayer) {
                                                      Toast.makeText(MainActivity.this, "I'm done!", Toast.LENGTH_SHORT).show();
                                                  }
                                              });
                                          }
                                      }
        );
        Button pausebutton = (Button) findViewById(R.id.pause_button);
        pausebutton.setOnClickListener(new View.OnClickListener() {
                                           @Override
                                           public void onClick(View view) {
                                               mediaplayer.pause();
                                           }
                                       }
        );
    }
}
