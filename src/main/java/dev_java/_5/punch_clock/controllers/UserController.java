package dev_java._5.punch_clock.controllers;

import dev_java._5.punch_clock.repositories.UserRepository;
import dev_java._5.punch_clock.service.UserService;
import dev_java._5.punch_clock.entities.dto_user.UserDTO;
import dev_java._5.punch_clock.entities.dto_user.UserListingDTO;
import dev_java._5.punch_clock.entities.User;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService service;
    @Autowired
    private UserRepository repository;

    @PostMapping("/register")
    public ResponseEntity<UserListingDTO> register(@RequestBody @Valid UserDTO dados,
                                                   UriComponentsBuilder builder){
        User user = service.saveRegister(dados);
        var uri = builder.path("/user/register/{id}").buildAndExpand(user.getId()).toUri();
        return ResponseEntity.created(uri).body(new UserListingDTO(user));
    }
    @GetMapping("/{id}")
    public ResponseEntity<UserListingDTO> findUser(@PathVariable Long id){
        var user = repository.getReferenceById(id);
        return ResponseEntity.ok().body(new UserListingDTO(user));
    }

    @GetMapping("/all")
    public Page<UserListingDTO> findAll(Pageable page){
        return service.findAllByAtivoTrue(page);
    }

    @DeleteMapping("/delete/{id}")
    @Transactional
    public ResponseEntity<UserListingDTO> logicalDeletion (@PathVariable Long id){
        repository.findById(id).orElseThrow();
        service.inactiveUser(id);
        return ResponseEntity.noContent().build();
    }
}
