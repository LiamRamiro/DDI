package com.example.biblioteca.model;


import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;


public class AlmacenNewRowMapper implements RowMapper<AlmacenNew> {
    @Override
    public AlmacenNew mapRow(ResultSet rs, int rowNum) throws SQLException {

        AlmacenNew almacenNew = new AlmacenNew();
        almacenNew.setId(rs.getInt("id"));
        almacenNew.setNombre(rs.getString("nombre"));
        return almacenNew;
    }
}