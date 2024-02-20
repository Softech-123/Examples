package com.example.trainingdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/api/sops")
public class SOPController {

    @Autowired
    private SOPService sopService;

    @GetMapping
    public List<SOP> getAllSOPs() {
        return sopService.getAllSOPs();
    }

    @GetMapping("/{sopId}")
    public SOP getSOPById(@PathVariable String sopId) {
        return sopService.getSOPById(sopId);
    }

    @PostMapping
    public SOP saveSOP(@RequestBody SOP sop) {
        return sopService.saveSOP(sop);
    }

    @DeleteMapping("/{sopId}")
    public void deleteSOP(@PathVariable String sopId) {
        sopService.deleteSOP(sopId);
    }
}