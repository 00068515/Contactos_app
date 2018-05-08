package com.example.edwin.contactos_app;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Telephony;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ActivityAdd extends AppCompatActivity {
    EditText nombreIngresado;
    EditText telefonoIngresado;
    EditText correoIngresado;
    Button buttonAdd;
    String nombreIngre,telefonoIngre,correoIngre;
    public void onCreate(Bundle savedInstance) {
        super.onCreate(savedInstance);
        setContentView(R.layout.activity_add);

        nombreIngresado = (EditText) findViewById(R.id.edit_nombre);
        telefonoIngresado = (EditText) findViewById(R.id.edit_numero);
        correoIngresado = (EditText) findViewById(R.id.edit_correo);
        buttonAdd = (Button) findViewById(R.id.btn_crear_contacto);

        buttonAdd.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Context context =  getApplicationContext();
                nombreIngre = nombreIngresado.getText().toString();
                telefonoIngre = nombreIngresado.getText().toString();
                correoIngre = correoIngresado.getText().toString();
                Intent intent = new Intent(context, MainActivity.class);
                intent.putExtra("NombreIngre",nombreIngre);
                intent.putExtra("TelefonoIngre", telefonoIngre);
                intent.putExtra("CorreoIngre", correoIngre);
                intent.putExtra("ImagenIngre", R.drawable.default_contact_image);
                startActivity(intent);
            }
        });



    }
}
