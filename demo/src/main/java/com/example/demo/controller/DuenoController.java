package com.example.demo.controller;

import com.example.demo.model.Dueno;
import com.example.demo.service.DuenoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class DuenoController {

    @Autowired
    DuenoService service;

    //localhost:8080/insertDueno
    @RequestMapping("/insertDueno")
    public String insertarDueno(Dueno dueno, Model model){
        List<Dueno> lista = service.insertDueno(dueno);

        model.addAttribute("duenos",lista);
        return "fin";
    }

    @RequestMapping("/updateDueno/{id}")
    public String actualizarDueno(@PathVariable Integer id, Model model){
        Dueno dun = service.updateDuenoList(id);

        model.addAttribute("dueno",dun);

        return "index";
    }

    @RequestMapping("/deleteDueno/{id}")
    public String borrarDueno(@PathVariable Integer id, Model model){
        List<Dueno> lista = service.deleteStudent(id);

        model.addAttribute("duenos", lista);
        return "fin";
    }

    @RequestMapping("/searchDueno")
    public String buscarDueno(@RequestParam("search") String userInput,Model model){
        List<Dueno> lista = service.searchDueno(userInput);

        model.addAttribute("duenos",lista);
        return "fin";
    }

    public Dueno findById(long id){
        Dueno dun = service.searchDuenoById(id);
        return dun;
    }

}
