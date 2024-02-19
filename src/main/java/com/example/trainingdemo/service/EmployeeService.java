package com.example.trainingdemo.service;

import java.util.List;

import com.example.trainingdemo.entity.Employee;

public interface EmployeeService {

	List<Employee> getAllEmployees();

	Employee getEmployeeById(String employee_id);

	void saveEmployee(Employee employee);

	void updateEmployee(Employee employee);

	void deleteEmployee(String employee_id);

}
