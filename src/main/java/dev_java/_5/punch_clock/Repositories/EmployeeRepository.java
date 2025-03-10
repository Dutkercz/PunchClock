package dev_java._5.punch_clock.Repositories;

import dev_java._5.punch_clock.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
