package com.example.pokemon.controller;

import com.example.pokemon.model.Entrenador;
import com.example.pokemon.model.Pokemon;
import com.example.pokemon.repository.PokemonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;

@Controller
public class PokemonController {

    @Autowired
    private PokemonRepository pokemonRepository;

    @Autowired
    private EntrenadorController entrenadorController;

    @RequestMapping("/listaPokemons")
    public String listaPokemons(Model model){
        List<Pokemon> listaPokemons = pokemonRepository.getTodosPokemons();
        model.addAttribute("listaPokemons", listaPokemons);
        return "listaPokemons";
    }

    @RequestMapping("/formPokemon")
    public String formInsertarPokemon(Model model){
        Pokemon pokemon = new Pokemon();
        model.addAttribute("nuevoPokemon", pokemon);
        model.addAttribute("listaPokemons", entrenadorController.getTodosEntrenadores());
        return "formPokemon";
    }

    @RequestMapping("/insertarPokemon")
    public String insertarPokemon(Pokemon pokemon, @RequestParam String idEntrenador, Model model){
        Entrenador entrenador = entrenadorController.getEntrenadorPorId(Integer.parseInt(idEntrenador));
        pokemon.setEntrenador(entrenador);
        pokemonRepository.insertarPokemon(pokemon);
        return listaPokemons(model);
    }

    @RequestMapping("/formModificarPokemon/{idPokemon}")
    public String formModificarPokemon(Model model, @PathVariable String idPokemon){
        Pokemon pokemon = pokemonRepository.getPokemonPorId(Integer.parseInt(idPokemon));
        model.addAttribute("pokemon", pokemon);
        model.addAttribute("listaPokemon", entrenadorController.getTodosEntrenadores());
        return "formModificarMascota";
    }

    @RequestMapping("/actualizarPokemon")
    public String actualizarPokemon(Pokemon pokemon, @RequestParam String idEntrenador, Model model){
        Entrenador entrenador = entrenadorController.getEntrenadorPorId(Integer.parseInt(idEntrenador));
        pokemon.setEntrenador(entrenador);
        pokemonRepository.actualizarPokemon(pokemon);
        return listaPokemons(model);
    }

    @RequestMapping("/eliminarPokemon/{idPokemon}")
    public String eliminarPokemon(@PathVariable String idPokemon, Model model){
        Pokemon pokemon = pokemonRepository.getPokemonPorId(Integer.parseInt(idPokemon));
        pokemonRepository.eliminarPokemon(pokemon);
        return listaPokemons(model);
    }

}
