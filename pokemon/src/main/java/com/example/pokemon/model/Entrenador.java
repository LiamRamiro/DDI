package com.example.pokemon.model;

public class Entrenador {

    private int id;

    private String nombre;

    private boolean active;

    public Entrenador() {

    }

    public Entrenador(int id, String nombre, boolean active) {
        this.id = id;
        this.nombre = nombre;
        this.active = active;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
