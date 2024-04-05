package com.example.trainingdemo.service;

import java.util.List;

import com.example.trainingdemo.entity.EmployeeSOPMark;

public interface EmployeeSOPMarkService {

	List<EmployeeSOPMark> getAllEmployeeSOPMarks();

	EmployeeSOPMark getEmployeeSOPMarkById(Long id);

	EmployeeSOPMark saveEmployeeSOPMark(EmployeeSOPMark employeeSOPMark);

	void deleteEmployeeSOPMark(Long id);

}
