package dev_java._5.punch_clock.entities.dto;

import dev_java._5.punch_clock.entities.Role;
import dev_java._5.punch_clock.entities.User;

public record UserListingDTO(String name, String email, Role role ) {

    public UserListingDTO(User user) {
        this(user.getName(), user.getEmail(), user.getRole());
    }
}
