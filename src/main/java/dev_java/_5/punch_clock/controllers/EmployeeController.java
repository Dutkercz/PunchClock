package dev_java._5.punch_clock.controllers;

import dev_java._5.punch_clock.Repositories.EmployeeRepository;
import dev_java._5.punch_clock.Service.EmployeeService;
import dev_java._5.punch_clock.controllers.dto.EmployeeDTO;
import dev_java._5.punch_clock.entities.Employee;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    @PostMapping("/register")
    public ResponseEntity<EmployeeListagemDTO> register(@RequestBody @Valid EmployeeDTO dados){
        service.saveRegister(dados);
    }
}
