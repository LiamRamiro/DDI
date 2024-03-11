package com.example.examen.model;

public class DragonBall {
    private String ubicacion;
    private int starDots;

    public DragonBall(String ubicacion, int numEstrellas) {
        this.ubicacion = ubicacion;
        this.starDots = starDots;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public int getStarDots() {
        return starDots;
    }

    public void setStarDots(int starDots) {
        this.starDots = starDots;
    }
}