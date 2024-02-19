package com.example.trainingdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.trainingdemo.entity.SOP;

public interface SOPRepository extends JpaRepository<SOP ,String> {

}
