package dev_java._5.punch_clock.controllers.dto;

import dev_java._5.punch_clock.entities.Role;
import jakarta.validation.constraints.*;

public record EmployeeDTO(@NotBlank String name,
                          @NotBlank @Email String email,
                          @NotBlank @Size(min = 6, max = 100) String password,
                          @NotNull Role role) {

}
