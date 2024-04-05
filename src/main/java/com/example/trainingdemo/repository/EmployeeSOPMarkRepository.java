package com.example.trainingdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.trainingdemo.entity.EmployeeSOPMark;

@Repository
public interface EmployeeSOPMarkRepository extends JpaRepository<EmployeeSOPMark, Long> {
    
}
