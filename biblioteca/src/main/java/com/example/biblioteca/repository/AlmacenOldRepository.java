package com.example.biblioteca.repository;

import com.example.biblioteca.model.AlmacenNew;
import com.example.biblioteca.model.AlmacenOld;
import com.example.biblioteca.model.AlmacenOldRowMapper;
import com.example.biblioteca.model.Libro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AlmacenOldRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public void insert(String nombre){
        jdbcTemplate.update("INSERT INTO ALMACEN_OLD (nombre) VALUES (?);", nombre);
    }

    public void update(String nombre, Integer id){
        jdbcTemplate.update("UPDATE ALMACEN_OLD SET nombre = ? WHERE id = ?;", nombre, id);
    }

    public void delete(Integer id){
        jdbcTemplate.update("DELETE FROM ALMACEN_OLD WHERE id = ?", new Object[]{id}); ;
    }

    public void deleteAll(){
        jdbcTemplate.update("DELETE FROM ALMACEN_OLD");
    }

    public List<AlmacenOld> findAll()
    {
        return jdbcTemplate.query("SELECT * FROM ALMACEN_OLD", new AlmacenOldRowMapper());
    }

    public AlmacenOld findById(long id){
        return jdbcTemplate.queryForObject("SELECT * FROM ALMACEN_OLD WHERE id = ?",
                new AlmacenOldRowMapper(), new Object[] {id});
    }

    public List<AlmacenOld> searchByNombre(String userInput){
        return jdbcTemplate.query("SELECT * FROM ALMACEN_OLD WHERE nombre LIKE ?",
                new AlmacenOldRowMapper(),userInput);
    }

    public void deleteByIdAndNombre(Integer id, String nombre) {
        jdbcTemplate.update("DELETE FROM ALMACEN_OLD WHERE id = ? AND nombre = ?", id, nombre);
    }


}
