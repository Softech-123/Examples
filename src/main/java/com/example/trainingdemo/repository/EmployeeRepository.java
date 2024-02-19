package com.example.trainingdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.trainingdemo.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, String> {

}
