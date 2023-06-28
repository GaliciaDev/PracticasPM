package com.example.cronometro;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class ActivityService extends Activity {

    private TextView textoCronometro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textoCronometro = (TextView) findViewById(R.id.cronometro);

        ImageButton startButton = (ImageButton) findViewById(R.id.btn_iniciar);
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iniciarCronometro();
            }
        });

        ImageButton stopButton = (ImageButton) findViewById(R.id.btn_finalizar);
        stopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pararCronometro();
            }
        });

        Cronometro.setUpdateListener(this);
    }

    @Override
    protected void onDestroy() {
        // Antes de cerrar la aplicacion se para el servicio (el cronometro)
        pararCronometro();
        super.onDestroy();
    }

    private void iniciarCronometro() {
        Intent service = new Intent(this, Cronometro.class);
        startService(service);
    }

    private void pararCronometro() {
        Intent service = new Intent(this, Cronometro.class);
        stopService(service);
    }

    public void actualizarCronometro(double tiempo) {
        textoCronometro.setText(String.format("%.2f", tiempo) + "s");
    }
}