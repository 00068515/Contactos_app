package com.example.edwin.contactos_app;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.provider.ContactsContract;
import android.database.Cursor;
import android.content.ContentResolver;
import java.util.ArrayList;
import java.util.List;
import android.support.design.widget.FloatingActionButton;
import android.net.Uri;
import android.view.View;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity{
    public static List<Contacto> listaContacto;
    RecyclerView rcv;
    RecyclerViewAdapter rcvA;
    FloatingActionButton fab;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Buscamos la informacion de los contactos del telefono y los guardamos en una lista
        if(listaContacto == null){
            phoneContacts();
        }
        else{
            addContact();
        }
        fab = (FloatingActionButton) findViewById(R.id.fab1);
        fab.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intentAdd = new Intent(getApplicationContext(),ActivityAdd.class);
                startActivity(intentAdd);
            }
        } );


        // Encontramos el RecyclerView y le mandamos a poner un adaptador, al adaptador le mandamos nuestros contactos
        rcv = (RecyclerView) findViewById(R.id.recyclerview_id);
        rcvA = new RecyclerViewAdapter(this,listaContacto);
        rcv.setLayoutManager(new GridLayoutManager(this,3));
        rcv.setAdapter(rcvA);
    }


    public void addContact(){
        Intent intent = getIntent();
        String nombre = intent.getExtras().getString("NombreIngre");
        String telefono = intent.getExtras().getString("TelefonoIngre");
        String correo = intent.getExtras().getString("CorreoIngre");
       /*if(intent.getExtras().getString("Uri") != null){
            imagen_contacto.setImageURI(android.net.Uri.parse(intent.getExtras().getString("Uri")));
        }
        else{
            int imagen = intent.getExtras().getInt("imagen");
            imagen_contacto.setImageResource(imagen);}*/
       int imagen = intent.getExtras().getInt("ImagenIngre");
       Contacto myContacto = new Contacto(nombre,telefono,correo,imagen);
       listaContacto.add(myContacto);
    }
    public void phoneContacts(){
        String[] pro = new String[] { ContactsContract.Data._ID, ContactsContract.Data.DISPLAY_NAME,
                ContactsContract.CommonDataKinds.Phone.NUMBER, ContactsContract.CommonDataKinds.Phone.TYPE };

        String selectionClause = ContactsContract.Data.MIMETYPE + "='" +
                ContactsContract.CommonDataKinds.Phone.CONTENT_ITEM_TYPE + "' AND "
                + ContactsContract.CommonDataKinds.Phone.NUMBER + " IS NOT NULL";

        String sortOrder = ContactsContract.Data.DISPLAY_NAME + " ASC";

        Cursor c = getContentResolver().query(
                ContactsContract.Data.CONTENT_URI,
                pro,
                selectionClause,
                null,
                sortOrder);
        listaContacto = new ArrayList<Contacto>();
        while(c.moveToNext()){
            Contacto contacto =  new Contacto();
            contacto.setNombre(c.getString(1));
            contacto.setTelefono((c.getString(2)));
            //Imagen y correo quemados
            contacto.setCorreo("correo@gmail.com");
            contacto.setImagen(R.drawable.default_contact_image);
            listaContacto.add(contacto);
           }
        c.close();


    }

}
