package dev_java._5.punch_clock.Service;

import dev_java._5.punch_clock.Repositories.EmployeeRepository;
import dev_java._5.punch_clock.controllers.dto.EmployeeDTO;
import dev_java._5.punch_clock.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository repository;

    public void saveRegister (EmployeeDTO dados){
        repository.save(new Employee(null, dados.name(), dados.email(), dados.password(),
                dados.role(), null));
    }
}
