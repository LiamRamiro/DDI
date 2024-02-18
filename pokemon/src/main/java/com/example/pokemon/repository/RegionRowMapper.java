package com.example.pokemon.repository;

import com.example.pokemon.model.Region;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class RegionRowMapper implements RowMapper<Region> {

    @Override
    public Region mapRow(java.sql.ResultSet resultSet, int rowNum) throws java.sql.SQLException {
        Region region = new Region(resultSet.getInt("id"), resultSet.getString("nombre"));
        return region;
    }



}
