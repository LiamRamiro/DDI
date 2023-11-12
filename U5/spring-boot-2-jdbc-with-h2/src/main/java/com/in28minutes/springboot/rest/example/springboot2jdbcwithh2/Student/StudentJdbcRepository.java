package com.in28minutes.springboot.rest.example.springboot2jdbcwithh2.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentJdbcRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public void deleteById(long l) {
    }



    static class StudentRowMapper implements RowMapper<Student> {
        @Override
        public Student mapRow(java.sql.ResultSet rs, int rowNum) throws java.sql.SQLException {
            Student student = new Student();
            student.setId(rs.getLong("id"));
            student.setName(rs.getString("name"));
            student.setPassportNumber(rs.getString("passport_number"));
            return student;
        }
    }

    public List< Student > findAll() {
        return jdbcTemplate.query("select * from student", new StudentRowMapper());
    }

    public Student findById(Long id) {
        return jdbcTemplate.queryForObject("select * from student where id=?", new Object[]{id}, new BeanPropertyRowMapper<Student>(Student.class));
    }
}
