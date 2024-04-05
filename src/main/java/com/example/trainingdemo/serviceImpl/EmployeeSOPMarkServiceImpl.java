package com.example.trainingdemo.serviceImpl;
import java.util.List;

import org.springframework.stereotype.Service;
import com.example.trainingdemo.entity.EmployeeSOPMark;
import com.example.trainingdemo.repository.EmployeeSOPMarkRepository;
import com.example.trainingdemo.service.EmployeeSOPMarkService;

@Service
public class EmployeeSOPMarkServiceImpl implements EmployeeSOPMarkService {

    private final EmployeeSOPMarkRepository employeeSOPMarkRepository;

    public EmployeeSOPMarkServiceImpl(EmployeeSOPMarkRepository employeeSOPMarkRepository) {
        this.employeeSOPMarkRepository = employeeSOPMarkRepository;
    }

    @Override
    public List<EmployeeSOPMark> getAllEmployeeSOPMarks() {
        return employeeSOPMarkRepository.findAll();
    }

    @Override
    public EmployeeSOPMark getEmployeeSOPMarkById(Long id) {
        return employeeSOPMarkRepository.findById(id).orElse(null);
    }

    @Override
    public EmployeeSOPMark saveEmployeeSOPMark(EmployeeSOPMark employeeSOPMark) {
        return employeeSOPMarkRepository.save(employeeSOPMark);
    }

    @Override
    public void deleteEmployeeSOPMark(Long id) {
        employeeSOPMarkRepository.deleteById(id);
    }
    
}