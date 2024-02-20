package com.example.trainingdemo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
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

    private final SOPService sopService;

    public SOPController(SOPService sopService) {
        this.sopService = sopService;
    }

    @GetMapping
    public ResponseEntity<List<SOP>> getAllSOPs() {
        List<SOP> sops = sopService.getAllSOPs();
        return new ResponseEntity<>(sops, HttpStatus.OK);
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
    public ResponseEntity<SOP> saveSOP(@RequestBody SOP sop) {
        SOP savedSOP = sopService.saveSOP(sop);
        return new ResponseEntity<>(savedSOP, HttpStatus.CREATED);
    }

    @DeleteMapping("/{sop_id}")
    public ResponseEntity<Void> deleteSOP(@PathVariable String sop_id) {
        sopService.deleteSOP(sop_id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
