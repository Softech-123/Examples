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
import com.example.trainingdemo.entity.SOP;
import com.example.trainingdemo.service.SOPService;
@RestController
@RequestMapping("/api/sops")
public class SOPController {

    @Autowired
    private SOPService sopService;

    @GetMapping("/{sopId}")
    public ResponseEntity<SOP> getSOPById(@PathVariable String sopId) {
        SOP sop = sopService.getSOPById(sopId);
        return (sop != null) ? ResponseEntity.ok(sop) : ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<SOP>> getAllSOPs() {
        List<SOP> allSOPs = sopService.getAllSOPs();
        return ResponseEntity.ok(allSOPs);
    }

    @PostMapping
    public ResponseEntity<SOP> createSOP(@RequestBody SOP sop) {
        SOP createdSOP = sopService.createSOP(sop);
        return new ResponseEntity<>(createdSOP, HttpStatus.CREATED);
    }

    @PutMapping("/{sopId}")
    public ResponseEntity<SOP> updateSOP(@PathVariable String sopId, @RequestBody SOP updatedSOP) {
        SOP updatedSOPResult = sopService.updateSOP(sopId, updatedSOP);
        return (updatedSOPResult != null) ? ResponseEntity.ok(updatedSOPResult) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{sopId}")
    public ResponseEntity<Void> deleteSOP(@PathVariable String sopId) {
        sopService.deleteSOP(sopId);
        return ResponseEntity.noContent().build();
    }
}