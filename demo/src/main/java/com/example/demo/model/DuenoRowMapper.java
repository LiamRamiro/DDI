package com.example.demo.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class DuenoRowMapper implements RowMapper<Dueno> {
	@Override
	
	public Dueno mapRow(ResultSet rs, int rowNum) throws SQLException{
		Dueno dueno = new Dueno();
		dueno.setId(rs.getInt("id"));
		dueno.setNombre(rs.getString("nombre"));
		dueno.setDni(rs.getString("dni"));
		return dueno;
	}

}

