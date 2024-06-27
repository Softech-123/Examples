package com.example.trainingdemo.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.web.multipart.MultipartFile;

import com.example.trainingdemo.entity.SOP;

public interface SOPService {

	List<SOP> getAllSOPs();

	SOP getSOPById(String sop_id);

	SOP saveOrUpdateSOP(SOP sop);

	void deleteSOP(String sop_id);

	Optional<SOP> storeFile(String sop_id, MultipartFile file) throws IOException;
	
}