package com.example.audio_ara;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    //Objetos
    private Button btnPlay, btnStartPause, btnStop;
    int estados = 0;
    private MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Iniciamos la clase MediaPlayer y el sonido inicial
        mediaPlayer = MediaPlayer.create(this, R.raw.alerta);
        mediaPlayer.start();
        //Enlace de objetos
        btnPlay = findViewById(R.id.btnPlay);
        btnStartPause = findViewById(R.id.btnStartPause);
        btnStop = findViewById(R.id.btnStop);
        //Asignamos la siguiente pista
        mediaPlayer = MediaPlayer.create(this, R.raw.lost_woods);
        //Asignamos los metodos OnClickListener
        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer.start();
                estados = 1;
                btnStartPause.setText("Pausa");
            }
        });
        btnStartPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(estados == 1) {
                    mediaPlayer.pause();
                    btnStartPause.setText("Play");
                    estados++;
                }
                else if(estados == 2) {
                    mediaPlayer.start();
                    btnStartPause.setText("Pausa");
                    estados--;
                }
            }
        });
        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    mediaPlayer.stop();
                    mediaPlayer.prepare();
                    mediaPlayer.seekTo(0);
                    estados = 0;
                    btnStartPause.setText("Pausa");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}