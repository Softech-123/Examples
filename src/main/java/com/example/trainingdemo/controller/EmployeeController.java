package com.example.trainingdemo.controller;
import java.util.List;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.trainingdemo.entity.Employee;
import com.example.trainingdemo.entity.SOP;
import com.example.trainingdemo.service.EmployeeService;
@CrossOrigin("*")
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    @GetMapping("/{employee_id}/sops")
    public List<SOP> getSOPsByEmployeeId(@PathVariable String employee_id) {
        return employeeService.getSOPsByEmployeeId(employee_id);
    }

    @PostMapping
    public Employee saveEmployee(@RequestBody Employee employee) {
        return employeeService.saveEmployee(employee);
    }

    @GetMapping("/{employee_id}")
    public Employee getEmployeeById(@PathVariable String employee_id) {
        return employeeService.getEmployeeById(employee_id);
    }

    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @DeleteMapping("/{employee_id}")
    public void deleteEmployee(@PathVariable String employee_id) {
        employeeService.deleteEmployee(employee_id);
    }
    @PutMapping("/{employee_id}")
    public Employee updateEmployee(@PathVariable String employee_id, @RequestBody Employee employee) {
        return employeeService.updateEmployee(employee_id, employee);
    }
}