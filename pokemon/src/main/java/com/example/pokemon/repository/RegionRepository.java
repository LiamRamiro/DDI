package com.example.pokemon.repository;

import com.example.pokemon.model.Region;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class RegionRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Region> getTodosRegion(){
        String query = "SELECT * FROM region;";
        List<Region> listaRegion = jdbcTemplate.query(query, new RegionRowMapper());
        return listaRegion;
    }

    public Region getRegionPorId(int id){
        String query = "SELECT * FROM region r WHERE r.id = ?";
        List<Region> listaRegion = jdbcTemplate.query(query, new RegionRowMapper(), id);
        return (listaRegion.isEmpty())? null: listaRegion.get(0);
    }

    public void eliminarRegion(Region region){
        String query = "DELETE FROM region r WHERE r.id = ?";
        jdbcTemplate.update(query, region.getId());
    }

    public void actualizarRegion(Region region){
        String query = "UPDATE region SET nombre = ? WHERE id = ?";
        jdbcTemplate.update(query, region.getNombre(), region.getId());
    }

    public void crearRegion(Region region){
        String query = "INSERT INTO region (id, nombre) VALUES (?, ?)";
        jdbcTemplate.update(query, region.getId(), region.getNombre());
    }


}
