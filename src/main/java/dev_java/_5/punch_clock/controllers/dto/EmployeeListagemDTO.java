package dev_java._5.punch_clock.controllers.dto;

import dev_java._5.punch_clock.entities.Employee;
import dev_java._5.punch_clock.entities.Role;

public record EmployeeListagemDTO(String name, String email, Role role ) {

    public EmployeeListagemDTO(Employee employee) {
        this(employee.getName(), employee.getEmail(), employee.getRole());
    }
}
