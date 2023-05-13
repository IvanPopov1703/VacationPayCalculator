package ru.project.vacationpaycalculator.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import ru.project.vacationpaycalculator.dto.ResponseDto;
import ru.project.vacationpaycalculator.service.CalculatorService;

@RestController
public class CalculatorController implements CalculatorControllerApi {

    private final CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @Override
    public ResponseEntity<ResponseDto> calculate(Double averageSalary, Integer vacationDays) {
        ResponseDto calculationResult = new ResponseDto(calculatorService.calculate(averageSalary, vacationDays));
        return ResponseEntity.ok(calculationResult);
    }
}
