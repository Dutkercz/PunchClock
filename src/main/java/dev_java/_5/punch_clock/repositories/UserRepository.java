package dev_java._5.punch_clock.repositories;

import dev_java._5.punch_clock.entities.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public interface UserRepository extends JpaRepository<User, Long> {
    Page<User> findAllByActiveTrue(Pageable page);

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    UserDetails findByEmail(String subject);
}
