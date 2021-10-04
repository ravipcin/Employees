package com.example.employees.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Employees {
    @SerializedName("Employees")
    private List<Employee> employeeList;

    public Employees() {}

    public Employees(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }
}
