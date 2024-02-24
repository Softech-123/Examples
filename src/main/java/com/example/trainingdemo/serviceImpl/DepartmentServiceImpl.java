package com.example.trainingdemo.serviceImpl;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.trainingdemo.entity.Department;
import com.example.trainingdemo.repository.DepartmentRepository;
import com.example.trainingdemo.service.DepartmentService;
@Service
    public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    @Override
    public Department getDepartmentById(String department_id) {
        Optional<Department> departmentOptional = departmentRepository.findById(department_id);
        return departmentOptional.orElse(null);
    }

    @Override
    public Department createDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public Department updateDepartment(String department_id, Department updatedDepartment) {
        if (departmentRepository.existsById(department_id)) {
            updatedDepartment.setDepartment_id(department_id);
            return departmentRepository.save(updatedDepartment);
        }
        return null; // Handle department not found
    }

    @Override
    public void deleteDepartment(String department_id) {
        departmentRepository.deleteById(department_id);
    }
}