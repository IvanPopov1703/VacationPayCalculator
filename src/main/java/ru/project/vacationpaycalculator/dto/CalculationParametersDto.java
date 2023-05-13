package ru.project.vacationpaycalculator.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
public class CalculationParametersDto {

    private Double averageSalary;
    private Integer vacationDays;
}
