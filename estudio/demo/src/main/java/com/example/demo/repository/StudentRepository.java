package com.example.demo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Student;

@Repository
public interface StudentRepository extends CrudRepository<Student, Integer> {

	public List<Student> findByNombreOrApellido(String nombre, String apellido);

}

/*public class StudentRepository {

	@Autowired
	JdbcTemplate jdbcTemplate;

	public void insert(Student student) {
		jdbcTemplate.update("insert into students(id, nombre, apellido) values(?, ?, ?);", student.getId(),student.getNombre(),
				student.getApellido());
	}

	public void update(Student student) {
		jdbcTemplate.update("UPDATE students SET nombre = ?, apellido = ? WHERE id=?;", student.getNombre(),
				student.getApellido(), student.getId());
	}

	public void delete(Integer id) {
		jdbcTemplate.update("DELETE FROM STUDENTS WHERE id=?", new Object[] { id });
	}

	public List<Student> findAll() {
		return jdbcTemplate.query("SELECT * FROM STUDENTS", new StudentRowMapper());
	}

	public Student findById(long id) {
		return jdbcTemplate.queryForObject("select * from STUDENTS where id=?",
				new BeanPropertyRowMapper<Student>(Student.class), new Object[] { id });
	}

	public List<Student> searchByNombreOrApellido(String userInput) {
		return jdbcTemplate.query("SELECT * FROM STUDENTS WHERE nombre = ? OR apellido = ?", new StudentRowMapper(),
				userInput, userInput);
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
}*/
