package com.example.trainingdemo.service;

import java.util.List;

import com.example.trainingdemo.entity.Employee;

public interface EmployeeService {

	Employee getEmployeeById(String employee_id);

	List<Employee> getAllEmployees();

	Employee saveEmployee(Employee employee);

	void deleteEmployee(String employee_id);

	Employee updateEmployee(String employee_id, Employee updatedEmployee);

	


	
}
