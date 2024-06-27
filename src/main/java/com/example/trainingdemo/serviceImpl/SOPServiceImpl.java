package com.example.trainingdemo.serviceImpl;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.example.trainingdemo.entity.SOP;
import com.example.trainingdemo.repository.SOPRepository;
import com.example.trainingdemo.service.SOPService;

@Service
public class SOPServiceImpl implements SOPService {

	@Autowired
    private SOPRepository sopRepository;
	
	private final String uploadDir = "C:\\Uploads\\";
	@Override
    public Optional<SOP> storeFile(String sop_id, MultipartFile file) throws IOException {
        Optional<SOP> optionalSop = sopRepository.findById(sop_id);
        if (optionalSop.isPresent()) {
            SOP sop = optionalSop.get();

            Path uploadPath = Paths.get(uploadDir);
            if (!Files.exists(uploadPath)) {
                Files.createDirectories(uploadPath);
            }

           
            String filePath = uploadDir + file.getOriginalFilename();
            Files.copy(file.getInputStream(), Paths.get(filePath));

          
            sop.setFile_path(filePath);
            sopRepository.save(sop);
            return Optional.of(sop);
        } else {
            return Optional.empty();
        }
    }

    @Override
    public List<SOP> getAllSOPs() {
        return sopRepository.findAll();
    }

    @Override
    public SOP getSOPById(String sop_id) {
        Optional<SOP> sopOptional = sopRepository.findById(sop_id);
        return sopOptional.orElse(null);
    }

    @Override
    public SOP saveOrUpdateSOP(SOP sop) {
        return sopRepository.save(sop);
    }

    @Override
    public void deleteSOP(String sop_id) {
        sopRepository.deleteById(sop_id);
    }
}