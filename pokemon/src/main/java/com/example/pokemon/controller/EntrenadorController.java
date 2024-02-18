package com.example.pokemon.controller;

import com.example.pokemon.model.Entrenador;
import com.example.pokemon.repository.EntrenadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class EntrenadorController {

    @Autowired
    private EntrenadorRepository entrenadorRepository;

    @RequestMapping("/listaEntrenadores")
    public String listadoEntrenadores(Model model){
        List<Entrenador> listaEntrenadores = entrenadorRepository.getTodosEntrenadores();
        model.addAttribute("listaEntrenadores", listaEntrenadores);
        return "listaEntrenadores";
    }

    @RequestMapping("/formModificarEntrenador/{id}")
    public String formModificadoEntrenador(@PathVariable Integer id , Model model){
        Entrenador entrenador = entrenadorRepository.getEntrenadorPorId(id);
        if (entrenador != null) {
            model.addAttribute("entrenador", entrenador);
            return "formModificarEntrenador";
        }
        else{
            return "paginaError";
        }
    }

    @RequestMapping("/formInsertarEntrenador")
    public String formInsertadoEntrenador(Model model){
        Entrenador entrenador = new Entrenador();
        model.addAttribute("entrenador", entrenador);
        return "formEntrenador";
    }

    @RequestMapping("/insertarEntrenador")
    public String insertarNuevoEntrenador(Entrenador entrenador, Model model){
        System.out.println(entrenador.getId() + ", " + entrenador.getNombre());
        entrenadorRepository.crearEntrenador(entrenador);
        return listadoEntrenadores(model);
    }

    @RequestMapping("/actualizarEntrenador")
    public String actualizarEntrenador(Entrenador entrenador, Model model){
        System.out.println(entrenador.getId() + ", " + entrenador.getNombre());
        entrenadorRepository.actualizarEntrenador(entrenador);
        return listadoEntrenadores(model);
    }

    @RequestMapping("/avisoEliminarEntrenador/{dni}")
    public String avisoEliminarEntrenador(@PathVariable Integer id, Model model){
        Entrenador entrenador= entrenadorRepository.getEntrenadorPorId(id);
        if (entrenador != null) {
            model.addAttribute("entrenador", entrenador);
            return "avisoEliminarEntrenador";
        }
        else{
            return "paginaError";
        }
    }

    @RequestMapping("/eliminarEntrenador/{id}")
    public String eliminarEntrenador(@PathVariable Integer id, Model model){
        Entrenador entrenador = entrenadorRepository.getEntrenadorPorId(id);
        if (entrenador != null) {
            entrenadorRepository.eliminarEntrenador(entrenador);
            return listadoEntrenadores(model);
        }
        else{
            return "paginaError";
        }
    }

    public List<Entrenador> getTodosEntrenadores(){
        return entrenadorRepository.getTodosEntrenadores();
    }

    public Entrenador getEntrenadorPorId(Integer id){
        return entrenadorRepository.getEntrenadorPorId(id);
    }

}
