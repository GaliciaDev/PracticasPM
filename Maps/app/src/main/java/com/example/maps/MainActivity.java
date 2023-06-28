package com.example.maps;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity{
    private Button Mapa_btn;
    @Override
    protected void onCreate(Bundle savedInstanseState){
        super.onCreate(savedInstanseState);
        setContentView(R.layout.activity_main);

        Mapa_btn = findViewById(R.id.mapa);

        Mapa_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( MainActivity.this, MapsActivity.class);
                startActivity(intent);
            }
        });
    }
}