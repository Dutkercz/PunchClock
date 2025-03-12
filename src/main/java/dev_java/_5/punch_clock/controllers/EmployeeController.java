package dev_java._5.punch_clock.controllers;

import dev_java._5.punch_clock.Repositories.EmployeeRepository;
import dev_java._5.punch_clock.Service.EmployeeService;
import dev_java._5.punch_clock.controllers.dto.EmployeeDTO;
import dev_java._5.punch_clock.controllers.dto.EmployeeListagemDTO;
import dev_java._5.punch_clock.entities.Employee;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping(value = "/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService service;
    @Autowired
    private EmployeeRepository repository;

    @PostMapping("/register")
    public ResponseEntity<EmployeeListagemDTO> register(@RequestBody @Valid EmployeeDTO dados,
                                                        UriComponentsBuilder builder){
        Employee employee = service.saveRegister(dados);
        var uri = builder.path("/employee/register/{id}").buildAndExpand(employee.getId()).toUri();
        return ResponseEntity.created(uri).body(new EmployeeListagemDTO(employee));
    }
    @GetMapping("/{id}")
    public ResponseEntity<EmployeeListagemDTO> findEmployee(@PathVariable Long id){
        var employee = repository.getReferenceById(id);
        return ResponseEntity.ok().body(new EmployeeListagemDTO(employee));
    }

    @DeleteMapping("/delete/{id}")
    @Transactional
    public ResponseEntity<EmployeeListagemDTO> logicalDeletion (@PathVariable Long id){
        repository.findById(id).orElseThrow();
        service.inactiveEmployee(id);
        return ResponseEntity.noContent().build();
    }
}
