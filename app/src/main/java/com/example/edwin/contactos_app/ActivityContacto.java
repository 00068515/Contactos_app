package com.example.edwin.contactos_app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ActivityContacto extends AppCompatActivity{
    private TextView nombre_contacto;
    private TextView telefono_contacto;
    private TextView correo_contacto;
    private ImageView imagen_contacto;

    Contacto contactoInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);

        nombre_contacto = (TextView) findViewById(R.id.nombre_contacto);
        telefono_contacto = (TextView) findViewById(R.id.telefono_contacto);
        correo_contacto = (TextView) findViewById(R.id.correo_contacto);
        imagen_contacto = (ImageView) findViewById(R.id.imagen_contacto);

        // Recibiendo datos
       // Bundle bundle = getIntent().getExtras();
        Intent intent = getIntent();
        String nombre = intent.getExtras().getString("Nombre");
        String telefono = intent.getExtras().getString("Telefono");
        String correo = intent.getExtras().getString("Correo");
        if(intent.getExtras().getString("Uri") != null){
            imagen_contacto.setImageURI(android.net.Uri.parse(intent.getExtras().getString("Uri")));
        }
        else{
            int imagen = intent.getExtras().getInt("imagen");
            imagen_contacto.setImageResource(imagen);}

        // Seteando los valores

        nombre_contacto.setText(nombre+"");
        telefono_contacto.setText(telefono+"");
        correo_contacto.setText(correo+"");



    }
}
