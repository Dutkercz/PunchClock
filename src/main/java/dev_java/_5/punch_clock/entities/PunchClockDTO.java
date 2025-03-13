package dev_java._5.punch_clock.entities;

import dev_java._5.punch_clock.entities.enums.Type;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record PunchClockDTO(@NotNull Type type,
                            @NotNull LocalDateTime timeStamp,
                            @NotNull User user) {
}
