package dev_java._5.punch_clock.Service;

import dev_java._5.punch_clock.Repositories.UserRepository;
import dev_java._5.punch_clock.entities.PunchClock;
import dev_java._5.punch_clock.entities.dto_user.UserDTO;
import dev_java._5.punch_clock.entities.User;
import dev_java._5.punch_clock.entities.dto_user.UserListingDTO;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    @Transactional
    public User saveRegister (UserDTO dados){
        return repository.save(new User(null, dados.name(),
                dados.email(), dados.password(), dados.cpf(),
                dados.role(), true, null));
    }

    @Transactional
    public void inactiveUser(Long id) {
        var user = repository.getReferenceById(id);
        user.setInactive();
    }

    public Page<UserListingDTO> findAllByAtivoTrue(Pageable page) {
        return repository.findAllByActiveTrue(page).map(UserListingDTO::new);
    }
}
