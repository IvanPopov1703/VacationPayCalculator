package ru.project.vacationpaycalculator.service.impl;

import org.springframework.stereotype.Service;
import ru.project.vacationpaycalculator.exception.ValidateDataException;
import ru.project.vacationpaycalculator.service.CalculatorService;

/**
 * Сервис для расчета отпускных сотрудника
 */
@Service
public class CalculatorServiceImpl implements CalculatorService {

    private final static String ERR_MESS_VALIDATE_PARAM_AVERAGE_SALARY = "Параметр средней зарплаты некорректный";
    private final static String ERR_MESS_VALIDATE_PARAM_VACATION_DAYS = "Параметр количества дней отпуска некорректный";

    /**
     * Метод для расчета отпускных
     * @param averageSalary средняя ЗП сотрудника за 12 месяцев
     * @param vacationDays количество дней отпуска
     * @return сумма отпускных
     */
    @Override
    public Double calculate(Double averageSalary, Integer vacationDays) {
        validateParameters(averageSalary, vacationDays);
        return Math.ceil(averageSalary * vacationDays);
    }

    /**
     * Метод для проверки корректности введенных параметров
     * @param averageSalary средняя ЗП сотрудника за 12 месяцев
     * @param vacationDays количество дней отпуска
     */
    private void validateParameters(Double averageSalary, Integer vacationDays) {
        if (averageSalary == null || averageSalary <= 0.0) {
            throw new ValidateDataException(ERR_MESS_VALIDATE_PARAM_AVERAGE_SALARY);
        }
        if (vacationDays == null || vacationDays <= 0) {
            throw new ValidateDataException(ERR_MESS_VALIDATE_PARAM_VACATION_DAYS);
        }
    }
}
