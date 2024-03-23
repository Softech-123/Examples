package com.example.trainingdemo.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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
@CrossOrigin("http://localhost:3000/")
@RestController
@RequestMapping("/api/departments")
public class DepartmentController {
	@Autowired
    private DepartmentService departmentService;

    @GetMapping
    public ResponseEntity<List<Department>> getAllDepartments() {
        List<Department> departments = departmentService.getAllDepartments();
        return new ResponseEntity<>(departments, HttpStatus.OK);
    }

    @GetMapping("/{department_id}/sops")
    public ResponseEntity<?> getSOPsByDepartmentId(@PathVariable String department_id) {
        Department department = departmentService.getDepartmentById(department_id);
        if (department != null) {
            return new ResponseEntity<>(department.getSops(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Department not found", HttpStatus.NOT_FOUND);
        }
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
    public ResponseEntity<Department> createDepartment(@RequestBody Department department) {
        Department createdDepartment = departmentService.createDepartment(department);
        return new ResponseEntity<>(createdDepartment, HttpStatus.CREATED);
    }

    @PutMapping("/{department_id}")
    public ResponseEntity<Department> updateDepartment(@PathVariable String department_id, @RequestBody Department department) {
        Department updatedDepartment = departmentService.updateDepartment(department_id, department);
        if (updatedDepartment != null) {
            return new ResponseEntity<>(updatedDepartment, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{department_id}")
    public ResponseEntity<Void> deleteDepartment(@PathVariable String department_id) {
        departmentService.deleteDepartment(department_id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}