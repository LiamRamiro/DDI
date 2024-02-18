package com.example.biblioteca.service;

import com.example.biblioteca.model.Libro;
import com.example.biblioteca.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibroService {

    @Autowired
    LibroRepository libroRepository;

    public List<Libro> insertLibro(Libro libro){
        System.out.println("isbn: " + libro.getIsbn()+ " fechaEdicion: " + libro.getAno() + " almacen_old: " + libro.getAlmacen_old() + " almacen_new: " + libro.getAlmacen_new());
        if(libro.getId() == null){
            libroRepository.insert(libro);
        }else{
            libroRepository.update(libro);
        }
        List<Libro> lista = libroRepository.findAll();
        for(Libro l : lista){
            System.out.println("id: " + l.getId() + " isbn: " + l.getIsbn()+ " fechaEdicion: " + l.getAno() + " almacen_old: " + l.getAlmacen_old() + " almacen_new: " + l.getAlmacen_new());
        }
        return lista;
    }

    public Libro updateLibroList(Integer id){
        Libro lib = libroRepository.findById(id);

        System.out.print(lib.getIsbn()+", "+lib.getAno()+", "+lib.getAlmacen_old()+", "+lib.getAlmacen_new());
        return lib;
    }

    public List<Libro> deleteLibro(Integer id){
        libroRepository.delete(id);

        List<Libro> lista = libroRepository.findAll();
        return  lista;

    }

    public List<Libro> searchLibro(String userInput){
        List<Libro> lista = libroRepository.searchByIsbn(userInput);
        for(Libro l : lista){
            System.out.println("id: " + l.getId() + " isbn: " + l.getIsbn()+ " fechaEdicion: " + l.getAno() + " almacen_old: " + l.getAlmacen_old() + " almacen_new: " + l.getAlmacen_new());
        }
        return lista;
    }

    public Libro searchById(long id) {
        return libroRepository.findById(id);
    }
}
