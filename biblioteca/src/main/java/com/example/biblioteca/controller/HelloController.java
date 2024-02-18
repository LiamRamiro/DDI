package com.example.biblioteca.controller;

import com.example.biblioteca.model.Libro;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

    @RequestMapping("/")
    public String index(Model model){
        model.addAttribute("libro",new Libro());
        return "index";
    }
}
