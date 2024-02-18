package com.example.demo.controller;

import com.example.demo.model.Mascota;
import com.example.demo.service.MascotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@Controller
public class MascotaController {

    @Autowired
    MascotaService service;

    @RequestMapping("/insertMascota")
    public String insertarMascota(Mascota mascota, Model model) {
        List<Mascota> lista = service.insertMascota(mascota);

        model.addAttribute("mascotas", lista);
        return "finmascota";
    }

    @RequestMapping("/updateMascota/{id}")
    public String actualizarMascota(@PathVariable Integer id, Model model) {
        Mascota mas = service.updateMascotaList(id);


        model.addAttribute("mascotas", mas);

        return "index";
    }

    @RequestMapping("/deleteMascota/{id}")
    public String borrarMascota(@PathVariable Integer id, Model model) {
        List<Mascota> lista = service.deleteMascota(id);

        model.addAttribute("mascotas", lista);
        return "finmascota";
    }

    @RequestMapping("/searchMascota")
    public String buscarMascota(@RequestParam("search") String userInput, Model model) {
        List<Mascota> lista = service.searchMascota(userInput);

        model.addAttribute("mascotas", lista);
        return "finmascota";
    }

    public Mascota findById(long id) {
        Mascota mas = service.searchMascotaById(id);
        return mas;
    }
}

