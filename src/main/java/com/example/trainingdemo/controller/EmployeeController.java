package com.example.trainingdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.trainingdemo.entity.Employee;
import com.example.trainingdemo.service.EmployeeService;
@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees() {
        List<Employee> employees = employeeService.getAllEmployees();
        return ResponseEntity.ok(employees);
    }

    @GetMapping("/{employee_id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable String employee_id) {
        Employee employee = employeeService.getEmployeeById(employee_id);
        return ResponseEntity.ok(employee);
    }

    @PostMapping
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee) {
        Employee savedEmployee = employeeService.saveEmployee(employee);
        return ResponseEntity.ok(savedEmployee);
    }

    @DeleteMapping("/{employee_id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable String employee_id) {
        employeeService.deleteEmployee(employee_id);
        return ResponseEntity.noContent().build();
    }
}