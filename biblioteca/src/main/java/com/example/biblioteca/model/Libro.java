package com.example.biblioteca.model;

import lombok.Data;
import lombok.Getter;

import java.util.Date;

@Data
@Getter
public class Libro {

    private Integer id;
    private String isbn;

    private Integer ano;
    private int almacen_old;

    private int almacen_new;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }


    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public int getAlmacen_old() {
        return almacen_old;
    }

    public void setAlmacen_old(int almacen_old) {
        this.almacen_old = almacen_old;
    }

    public int getAlmacen_new() {
        return almacen_new;
    }

    public void setAlmacen_new(int almacen_new) {
        this.almacen_new = almacen_new;
    }
}
