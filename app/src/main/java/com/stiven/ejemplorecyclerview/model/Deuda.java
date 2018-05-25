package com.stiven.ejemplorecyclerview.model;

public class Deuda {
    private String nombre;
    private String deuda;

    public Deuda(String nombre, String deuda) {
        this.nombre = nombre;
        this.deuda = deuda;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDeuda() {
        return deuda;
    }

    public void setDeuda(String deuda) {
        this.deuda = deuda;
    }
}
