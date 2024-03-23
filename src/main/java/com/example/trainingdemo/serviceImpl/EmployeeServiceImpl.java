package com.example.trainingdemo.serviceImpl;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.trainingdemo.entity.Employee;
import com.example.trainingdemo.entity.SOP;
import com.example.trainingdemo.repository.EmployeeRepository;
import com.example.trainingdemo.service.EmployeeService;
@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(String employee_id) {
        Optional<Employee> employeeOptional = employeeRepository.findById(employee_id);
        return employeeOptional.orElse(null);
    }

    @Override
    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee updateEmployee(String employee_id, Employee employee) {
        if (employeeRepository.existsById(employee_id)) {
            employee.setEmployee_id(employee_id);
            return employeeRepository.save(employee);
        }
        return null;
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
   
}