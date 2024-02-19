package com.example.trainingdemo.service;

import java.util.List;

import com.example.trainingdemo.entity.Department;

public interface DepartmentService {

	Department saveDepartment(Department department);

	Department getDepartmentById(String department_id);

	List<Department> getAllDepartments();

}
