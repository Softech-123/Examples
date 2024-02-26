package com.example.trainingdemo.serviceImpl;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.trainingdemo.entity.Employee;
import com.example.trainingdemo.repository.EmployeeRepository;
import com.example.trainingdemo.service.EmployeeService;
@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee getEmployeeById(String employee_id) {
        Optional<Employee> employee = employeeRepository.findById(employee_id);
        return employee.orElse(null);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public void deleteEmployee(String employee_id) {
        employeeRepository.deleteById(employee_id);
    }
}