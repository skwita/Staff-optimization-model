package com.skwita.staffoptimizationmodel.model.staff;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode
@AllArgsConstructor
public class Employee {
    private EmployeePosition employeePosition;
    private Qualification qualification;
}

