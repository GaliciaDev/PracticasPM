package com.example.uso_de_imagenes;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //Variables para enlazar el boton y la imagen
        ImageView imagen;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Enalce de los controles de la vista
        imagen = findViewById(R.id.imagen);
        imagen = findViewById(R.id.imagen);
        //Escucha cuando se pulse el boton camara
        imagen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                abrirCamara();
            }
        });
    }
    //Con esta funcion se crea el intet donde se ejecuta la camara
    private void abrirCamara(){
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if(intent.resolveActivity(getPackageManager()) != null){
            startActivityForResult(intent, 1);
        }
    }
    @Override
    //Con esta funcion se captura el resultado del intent
    protected void onActivityResult (int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imgBitmap = (Bitmap) extras.get("data");
            imagen.setImageBitmap(imgBitmap);
            Toast.makeText(this, "Esta es la Practica de uso de una Imagen", Toast.LENGTH_LONG).show();
        }
    }
}
