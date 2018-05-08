package com.example.edwin.contactos_app;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    private Context mContext ;
    private List<Contacto> listaContacto ;
    private Contacto contactoSelected;


    public RecyclerViewAdapter(Context mContext, List<Contacto> listaContacto) {
        this.mContext = mContext;
        this.listaContacto = listaContacto;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view ;
        LayoutInflater mInflater = LayoutInflater.from(mContext);
        view = mInflater.inflate(R.layout.cardview_item_contacto,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {

        holder.nombre_contacto_cardview.setText(listaContacto.get(position).getNombre());
        if(listaContacto.get(position).getImagenUri() != null){
            holder.imagen_contacto_cardview.setImageURI(listaContacto.get(position).getImagenUri());
        }
        else{
        holder.imagen_contacto_cardview.setImageResource(listaContacto.get(position).getImagen());}
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(mContext,ActivityContacto.class);
                String nombre = listaContacto.get(position).getNombre();
                String telefono = listaContacto.get(position).getTelefono();
                String correo = listaContacto.get(position).getCorreo();
                int imagen = listaContacto.get(position).getImagen();

                // Pasando los datos a la nueva actividad
                if(nombre != null){ intent.putExtra("Nombre",nombre);}
                else{intent.putExtra("Nombre","");}
                intent.putExtra("Telefono",telefono);
                if(correo != null){intent.putExtra("Correo",correo);}
                else{intent.putExtra("Correo","");}
                if(listaContacto.get(position).getImagenUri()!=null){intent.putExtra("Uri",listaContacto.get(position).getImagenUri().toString());}
                else{intent.putExtra("Imagen",imagen);}

                // Inicializamos la nueva actividad
                mContext.startActivity(intent);

            }
        });



    }

    @Override
    public int getItemCount() {
        return listaContacto.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView nombre_contacto_cardview;
        ImageView imagen_contacto_cardview;
        CardView cardView ;

        public MyViewHolder(View itemView) {
            super(itemView);

            nombre_contacto_cardview = (TextView) itemView.findViewById(R.id.nombre_contacto_cardview) ;
            imagen_contacto_cardview = (ImageView) itemView.findViewById(R.id.imagen_contacto_cardview);
            cardView = (CardView) itemView.findViewById(R.id.cardview_id);


        }
    }


}

