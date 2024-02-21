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

import com.example.trainingdemo.entity.SOP;
import com.example.trainingdemo.service.SOPService;
@RestController
@RequestMapping("/sops")
public class SOPController {

    @Autowired
    private SOPService sopService;

    @GetMapping("/{sopId}")
    public ResponseEntity<SOP> getSOPById(@PathVariable String sop_id) {
        SOP sop = sopService.getSOPById(sop_id);
        return ResponseEntity.ok(sop);
    }

    @GetMapping
    public ResponseEntity<List<SOP>> getAllSOPs() {
        List<SOP> sops = sopService.getAllSOPs();
        return ResponseEntity.ok(sops);
    }

    @PostMapping
    public ResponseEntity<SOP> saveSOP(@RequestBody SOP sop) {
        SOP savedSOP = sopService.saveSOP(sop);
        return ResponseEntity.ok(savedSOP);
    }

    @DeleteMapping("/{sopId}")
    public ResponseEntity<Void> deleteSOP(@PathVariable String sop_id) {
        sopService.deleteSOP(sop_id);
        return ResponseEntity.noContent().build();
    }
}