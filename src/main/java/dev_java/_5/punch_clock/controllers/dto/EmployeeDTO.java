package dev_java._5.punch_clock.controllers.dto;

import dev_java._5.punch_clock.entities.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record EmployeeDTO(@NotBlank String name,
                          @NotBlank @Email String email,
                          @NotBlank @Pattern(regexp = "\\d{6,100}") String password,
                          @NotNull Role role) {

}
