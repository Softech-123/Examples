package com.example.trainingdemo.serviceImpl;
import java.util.List;
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
        return departmentRepository.findById(department_id).orElse(null);
    }

    @Override
    public Department createDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public Department updateDepartment(String department_id, Department department) {
        Department existingDepartment = departmentRepository.findById(department_id).orElse(null);
        if (existingDepartment != null) {
            existingDepartment.setDept_name(department.getDept_name());
            return departmentRepository.save(existingDepartment);
        }
        return null;
    }

    @Override
    public void deleteDepartment(String department_id) {
        departmentRepository.deleteById(department_id);
    }
}