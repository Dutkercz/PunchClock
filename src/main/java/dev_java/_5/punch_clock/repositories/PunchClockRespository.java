package dev_java._5.punch_clock.repositories;

import dev_java._5.punch_clock.entities.PunchClock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PunchClockRespository extends JpaRepository<PunchClock, Long> {
}
