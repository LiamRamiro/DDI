package com.example.demo.controller;

import com.example.demo.model.Dueno;
import com.example.demo.model.Mascota;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class HelloController {



    @RequestMapping("/")
    public String index(Model model){
        //necesario para que el formulario fucione
        model.addAttribute("dueno",new Dueno());
        model.addAttribute("mascota", new Mascota());
        // devuelve la pagina de index.html
        return "index";
    }
}
