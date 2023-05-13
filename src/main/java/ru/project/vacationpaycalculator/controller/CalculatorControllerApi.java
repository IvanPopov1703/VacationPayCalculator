package ru.project.vacationpaycalculator.controller;

import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.project.vacationpaycalculator.dto.ErrorMessageDto;
import ru.project.vacationpaycalculator.dto.ResponseDto;

@Api(description = "Калькулятор API")
@RequestMapping("/api/v1")
public interface CalculatorControllerApi {

    @ApiOperation(
            value = "Подсчет отпускных",
            notes = "Данный метод подсчитавыет сумму отпускных и возвращает ответ в виде JSON"
    )
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful execution", response = ResponseDto.class),
            @ApiResponse(code = 404, message = "Not Found", response = ErrorMessageDto.class),
            @ApiResponse(code = 500, message = "Server error")
    })
    @GetMapping(value = "/calculate",
            produces = {"application/json"})
    ResponseEntity<ResponseDto> calculate(
            @ApiParam(value = "Средняя ЗП за 12 месяцев") @RequestParam("averageSalary") Double averageSalary,
            @ApiParam(value = "Кол-во дней отпуска") @RequestParam("vacationDays") Integer vacationDays
    );
}
