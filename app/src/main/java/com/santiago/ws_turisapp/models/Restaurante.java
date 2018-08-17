package com.santiago.ws_turisapp.models;

import java.io.Serializable;

public class Restaurante implements Serializable {

    private String nombre;
    private String descripcionCorta;
    private String ubicacion;
    private String descripcion;
    private long latitud;
    private long longitud;
    private int imagen;

    public Restaurante() {
    }

    public Restaurante(String nombre, String descripcionCorta, String ubicacion, String descripcion, double latitud, double longitud, int imagen) {
        this.nombre = nombre;
        this.descripcionCorta = descripcionCorta;
        this.ubicacion = ubicacion;
        this.descripcion = descripcion;
        this.latitud = (long) latitud;
        this.longitud = (long) longitud;
        this.imagen = imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcionCorta() {
        return descripcionCorta;
    }

    public void setDescripcionCorta(String descripcionCorta) {
        this.descripcionCorta = descripcionCorta;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public long getLatitud() {
        return latitud;
    }

    public void setLatitud(long latitud) {
        this.latitud = latitud;
    }

    public long getLongitud() {
        return longitud;
    }

    public void setLongitud(long longitud) {
        this.longitud = longitud;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }
}
