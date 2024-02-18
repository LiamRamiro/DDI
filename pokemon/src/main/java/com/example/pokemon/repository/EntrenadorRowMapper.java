package com.example.pokemon.repository;

import com.example.pokemon.model.Entrenador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class EntrenadorRowMapper implements RowMapper<Entrenador> {

    @Override
    public Entrenador mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Entrenador entrenador = new Entrenador(resultSet.getInt("id"), resultSet.getString("nombre"), resultSet.getBoolean("active"));
        return entrenador;
    }
}
