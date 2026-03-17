package com.amb.amb;

import java.util.UUID;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Min;

public class Staff {
    private String id;
    @NotBlank(message = "Name is required")
    private String name;
    @NotBlank(message = "Title is required")
    private String title;
    @NotNull(message = "Salary is required")
    @Min(value = 1, message = "Salary must be greater than 0")
    private Double salary;

    public Staff() {
        this.id = UUID.randomUUID().toString();
    }

    public Staff(String name, String title, Double salary) {
        this.name = name;
        this.title = title;
        this.salary = salary;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }
}
