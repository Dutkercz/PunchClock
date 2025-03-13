package dev_java._5.punch_clock.entities;

import dev_java._5.punch_clock.entities.enums.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String password;
    private String cpf;

    @Enumerated(value = EnumType.STRING)
    private Role role;

    private Boolean active;

    @OneToMany(mappedBy = "user")
    private List<PunchClock> punchClocks;

    public void setInactive() {
        this.active = false;
    }
}
