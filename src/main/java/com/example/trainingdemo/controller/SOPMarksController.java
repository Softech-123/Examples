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
import com.example.trainingdemo.entity.SOPMarks;
import com.example.trainingdemo.service.SOPMarksService;
@CrossOrigin("*")
@RestController
@RequestMapping("/api/empsopmarks")
public class SOPMarksController {

    @Autowired
    private SOPMarksService sopMarksService;

    @PostMapping
    public ResponseEntity<SOPMarks> addSOPMarks(@RequestBody SOPMarks sopMarks) {
        SOPMarks createdSOPMarks = sopMarksService.saveSOPMarks(sopMarks);
        return new ResponseEntity<>(createdSOPMarks, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<SOPMarks>> getAllSOPMarks() {
        List<SOPMarks> sopMarksList = sopMarksService.getAllSOPMarks();
        return new ResponseEntity<>(sopMarksList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SOPMarks> getSOPMarksById(@PathVariable Long id) {
        SOPMarks sopMarks = sopMarksService.getSOPMarksById(id);
        if (sopMarks == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(sopMarks, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSOPMarks(@PathVariable Long id) {
        sopMarksService.deleteSOPMarks(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SOPMarks> updateSOPMarks(@PathVariable Long id, @RequestBody SOPMarks updatedSOPMarks) {
        SOPMarks updatedSOPMarksData = sopMarksService.updateSOPMarks(id, updatedSOPMarks);
        return new ResponseEntity<>(updatedSOPMarksData, HttpStatus.OK);
    }
    
    
}
