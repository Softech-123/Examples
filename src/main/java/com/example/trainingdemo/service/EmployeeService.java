package com.example.trainingdemo.service;

import java.util.List;

import com.example.trainingdemo.entity.Employee;
import com.example.trainingdemo.entity.SOP;

public interface EmployeeService {

	Employee saveEmployee(Employee employee);

	Employee getEmployeeById(String employee_id);

	List<Employee> getAllEmployees();

	void deleteEmployee(String employee_id);

	List<SOP> getSOPsByEmployeeId(String employee_id);

	Employee updateEmployee(String employee_id, Employee employee);
}