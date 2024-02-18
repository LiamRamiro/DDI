package com.example.pokemon.repository;

import com.example.pokemon.model.Entrenador;
import com.example.pokemon.model.Pokemon;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PokemonRowMapper implements RowMapper<Pokemon> {

    @Override
    public Pokemon mapRow(ResultSet rs, int rowNum) throws SQLException {
        Entrenador entrenador = new Entrenador();
        entrenador.setId(rs.getInt("idE"));
        entrenador.setNombre(rs.getString("nomD"));
        entrenador.setActive(rs.getBoolean("active"));


        Pokemon pokemon = new Pokemon();
        pokemon.setEntrenador(entrenador);
        pokemon.setId(rs.getInt("idP"));
        pokemon.setNombre(rs.getString("nombreP"));






        return pokemon;
    }
}
