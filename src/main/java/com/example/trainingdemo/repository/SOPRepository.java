package com.example.trainingdemo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.trainingdemo.entity.Department;
import com.example.trainingdemo.entity.SOP;
@Repository
public interface SOPRepository extends JpaRepository<SOP, String> {

	List<SOP> findByDepartment(Department department);

}
