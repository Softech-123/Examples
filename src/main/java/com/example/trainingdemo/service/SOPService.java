package com.example.trainingdemo.service;

import java.util.List;

import com.example.trainingdemo.entity.SOP;

public interface SOPService {

	SOP getSOPById(String sop_id);

	List<SOP> getAllSOPs();

	SOP createSOP(SOP sop);

	SOP updateSOP(String sop_id, SOP updatedSOP);

	void deleteSOP(String sop_id);
}
