package com.example.trainingdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
@RequestMapping("/departments")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @GetMapping
    public List<Department> getAllDepartments() {
        return departmentService.getAllDepartments();
    }

    @GetMapping("/{department_id}")
    public ResponseEntity<Department> getDepartmentById(@PathVariable String department_id) {
        Department department = departmentService.getDepartmentById(department_id);
        if (department != null) {
            return new ResponseEntity<>(department, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Void> createDepartment(@RequestBody Department department) {
        departmentService.saveDepartment(department);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{department_id}")
    public ResponseEntity<Void> updateDepartment(@PathVariable String department_id, @RequestBody Department department) {
        departmentService.updateDepartment(department_id, department);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{department_id}")
    public ResponseEntity<Void> deleteDepartment(@PathVariable String department_id) {
        departmentService.deleteDepartment(department_id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}