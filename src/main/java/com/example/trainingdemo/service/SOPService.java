package com.example.trainingdemo.service;

import java.util.List;

import com.example.trainingdemo.entity.SOP;

public interface SOPService {

	List<SOP> getAllSOPs();

	SOP getSOPById(String sop_id);

	SOP saveOrUpdateSOP(SOP sop);

	void deleteSOP(String sop_id);

	
}
