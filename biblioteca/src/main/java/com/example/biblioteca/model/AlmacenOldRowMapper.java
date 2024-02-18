package com.example.biblioteca.model;


import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class AlmacenOldRowMapper implements RowMapper<AlmacenOld> {
    @Override
    public AlmacenOld mapRow(ResultSet rs, int rowNum) throws SQLException {

        AlmacenOld almacenOld = new AlmacenOld();
        almacenOld.setId(rs.getInt("id"));
        almacenOld.setNombre(rs.getString("nombre"));
        return almacenOld;
    }
}