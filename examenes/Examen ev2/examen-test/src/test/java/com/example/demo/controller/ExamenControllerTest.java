package com.example.demo.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.example.demo.service.ExamenService;
import org.junit.jupiter.api.*;
import org.mockito.Mock;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.example.demo.model.Examen;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ExamenControllerTest {

    @Mock
    private ExamenService examenService;

    private ExamenController controller;


    @Test
    void testNavigateAgeChecker(){
        Model model = new ExtendedModelMap();
        String route = "ageChecker";
        String navigate = controller.navigate(route, model);
        assertEquals("ageChecker", navigate);

        assertNotNull(model.getAttribute("examen"));
        assertInstanceOf(Examen.class, model.getAttribute("examen"));

    }

    @Test
    void testNavigateDivisionChecker(){
        Model model = new ExtendedModelMap();
        String route = "divisionChecker";
        String navigate = controller.navigate(route, model);
        assertEquals("divisionChecker", navigate);

        assertNotNull(model.getAttribute("examen"));
        assertInstanceOf(Examen.class, model.getAttribute("examen"));

    }

    @Test
    public void testAgeNotBorn() {
        Model model = new ExtendedModelMap();
        Date fechaNacimiento = new Date(2024, 2, 13);
        when(examenService.ageChecker(any(Date.class), any(Date.class))).thenReturn(0L);
        ExamenController examenController = new ExamenController();
        String viewName = examenController.age(new Examen(null, null, null, fechaNacimiento), model);
        assertNotNull(fechaNacimiento);
        assertEquals("underAge", viewName);
    }


    @Test
    public void testAgeUnder18() {
        Model model = new ExtendedModelMap();
        Date fechaNacimiento = new Date(2007, 1, 1);
        when(examenService.ageChecker(any(Date.class), any(Date.class))).thenReturn(17L);
        ExamenController examenController = new ExamenController();
        String viewName = examenController.age(new Examen(null, null, null, fechaNacimiento), model);
        assertNotNull(fechaNacimiento);
        assertEquals("underAge", viewName);
    }

    @Test
    public void testAgeBetween18And67() {
        Model model = new ExtendedModelMap();
        Date fechaNacimiento = new Date(1994, 1, 1);
        when(examenService.ageChecker(any(Date.class), any(Date.class))).thenReturn(30L);

        ExamenController examenController = new ExamenController();
        String viewName = examenController.age(new Examen(null, null, null, fechaNacimiento), model);
        assertNotNull(fechaNacimiento);
        assertEquals("getAJobNow", viewName);
    }

    @Test
    public void testAgeOver67() {
        Model model = new ExtendedModelMap();
        Date fechaNacimiento = new Date(1957, 1, 1);
        when(examenService.ageChecker(any(Date.class), any(Date.class))).thenReturn(67L);
        ExamenController examenController = new ExamenController();
        String viewName = examenController.age(new Examen(null, null, null, fechaNacimiento), model);
        assertNotNull(fechaNacimiento);
        assertEquals("retired", viewName);
    }


    @BeforeEach
    void setUp() throws Exception {
        controller = new ExamenController();
        controller.setService(examenService);
    }

    @AfterEach
    void tearDown() throws Exception{
    }

    @BeforeAll
    static void setUpBeforeClass() throws Exception{
    }

    @AfterAll
    static void tearDownAfterClass() throws Exception{
    }


}
