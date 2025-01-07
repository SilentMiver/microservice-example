package com.example.gateway.rest.dto;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class EmployeeDto {
    private Long id;
    private String name;
    private String position;
    private int salary;
    private String hireDate;
}
