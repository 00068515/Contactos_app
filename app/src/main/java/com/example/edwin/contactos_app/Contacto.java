package com.example.edwin.contactos_app;

public class Contacto {
    private String nombre;
    private int telefono;
    private String correo;
    private int imagen;

    public Contacto(String nombre, int telefono, String correo, int imagen) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.correo = correo;
        this.imagen = imagen;
    }

    public Contacto() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
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
