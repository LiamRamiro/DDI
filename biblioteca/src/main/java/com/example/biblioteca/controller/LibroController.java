package com.example.biblioteca.controller;

import com.example.biblioteca.model.Libro;
import com.example.biblioteca.service.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class LibroController {

    @Autowired
    LibroService service;

    @RequestMapping("/insertLibro")
    public String insertarLibro(@ModelAttribute("libro") Libro libro, BindingResult result, Model model){
        List<Libro> lista = service.insertLibro(libro);

        model.addAttribute("libros", lista);
        return "finlibro";
    }

    @RequestMapping("/updateLibro/{id}")
    public String actualizarLibro(@PathVariable Integer id, Model model){
        Libro lib = service.updateLibroList(id);

        model.addAttribute("libro", lib);
        return "index";
    }


    @RequestMapping("/deleteLibro/{id}")
    public String borrarLibro(@PathVariable Integer id, Model model){
        List<Libro> lista = service.deleteLibro(id);

        model.addAttribute("libros", lista);
        return "finlibro";
    }

    @RequestMapping("/searchLibro")
    public String buscarLibro(@RequestParam("search") String userInput, Model model){
        List<Libro> lista = service.searchLibro(userInput);

        model.addAttribute("libros", lista);
        return "finlibro";
    }

    public Libro findById(long id) {
        Libro lib = service.searchById(id);
        return lib;
    }
}
