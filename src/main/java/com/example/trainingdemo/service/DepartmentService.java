package com.example.trainingdemo.service;

import java.util.List;

import com.example.trainingdemo.entity.Department;

public interface DepartmentService {

	List<Department> getAllDepartments();

	Department getDepartmentById(String department_id);

	void saveDepartment(Department department);

	void updateDepartment(String department_id, Department updatedDepartment);

	void deleteDepartment(String department_id);

	

}
