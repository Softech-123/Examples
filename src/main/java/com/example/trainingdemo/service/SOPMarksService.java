package com.example.trainingdemo.service;

import java.util.List;

import com.example.trainingdemo.entity.SOPMarks;

public interface SOPMarksService {

	SOPMarks saveSOPMarks(SOPMarks sopMarks);

	List<SOPMarks> getAllSOPMarks();

	SOPMarks getSOPMarksById(Long id);

	void deleteSOPMarks(Long id);

	SOPMarks updateSOPMarks(Long id, SOPMarks updatedSOPMarks);
}
