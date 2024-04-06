package com.example.trainingdemo.service;

import java.util.List;

import com.example.trainingdemo.entity.Employee;
import com.example.trainingdemo.entity.EmployeeSOPMark;
import com.example.trainingdemo.entity.SOP;

public interface EmployeeService {

	List<Employee> getAllEmployees();

	Employee getEmployeeById(String employee_id);

	Employee createEmployee(Employee employee);

	Employee updateEmployee(String employee_id, Employee employee);

	void deleteEmployee(String employee_id);

	List<SOP> getSOPsByEmployeeId(String employee_id);

	List<EmployeeSOPMark> getEmployeeSOPMarks(String employee_id);

}
