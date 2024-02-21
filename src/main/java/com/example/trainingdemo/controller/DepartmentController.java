package com.example.trainingdemo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.trainingdemo.entity.Department;
import com.example.trainingdemo.service.DepartmentService;
@RestController
@RequestMapping("/departments")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @GetMapping
    public ResponseEntity<List<Department>> getAllDepartments() {
        List<Department> departments = departmentService.getAllDepartments();
        return ResponseEntity.ok(departments);
    }

    @GetMapping("/{department_id}")
    public ResponseEntity<Department> getDepartmentById(@PathVariable String department_id) {
        Department department = departmentService.getDepartmentById(department_id);
        return ResponseEntity.ok(department);
    }

    @PostMapping
    public ResponseEntity<Department> saveDepartment(@RequestBody Department department) {
        Department savedDepartment = departmentService.saveDepartment(department);
        return ResponseEntity.ok(savedDepartment);
    }

    @DeleteMapping("/{department_id}")
    public ResponseEntity<Void> deleteDepartment(@PathVariable String department_id) {
        departmentService.deleteDepartment(department_id);
        return ResponseEntity.noContent().build();
    }
}