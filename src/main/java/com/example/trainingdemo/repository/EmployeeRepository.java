package com.example.trainingdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.trainingdemo.entity.Employee;
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, String> {
   
}