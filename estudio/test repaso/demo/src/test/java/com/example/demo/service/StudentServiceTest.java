package com.example.demo.service;
import com.example.demo.model.Student;
import java.util.List;

import com.example.demo.repository.StudentRepository;
import org.junit.jupiter.api.*;
import org.mockito.Spy;

import static org.junit.jupiter.api.Assertions.*;

class StudentServiceTest {

    StudentService service;

    @Spy
    StudentRepository repository;


    @Test
    void testinsertStudent() {
        Student student = new Student();
        student.setNombre("Alex");
        student.setApellido("Esteban");
        student.setId(null);

        List<Student> listStudents = service.insertStudent(student);
        assertNotNull(listStudents);
        assertFalse(listStudents.isEmpty());

        verify(repository), times(1).insert(student);

    }

    @Test
    void updateStudentList() {
    }

    @Test
    void deleteStudent() {
    }

    @Test
    void searchStudent() {
    }

    @Test
    void searchStudentById() {
    }

    @BeforeEach
    void setUp() throws Exception{
        service = new StudentService();
        service.setStudentRepo(repository);
    }

    @AfterEach
    void tearDown() {
    }

    @BeforeAll
    static void setUpBeforeClass() throws Exception {
    }

    @AfterAll
    static void tearDownAfterClass() throws Exception {
    }
}

