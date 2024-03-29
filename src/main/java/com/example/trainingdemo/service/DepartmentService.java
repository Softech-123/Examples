package com.example.trainingdemo.service;

import java.util.List;

import com.example.trainingdemo.entity.Department;

public interface DepartmentService {

	List<Department> getAllDepartments();

	Department getDepartmentById(String department_id);

	Department createDepartment(Department department);

	Department updateDepartment(String department_id, Department department);

	void deleteDepartment(String department_id);

	

	
}
