package com.example.trainingdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.trainingdemo.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, String> {

}
