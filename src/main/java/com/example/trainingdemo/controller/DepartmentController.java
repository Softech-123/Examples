package com.example.trainingdemo.controller;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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
import com.example.trainingdemo.entity.SOP;
import com.example.trainingdemo.repository.DepartmentRepository;
import com.example.trainingdemo.repository.SOPRepository;
import com.example.trainingdemo.service.DepartmentService;
@CrossOrigin("http://localhost:3000/")
@RestController
@RequestMapping("/api/departments")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;
    
    private final DepartmentRepository departmentRepository;
    
    public DepartmentController(DepartmentRepository departmentRepository, SOPRepository sopRepository) {
        this.departmentRepository = departmentRepository;
     }

    @GetMapping("/{department_id}/sops")
    public Set<SOP> getSOPsByDepartmentId(@PathVariable String department_id) {
            Department department = departmentRepository.findById(department_id).orElse(null);
            if (department == null) {
               return null;
            }
            return department.getSops();
        }
    
    @GetMapping
    public List<Department> getAllDepartments() {
        return departmentService.getAllDepartments();
    }

    @GetMapping(value="/{department_id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Department> getDepartmentById(@PathVariable String department_id) {
        Department department = departmentService.getDepartmentById(department_id);
        return ResponseEntity.ok(department);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> saveDepartment(@RequestBody Department department) {
        departmentService.saveDepartment(department);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{department_id}")
    public ResponseEntity<Void> updateDepartment(@PathVariable String department_id, @RequestBody Department updatedDepartment) {
        departmentService.updateDepartment(department_id, updatedDepartment);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{department_id}")
    public ResponseEntity<Void> deleteDepartment(@PathVariable String department_id) {
        departmentService.deleteDepartment(department_id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}