package dev_java._5.punch_clock.entities;

import dev_java._5.punch_clock.entities.enums.Type;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Getter
@Table
public class PunchClock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(value = EnumType.STRING)
    private Type type;
    private LocalDateTime timeStamp;

    @ManyToOne
    @JoinColumn
    private User user;

}
