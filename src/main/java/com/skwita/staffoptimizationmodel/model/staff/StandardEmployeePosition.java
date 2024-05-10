package com.skwita.staffoptimizationmodel.model.staff;

public enum StandardEmployeePosition implements EmployeePosition{
    DEVELOPER("Developer"),
    DESIGNER("Designer"),
    ANALYST("Analyst"),
    TESTER("Tester");

    private String title;

    StandardEmployeePosition(String title) {
        this.title = title;
    }

    @Override
    public String getTitle() {
        return title;
    }
}
