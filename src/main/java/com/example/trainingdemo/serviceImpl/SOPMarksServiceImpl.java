package com.example.trainingdemo.serviceImpl;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.trainingdemo.entity.SOPMarks;
import com.example.trainingdemo.repository.SOPMarksRepository;
import com.example.trainingdemo.service.SOPMarksService;

@Service
public class SOPMarksServiceImpl implements SOPMarksService {
    
    @Autowired
    private SOPMarksRepository sopMarksRepository;
    
    @Override
    public SOPMarks saveSOPMarks(SOPMarks sopMarks) {
        return sopMarksRepository.save(sopMarks);
    }

    @Override
    public List<SOPMarks> getAllSOPMarks() {
        return sopMarksRepository.findAll();
    }

    @Override
    public SOPMarks getSOPMarksById(Long id) {
        return sopMarksRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteSOPMarks(Long id) {
        sopMarksRepository.deleteById(id);
    }
    @Override
    public SOPMarks updateSOPMarks(Long id, SOPMarks updatedSOPMarks) {
        Optional<SOPMarks> optionalSOPMarks = sopMarksRepository.findById(id);
        if (optionalSOPMarks.isPresent()) {
            SOPMarks existingSOPMarks = optionalSOPMarks.get();
            existingSOPMarks.setEmployee_id(updatedSOPMarks.getEmployee_id());
            existingSOPMarks.setSop_id(updatedSOPMarks.getSop_id());
            existingSOPMarks.setMarks(updatedSOPMarks.getMarks());
            return sopMarksRepository.save(existingSOPMarks);
        } else {
            throw new RuntimeException("SOPMarks not found with id: " + id);
        }
    }
}
