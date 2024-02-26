package com.example.trainingdemo.service;

import java.util.List;

import com.example.trainingdemo.entity.SOP;

public interface SOPService {

	SOP getSOPById(String sop_id);

	List<SOP> getAllSOPs();

	SOP saveSOP(SOP sop);

	void deleteSOP(String sop_id);
}
