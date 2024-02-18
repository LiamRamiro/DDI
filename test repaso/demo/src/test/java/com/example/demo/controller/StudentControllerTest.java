package com.example.demo.controller;

import com.example.demo.model.Student;
import com.example.demo.service.StudentService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class StudentControllerTest {

    StudentController controller;
    @Mock
    private StudentService service;
    @Test
    void testInsertarEstudiate(){
        //given
        Model model = new ExtendedModelMap();
        List<Student> listaPrecreada = createMockedList();
        when(service.insertStudent(new Student())).thenReturn(listaPrecreada);
        //when
        String finPage = controller.insertarEstudiante(new Student(), model);
        //then
        assertEquals("fin", finPage);

        assertNotNull(model.getAttribute("estudiantes"));
        assertInstanceOf(List.class, model.getAttribute("estudiantes"));

        List<Student> lista = (List<Student>) model.getAttribute("estudiantes");
        assertFalse(lista.isEmpty());

    }

    private static List<Student> createMockedList() {
        List<Student> listaPrecreada = new ArrayList<Student>();
        listaPrecreada.add(new Student(1, "George", "ThelaJungle"));
        listaPrecreada.add(new Student(2, "Joan", "Gamper"));
        return listaPrecreada;
    }

    @Test
    void testActualizarEstudiante() {
        // Arrange
        Model model = new ExtendedModelMap();
        Student student = getStudent();
        when(service.updateStudentList(student.getId())).thenReturn(student);

        // Act
        String indexPage = controller.actualizarEstudiante(student.getId(), model);
        assertEquals("index", indexPage);

        // Assert
        assertNotNull(model.getAttribute("student"));
        assertInstanceOf(Student.class, model.getAttribute("student"));

        Student stud = (Student) model.getAttribute("student");
        assertNotNull(stud);
        System.out.println(model.getAttribute("student"));
    }

    private static Student getStudent() {
        return new Student(1, "George", "ThelaJungle");
    }

    @Test
    void testBorrarEstudiante() {
        // Arrange
        Model model = new ExtendedModelMap();
        Student student = getStudent();
        List<Student> listaPrecreada = createMockedList();
        when(service.deleteStudent(student.getId())).thenReturn(listaPrecreada);

        // Act
        String finPage = controller.borrarEstudiante(student.getId(), model);
        assertEquals("fin", finPage);

        // Assert
        assertNotNull(model.getAttribute("estudiantes"));
        assertInstanceOf(List.class, model.getAttribute("estudiantes"));

        List<Student> lista = (List<Student>) model.getAttribute("estudiantes");
        assertFalse(lista.isEmpty());
    }

    @BeforeAll
    static void setUpBeforeClass() throws Exception {
    }

    @AfterAll
    static void tearDownAfterClass() throws Exception {
    }

    @BeforeEach
    void setUp() {
        controller = new StudentController();
        controller.setService(service);
    }

    @AfterEach
    void tearDown() {
    }
}