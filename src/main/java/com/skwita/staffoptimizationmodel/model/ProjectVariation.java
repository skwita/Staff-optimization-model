package com.skwita.staffoptimizationmodel.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.skwita.staffoptimizationmodel.model.staff.Employee;
import com.skwita.staffoptimizationmodel.model.staff.EmployeePosition;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode
public class ProjectVariation  implements Comparable<ProjectVariation>{
    private Map<Employee, Integer> staff;
    private double time;
    private double price = 0;
    private Map<EmployeePosition, Integer> staffRequiredHours;

    public ProjectVariation(Map<Employee, Integer> staff, double time, Map<EmployeePosition, Integer> staffReqHours, Map<Employee, Integer> staffPrices) {
        this.staff = staff;
        this.time = time;
        this.price = this.calcualtePrice(staffPrices);
        this.staffRequiredHours = staffReqHours;
    }

    //Change to actual function
    private double calcualtePrice(Map<Employee, Integer> staffPrices) {
        double resultPrice = 0;
        for (Entry<Employee, Integer> employee: staff.entrySet()) {
            resultPrice += staffPrices.get(employee.getKey()) * employee.getValue();
        }
        return resultPrice  / (time * 100_000);
    }

    public boolean isEnoughEmployees(Map<Employee, Integer> staffProductivityHours) {
        Map<EmployeePosition, Integer> staffAvailableHours = new HashMap<>();

        for (Entry<Employee, Integer> employeeType: staff.entrySet()) {
            if (staffAvailableHours.containsKey(employeeType.getKey().getEmployeePosition())) {
                staffAvailableHours.put(
                    employeeType.getKey().getEmployeePosition(),
                    staffAvailableHours.get(employeeType.getKey().getEmployeePosition()) + staffProductivityHours.get(employeeType.getKey())
                );
            } else {
                staffAvailableHours.put(
                    employeeType.getKey().getEmployeePosition(),
                    staffProductivityHours.get(employeeType.getKey())
                );
            }
        }

        for (Entry<EmployeePosition, Integer> entry: staffAvailableHours.entrySet()) {
            if (entry.getValue() < this.staffRequiredHours.get(entry.getKey())) 
                return false;    
        }

        return true;
    }

    @Override
    public int compareTo(ProjectVariation o) {
        return Double.compare(this.time, o.time);
    }
}
