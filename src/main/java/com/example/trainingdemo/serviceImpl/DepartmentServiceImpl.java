package com.example.trainingdemo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.trainingdemo.entity.Department;
import com.example.trainingdemo.repository.DepartmentRepository;
import com.example.trainingdemo.service.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository; // Assuming you have a DepartmentRepository

    @Override
    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    @Override
    public Department getDepartmentById(String department_id) {
        return departmentRepository.findById(department_id).orElse(null);
    }

    @Override
    public void saveDepartment(Department department) {
        departmentRepository.save(department);
    }

    @Override
    public void updateDepartment(String department_id, Department updatedDepartment) {
        Department existingDepartment = departmentRepository.findById(department_id).orElse(null);

        if (existingDepartment != null) {
            // Update relevant fields in existingDepartment with values from updatedDepartment
            existingDepartment.setDept_name(updatedDepartment.getDept_name());
            // Update other fields as needed

            departmentRepository.save(existingDepartment);
        }
    }

    @Override
    public void deleteDepartment(String department_id) {
        departmentRepository.deleteById(department_id);
    }
}