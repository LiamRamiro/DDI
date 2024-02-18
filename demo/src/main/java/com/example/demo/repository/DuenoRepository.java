package com.example.demo.repository;

import com.example.demo.model.Dueno;
import com.example.demo.model.DuenoRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DuenoRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public void insert(Dueno dueno){
        jdbcTemplate.update("insert into dueno(nombre, dni) values(?,?);", dueno.getNombre(), dueno.getDni());

    }

    public void update(Dueno dueno){
        jdbcTemplate.update("UPDATE dueno SET nombre = ?, dni = ? WHERE id=?", dueno.getNombre(),dueno.getDni(),dueno.getId());
    }

    public void delete(Integer id){
        jdbcTemplate.update("DELETE FROM DUENO WHERE id=?", new Object[] { id });

    }

    public List<Dueno> findAll(){
        return jdbcTemplate.query("SELECT * FROM DUENO", new DuenoRowMapper());

    }

    public Dueno findById(long id){
        return jdbcTemplate.queryForObject("select * from dueno where id=?",
                new BeanPropertyRowMapper<Dueno>(Dueno.class), new Object[] { id });
    }

    public List<Dueno> searchByNombreOrApellido(String userInput){
        return jdbcTemplate.query("SELECT * FROM DUENO WHERE nombre = ?", new DuenoRowMapper(),
            userInput);
    }
}
