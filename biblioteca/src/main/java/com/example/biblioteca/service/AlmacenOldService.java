package com.example.biblioteca.service;

import com.example.biblioteca.model.AlmacenOld;
import com.example.biblioteca.repository.AlmacenOldRepository;
import com.example.biblioteca.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlmacenOldService {

    @Autowired
    AlmacenOldRepository almacenOldRepository;

    @Autowired
    LibroRepository libroRepository;

    public List<AlmacenOld> insertAlmacenOld(AlmacenOld almacenOld) {
        System.out.println("id: " + almacenOld.getId() + " nombre: " + almacenOld.getNombre());
        //Si no tiene id, entonces es un registro nuevo
        if (almacenOld.getId() == null) {
            almacenOldRepository.insert(almacenOld.getNombre());
        } else {
            almacenOldRepository.update(almacenOld.getNombre(), almacenOld.getId());
        }
        List<AlmacenOld> lista = almacenOldRepository.findAll();
        for (AlmacenOld a : lista) {
            System.out.println("id: " + a.getId() + " nombre: " + a.getNombre());
        }

        return lista;
    }

    public AlmacenOld updateAlmacenOldList(Integer id) {
        AlmacenOld almacenOld = almacenOldRepository.findById(id);

        System.out.print(almacenOld.getNombre());
        return almacenOld;
    }

    public List<AlmacenOld> searchAlmacenOld(String userInput) {
        List<AlmacenOld> lista = almacenOldRepository.searchByNombre(userInput);
        for (AlmacenOld a : lista) {
            System.out.println("id: " + a.getId() + " nombre: " + a.getNombre());
        }
        return lista;
    }

    public AlmacenOld searchById(long id) {
        return almacenOldRepository.findById(id);
    }

    public List<AlmacenOld> listarTodosAlmacenOld() {
        List<AlmacenOld> lista = almacenOldRepository.findAll();
        for (AlmacenOld almacenOld : lista) {
            almacenOld.setLibros(libroRepository.findLibrosByAlmacenId(almacenOld.getId()));
        }
        return lista;
    }

    public List<AlmacenOld> deleteAlmacenOld(Integer id, String nombre) {
        almacenOldRepository.deleteByIdAndNombre(id, nombre);

        List<AlmacenOld> lista = almacenOldRepository.findAll();
        return lista;
    }

}