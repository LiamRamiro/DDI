package com.example.biblioteca.model;


import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LibroRowMapper implements RowMapper<Libro> {
    @Override

    public Libro mapRow(ResultSet rs, int rowNum) throws SQLException {
        Libro libro = new Libro();
        libro.setId(rs.getInt("id"));
        libro.setIsbn(rs.getString("isbn"));
        libro.setAno(rs.getInt("ano"));
        libro.setAlmacen_old(rs.getInt("almacen_old"));
        libro.setAlmacen_new(rs.getInt("almacen_new"));
        return libro;
    }
}
