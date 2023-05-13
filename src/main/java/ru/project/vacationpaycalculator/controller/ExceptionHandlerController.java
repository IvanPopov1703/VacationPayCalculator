package ru.project.vacationpaycalculator.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.project.vacationpaycalculator.dto.ErrorMessageDto;
import ru.project.vacationpaycalculator.exception.ValidateDataException;

@RestControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler(value = {ValidateDataException.class})
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ErrorMessageDto resourceNotFoundException(ValidateDataException ex) {
        return new ErrorMessageDto(ex.getMessage());
    }

    @ExceptionHandler(value = {Exception.class})
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public ErrorMessageDto resourceNotFoundException(Exception ex) {
        return new ErrorMessageDto(ex.getMessage());
    }
}
