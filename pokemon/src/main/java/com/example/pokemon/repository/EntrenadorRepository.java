package com.example.pokemon.repository;

import com.example.pokemon.model.Entrenador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class EntrenadorRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;


    public List<Entrenador> getTodosEntrenadores(){
        String query = "SELECT * FROM entrenador;";
        List<Entrenador> listaEntrenador = jdbcTemplate.query(query, new EntrenadorRowMapper());
        return listaEntrenador;
    }

    public Entrenador getEntrenadorPorId(Integer id){
        String query = "SELECT * FROM entrenador e WHERE e.id = ?";
        List<Entrenador> listaEntrenador = jdbcTemplate.query(query, new EntrenadorRowMapper(), id);
        return (listaEntrenador.isEmpty())? null: listaEntrenador.get(0);
    }

    public void eliminarEntrenador(Entrenador entrenador){
        String query = "DELETE FROM entrenador e WHERE e.id = ?";
        jdbcTemplate.update(query, entrenador.getId());
    }

    public void actualizarEntrenador(Entrenador entrenador){
        String query = "UPDATE entrenador SET nombre = ? WHERE id = ?";
        jdbcTemplate.update(query, entrenador.getNombre(), entrenador.getId());
    }

    public void crearEntrenador(Entrenador entrenador){
        String query = "INSERT INTO entrenador (id, nombre) VALUES (?, ?)";
        jdbcTemplate.update(query, entrenador.getId(), entrenador.getNombre());
    }
}
