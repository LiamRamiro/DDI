package com.example.demo.service;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import org.junit.jupiter.api.Test;

import com.example.demo.service.ExamenService;

public class ExamenServiceTest {

    private ExamenService examenService = new ExamenService();

    @Test
    public void testAgeChecker() {
        LocalDate fechaNacimiento = LocalDate.now().minusYears(30);
        Date fechaNacimientoDate = Date.from(fechaNacimiento.atStartOfDay(ZoneId.systemDefault()).toInstant());

        Date now = Date.from(Instant.now());
        long expectedAge = 30;

        long actualAge = examenService.ageChecker(fechaNacimientoDate, now);

        assertEquals(expectedAge, actualAge);
    }

    @Test
    public void testDivisionChecker() {
        int dividendo = 33;
        int divisor = 3;

        int expectedResult = 11;

        int actualResult = examenService.divisionChecker(dividendo, divisor);

        assertEquals(expectedResult, actualResult);
    }
}