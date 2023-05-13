package ru.project.vacationpaycalculator.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
public class ResponseDto {
    private Double vacationPayAmount;
}
