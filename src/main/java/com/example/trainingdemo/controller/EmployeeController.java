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
	    public List<Employee> getAllEmployees() {
	        return employeeService.getAllEmployees();
	    }

	    @GetMapping("/{employee_id}")
	    public Employee getEmployeeById(@PathVariable String employee_id) {
	        return employeeService.getEmployeeById(employee_id);
	    }

	    @PostMapping
	    public Employee saveEmployee(@RequestBody Employee employee) {
	        return employeeService.saveEmployee(employee);
	    }

	    @DeleteMapping("/{employee_id}")
	    public ResponseEntity<String> deleteEmployee(@PathVariable String employee_id) {
	        employeeService.deleteEmployee(employee_id);
	        return ResponseEntity.ok("Employee with ID " + employee_id + " deleted successfully.");
	    }
}
