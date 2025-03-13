package dev_java._5.punch_clock.entities.dto_user;

import dev_java._5.punch_clock.entities.PunchClock;
import dev_java._5.punch_clock.entities.enums.Role;
import jakarta.validation.constraints.*;

import java.util.List;

public record UserDTO(@NotBlank String name,
                      @NotBlank @Email String email,
                      @NotBlank @Size(min = 6, max = 100) String password,
                      @Pattern(regexp = "\\d{11}") String cpf,
                      @NotNull Role role) {


}
