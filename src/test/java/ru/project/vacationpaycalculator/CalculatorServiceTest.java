package ru.project.vacationpaycalculator;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.project.vacationpaycalculator.exception.ValidateDataException;
import ru.project.vacationpaycalculator.service.CalculatorService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class CalculatorServiceTest {

    @Autowired
    private CalculatorService calculatorService;

    @Test
    public void correctnessOfCalculation() {
        assertEquals(17331.0, calculatorService.calculate(2475.8, 7));
    }

    @Test
    public void incorrectParameter() {
        assertThrows(ValidateDataException.class, () -> calculatorService.calculate(20., 0));
    }
}
