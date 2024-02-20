package com.example.trainingdemo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.trainingdemo.entity.Department;
import com.example.trainingdemo.service.DepartmentService;
@RestController
@RequestMapping("api/departments")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @GetMapping
    public List<Department> getAllDepartments() {
        return departmentService.getAllDepartments();
    }

    @GetMapping("/{department_id}")
    public Department getDepartmentById(@PathVariable String department_id) {
        return departmentService.getDepartmentById(department_id);
    }

    @PostMapping
    public Department createDepartment(@RequestBody Department department) {
        return departmentService.createDepartment(department);
    }

    @PutMapping("/{department_id}")
    public Department updateDepartment(@PathVariable String department_id, @RequestBody Department department) {
        return departmentService.updateDepartment(department_id, department);
    }

    @DeleteMapping("/{department_id}")
    public void deleteDepartment(@PathVariable String department_id) {
        departmentService.deleteDepartment(department_id);
    }
}