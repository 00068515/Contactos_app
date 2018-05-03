package com.example.edwin.contactos_app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<Contacto> listaContacto;
    RecyclerView rcv;
    RecyclerViewAdapter rcvA;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listaContacto = new ArrayList<>();
        listaContacto.add(new Contacto("Fulanito",78852972,"fulanito@gmail.com",R.drawable.default_contact_image));
        listaContacto.add(new Contacto("Meganito",79225067,"menganito@gmail.com",R.drawable.default_contact_image));
        listaContacto.add(new Contacto("Penchito",78736495,"penchito@gmail.com",R.drawable.default_contact_image));
        listaContacto.add(new Contacto("Serufino",73214124,"serufino@gmail.com",R.drawable.default_contact_image));
        listaContacto.add(new Contacto("Monulito",75654754,"monulito@gmail.com",R.drawable.default_contact_image));
        listaContacto.add(new Contacto("Juancito",77657657,"juancito@gmail.com",R.drawable.default_contact_image));
        listaContacto.add(new Contacto("Maxisun",78768675,"maxisun@gmail.com",R.drawable.default_contact_image));
        listaContacto.add(new Contacto("Maximus",77546456,"maximus@gmail.com",R.drawable.default_contact_image));
        listaContacto.add(new Contacto("MaxiPali",71232324,"maxipali@gmail.com",R.drawable.default_contact_image));
        listaContacto.add(new Contacto("Burgos",74324243,"burgos@gmail.com",R.drawable.default_contact_image));
        listaContacto.add(new Contacto("Exodia",74444443,"exodia@gmail.com",R.drawable.default_contact_image));

        rcv = (RecyclerView) findViewById(R.id.recyclerview_id);
        rcvA = new RecyclerViewAdapter(this,listaContacto);
        rcv.setLayoutManager(new GridLayoutManager(this,3));
        rcv.setAdapter(rcvA);
    }
}
