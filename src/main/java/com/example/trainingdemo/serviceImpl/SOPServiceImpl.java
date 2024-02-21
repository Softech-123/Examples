package com.example.trainingdemo.serviceImpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.trainingdemo.entity.SOP;
import com.example.trainingdemo.repository.SOPRepository;
import com.example.trainingdemo.service.SOPService;

@Service
public class SOPServiceImpl implements SOPService {
	 @Autowired
	    private SOPRepository sopRepository;

	    @Override
	    public List<SOP> getAllSOPs() {
	        return sopRepository.findAll();
	    }

	    @Override
	    public SOP getSOPById(String sop_id) {
	        return sopRepository.findById(sop_id).orElse(null);
	    }

	    @Override
	    public SOP saveSOP(SOP sop) {
	        return sopRepository.save(sop);
	    }

	    @Override
	    public void deleteSOP(String sop_id) {
	        sopRepository.deleteById(sop_id);
	    }
}