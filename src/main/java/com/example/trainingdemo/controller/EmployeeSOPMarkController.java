package com.example.trainingdemo.controller;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.trainingdemo.entity.EmployeeSOPMark;
import com.example.trainingdemo.service.EmployeeSOPMarkService;
@CrossOrigin("*")
@RestController
@RequestMapping("/employee_sop_marks")
public class EmployeeSOPMarkController {

    private final EmployeeSOPMarkService employeeSOPMarkService;

    public EmployeeSOPMarkController(EmployeeSOPMarkService employeeSOPMarkService) {
        this.employeeSOPMarkService = employeeSOPMarkService;
    }

    @GetMapping
    public ResponseEntity<List<EmployeeSOPMark>> getAllEmployeeSOPMarks() {
        List<EmployeeSOPMark> employeeSOPMarks = employeeSOPMarkService.getAllEmployeeSOPMarks();
        return new ResponseEntity<>(employeeSOPMarks, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeSOPMark> getEmployeeSOPMarkById(@PathVariable("id") Long id) {
        EmployeeSOPMark employeeSOPMark = employeeSOPMarkService.getEmployeeSOPMarkById(id);
        if (employeeSOPMark == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(employeeSOPMark, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<EmployeeSOPMark> saveEmployeeSOPMark(@RequestBody EmployeeSOPMark employeeSOPMark) {
        EmployeeSOPMark savedEmployeeSOPMark = employeeSOPMarkService.saveEmployeeSOPMark(employeeSOPMark);
        return new ResponseEntity<>(savedEmployeeSOPMark, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployeeSOPMark(@PathVariable("id") Long id) {
        employeeSOPMarkService.deleteEmployeeSOPMark(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}