package com.example.trainingdemo.serviceImpl;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import com.example.trainingdemo.entity.Employee;
import com.example.trainingdemo.entity.SOP;
import com.example.trainingdemo.repository.EmployeeRepository;
import com.example.trainingdemo.service.EmployeeService;
@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee getEmployeeById(String employee_id) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(employee_id);
        return optionalEmployee.orElse(null);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public void deleteEmployee(String employee_id) {
        employeeRepository.deleteById(employee_id);
    }
    @Override
    public List<SOP> getSOPsByEmployeeId(String employee_id) {
        Employee employee = employeeRepository.findById(employee_id).orElse(null);
        if (employee != null) {
            return employee.getSops();
        }
        return null;
    }
    @Override
    public Employee updateEmployee(String employee_id, Employee employee) {
        if (employeeRepository.existsById(employee_id)) {
            employee.setEmployee_id(employee_id);
            return employeeRepository.save(employee);
        }
        return null;
    }
}