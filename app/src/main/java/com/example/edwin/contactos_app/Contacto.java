package com.example.edwin.contactos_app;
import android.net.Uri;
public class Contacto {
    private String nombre;
    private String telefono;
    private String correo;
    private int imagen;
    private Uri imagenUri;

    public Contacto(String nombre, String telefono, String correo, int imagen) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.correo = correo;
        this.imagen = imagen;
    }


    public Contacto() {
    }
    public Uri getImagenUri(){return imagenUri;}
    public void setImagenUri(Uri imagenUri){this.imagenUri = imagenUri;}
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }
}
