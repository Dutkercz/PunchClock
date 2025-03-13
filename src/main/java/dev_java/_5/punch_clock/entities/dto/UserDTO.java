package dev_java._5.punch_clock.entities.dto;

import dev_java._5.punch_clock.entities.Role;
import jakarta.validation.constraints.*;

public record UserDTO(@NotBlank String name,
                      @NotBlank @Email String email,
                      @NotBlank @Size(min = 6, max = 100) String password,
                      @Pattern(regexp = "\\d{11}") String cpf,
                      @NotNull Role role) {

}
