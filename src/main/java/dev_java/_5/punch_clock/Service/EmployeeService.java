package dev_java._5.punch_clock.Service;

import dev_java._5.punch_clock.Repositories.EmployeeRepository;
import dev_java._5.punch_clock.controllers.dto.EmployeeDTO;
import dev_java._5.punch_clock.entities.Employee;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository repository;

    @Transactional
    public Employee saveRegister (EmployeeDTO dados){
        return repository.save(new Employee(null, dados.name(),
                dados.email(), dados.password(),
                dados.role(), true));
    }
    public void inactiveEmployee(Long id) {
        var employee = repository.getReferenceById(id);
        employee.setInactive();
    }
}
