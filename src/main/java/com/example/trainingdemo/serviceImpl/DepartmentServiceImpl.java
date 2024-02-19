package com.example.trainingdemo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.trainingdemo.entity.Department;
import com.example.trainingdemo.repository.DepartmentRepository;
import com.example.trainingdemo.service.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService{
	@Autowired
    private DepartmentRepository departmentRepository; // Assuming you have a DepartmentRepository

    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public Department getDepartmentById(String department_id) {
        return departmentRepository.findById(department_id).orElse(null);
    }

    @Override
    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }
}
