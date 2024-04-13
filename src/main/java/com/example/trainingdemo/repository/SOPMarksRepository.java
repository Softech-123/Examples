package com.example.trainingdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.trainingdemo.entity.SOPMarks;

@Repository
public interface SOPMarksRepository extends JpaRepository<SOPMarks, Long> {
    
}
