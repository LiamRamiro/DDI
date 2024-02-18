package com.example.pokemon.controller;

import org.springframework.web.bind.annotation.RequestMapping;

public class IndexController {

    @RequestMapping("/")
    public String inicio(){

        return "index";
    }
}
