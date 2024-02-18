package com.example.demo.repository;

import com.example.demo.model.Mascota;
import com.example.demo.model.MascotaRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MascotaRepository {

    @Autowired
    JdbcTemplate  jdbcTemplate;

    public void insert(Mascota mascota){
        jdbcTemplate.update("insert into mascota(nombre,num_chip,vacunado) values(?,?,?);",
                mascota.getNombre(),mascota.getNum_chip(),mascota.getVacunado());
    }

    public List<Mascota> findAll(){

        return jdbcTemplate.query("SELECT ALL * FROM mascota", new MascotaRowMapper());
    }

    public List<Mascota> searchByNombreOrApellido(String userInput){
        return jdbcTemplate.query("SELECT * FROM mascota where nombre = ?",new MascotaRowMapper(),
                userInput);
    }

    public void update(Mascota mascota){
        jdbcTemplate.update("UPDATE mascota SET nombre = ?, num_chip = ?, vacunado = ? WHERE id = ?",
                mascota.getNombre(), mascota.getNum_chip(), mascota.getVacunado(), mascota.getId());
    }

    public void delete(Integer id){
        jdbcTemplate.update("DELETE FROM mascota WHERE id=?", new Object[] { id });
    }

    public Mascota findById(long id){
        return jdbcTemplate.queryForObject("select * from mascota where id=?",
                new MascotaRowMapper(), new Object[] { id });
    }

}