package com.employee.employeedb.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class EmployeeDto {
    private Long id;
    private String firstname;
    private String lastname;
    private String email;
}
