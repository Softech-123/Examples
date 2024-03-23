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

import com.example.trainingdemo.entity.Employee;
import com.example.trainingdemo.entity.SOP;
import com.example.trainingdemo.service.SOPService;
@CrossOrigin("http://localhost:3000/")
@RestController
@RequestMapping("/api/sops")
public class SOPController {

	@Autowired
    private SOPService sopService;

    @GetMapping
    public ResponseEntity<List<SOP>> getAllSOPs() {
        List<SOP> sops = sopService.getAllSOPs();
        return new ResponseEntity<>(sops, HttpStatus.OK);
    }
    
    @GetMapping("/{sop_id}/employees")
    public ResponseEntity<List<Employee>> getEmployeesBySopId(@PathVariable String sop_id) {
        SOP sop = sopService.getSOPById(sop_id);
        if (sop != null) {
            List<Employee> employees = sop.getEmployees();
            return new ResponseEntity<>(employees, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    @GetMapping("/{sop_id}")
    public ResponseEntity<SOP> getSOPById(@PathVariable String sop_id) {
        SOP sop = sopService.getSOPById(sop_id);
        if (sop != null) {
            return new ResponseEntity<>(sop, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<SOP> createSOP(@RequestBody SOP sop) {
        SOP savedSOP = sopService.saveOrUpdateSOP(sop);
        return new ResponseEntity<>(savedSOP, HttpStatus.CREATED);
    }

    @PutMapping("/{sop_id}")
    public ResponseEntity<SOP> updateSOP(@PathVariable String sop_id, @RequestBody SOP sop) {
        SOP existingSOP = sopService.getSOPById(sop_id);
        if (existingSOP != null) {
            sop.setSop_id(sop_id);
            SOP updatedSOP = sopService.saveOrUpdateSOP(sop);
            return new ResponseEntity<>(updatedSOP, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{sop_id}")
    public ResponseEntity<Void> deleteSOP(@PathVariable String sop_id) {
        SOP existingSOP = sopService.getSOPById(sop_id);
        if (existingSOP != null) {
            sopService.deleteSOP(sop_id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}