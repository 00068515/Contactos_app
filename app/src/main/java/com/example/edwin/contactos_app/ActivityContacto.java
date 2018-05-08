package com.example.edwin.contactos_app;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ActivityContacto extends AppCompatActivity {
    private TextView nombre_contacto;
    private TextView telefono_contacto;
    private TextView correo_contacto;
    private ImageView imagen_contacto;
    private ImageView call_contacto;
    private ImageView share_contacto;

    Contacto contactoInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);

        nombre_contacto = (TextView) findViewById(R.id.nombre_contacto);
        telefono_contacto = (TextView) findViewById(R.id.telefono_contacto);
        correo_contacto = (TextView) findViewById(R.id.correo_contacto);
        imagen_contacto = (ImageView) findViewById(R.id.imagen_contacto);
        call_contacto = (ImageView) findViewById(R.id.call_botton);
        share_contacto = (ImageView) findViewById(R.id.share_botton);

        // Recibiendo datos
        // Bundle bundle = getIntent().getExtras();
        Intent intent = getIntent();
        final String nombre = intent.getExtras().getString("Nombre");
        final String telefono = intent.getExtras().getString("Telefono");
        final String correo = intent.getExtras().getString("Correo");
        if (intent.getExtras().getString("Uri") != null) {
            imagen_contacto.setImageURI(android.net.Uri.parse(intent.getExtras().getString("Uri")));
        } else {
            int imagen = intent.getExtras().getInt("imagen");
            imagen_contacto.setImageResource(imagen);
        }

        // Seteando los valores

        nombre_contacto.setText(nombre + "");
        telefono_contacto.setText(telefono + "");
        correo_contacto.setText(correo + "");
        share_contacto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent compartir = new Intent(Intent.ACTION_SEND);
                compartir = new Intent(Intent.ACTION_SEND);
                compartir.putExtra(Intent.EXTRA_TEXT,"Nombre: "+nombre+"Telefono:"+telefono +"Correo:"+correo);
                compartir.setType("text/plain");
                v.getContext().startActivity(Intent.createChooser(compartir,"Compartir informacion de contacto"));
            }
        });
        call_contacto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent llamar = new Intent(Intent.ACTION_CALL);
                llamar.setData(Uri.parse("tel:" + telefono));
                if (ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    return;
                }
                v.getContext().startActivity(llamar);
            }
        });

    }
}
