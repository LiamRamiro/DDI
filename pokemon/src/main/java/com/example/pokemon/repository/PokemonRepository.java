package com.example.pokemon.repository;

import com.example.pokemon.model.Entrenador;
import com.example.pokemon.model.Pokemon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class PokemonRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Pokemon> getTodosPokemons(){
        List<Pokemon> listaPokemons = jdbcTemplate.query(
                "SELECT * FROM POKEMON",
                new PokemonRowMapper());
        return listaPokemons;
    }

    public Pokemon getPokemonPorId(int idPokemon){
        String query =  "SELECT * FROM POKEMON WHERE id = ?";
        List<Pokemon> listaPokemons = jdbcTemplate.query(query, new PokemonRowMapper(), idPokemon);
        return (listaPokemons.isEmpty())? null: listaPokemons.get(0);
    }


    public void eliminarPokemon(Pokemon pokemon){
        String query = "DELETE FROM POKEMON WHERE id = ?;";
        jdbcTemplate.update(query, pokemon.getId());
    }

    public void actualizarPokemon(Pokemon pokemon){
        String query = "UPDATE POKEMON SET nombre = ?, region = ? WHERE id = ?;";
        jdbcTemplate.update(query,
                pokemon.getId(), pokemon.getNombre(), pokemon.getEntrenador(), pokemon.getRegion());
    }

    public void insertarPokemon(Pokemon pokemon){
        String query = "INSERT INTO POKEMON ( nombre, region) VALUES ( ?, ?);";
        jdbcTemplate.update(query, pokemon.getId(), pokemon.getNombre(), pokemon.getEntrenador(), pokemon.getRegion());
    }

    public List<Pokemon> findPokemonsByRegion(Integer regionId){
        String query = "SELECT * FROM POKEMON WHERE region = ?";
        return jdbcTemplate.query(query, new PokemonRowMapper(), regionId);
    }


}
