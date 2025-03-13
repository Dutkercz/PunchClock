package dev_java._5.punch_clock.Repositories;

import dev_java._5.punch_clock.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
