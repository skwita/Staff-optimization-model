package com.skwita.staffoptimizationmodel.model.staff;

public class CustomEmployeePosition implements EmployeePosition {
    private String title;

    public CustomEmployeePosition(String title) {
        this.title = title;
    }

    @Override
    public String getTitle() {
        return title;
    }
}
