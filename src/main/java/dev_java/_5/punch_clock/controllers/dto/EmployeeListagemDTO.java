package dev_java._5.punch_clock.controllers.dto;

import dev_java._5.punch_clock.entities.Role;

public record EmployeeListagemDTO(String name, String email, Role role ) {

    public EmployeeListagemDTO(EmployeeDTO dados) {
        this(dados.name(), dados.email(), dados.role());
    }
}
