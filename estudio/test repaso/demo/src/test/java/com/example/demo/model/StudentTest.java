package com.example.demo.model;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class StudentTest {

    Student student;

    @Test
    void testGetApellidoWhenIsNotEmpty() {
        student = new Student(1, "Juan", "Compadre");
        assertEquals("Compadre", student.getApellido());

    }

    @Test
    void testGetIdWHenIsNotEmpty(){
        student = new Student(1,"Juan", "Perez");
        assertEquals(1, student.getId());
    }

    @Test
    void testGetIdWhenIsEmpty(){
        student = new Student(null,"Juan", "Perez");
        assertNull(student.getId());
    }

}

