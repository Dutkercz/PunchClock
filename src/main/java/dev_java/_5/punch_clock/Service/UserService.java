package dev_java._5.punch_clock.Service;

import dev_java._5.punch_clock.Repositories.UserRepository;
import dev_java._5.punch_clock.entities.dto.UserDTO;
import dev_java._5.punch_clock.entities.User;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    @Transactional
    public User saveRegister (UserDTO dados){
        return repository.save(new User(null, dados.name(),
                dados.email(), dados.password(), dados.cpf(),
                dados.role(), true));
    }
    public void inactiveUser(Long id) {
        var user = repository.getReferenceById(id);
        user.setInactive();
    }
}
