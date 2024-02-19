package com.example.trainingdemo.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Department {
	@Id
	@Column(name = "department_id")
    private String department_id;
    @Column(name = "dept_name")
    private String dept_name;

    @OneToMany(mappedBy = "department")
    private List<Employee> employees;

    @OneToMany(mappedBy = "department")
    private List<SOP> sops;

	public String getDepartment_id() {
		return department_id;
	}

	public void setDepartment_id(String department_id) {
		this.department_id = department_id;
	}

	public String getDept_name() {
		return dept_name;
	}

	public void setDept_name(String dept_name) {
		this.dept_name = dept_name;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	public List<SOP> getSops() {
		return sops;
	}

	public void setSops(List<SOP> sops) {
		this.sops = sops;
	}

	public Department() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Department(String department_id, String dept_name, List<Employee> employees, List<SOP> sops) {
		super();
		this.department_id = department_id;
		this.dept_name = dept_name;
		this.employees = employees;
		this.sops = sops;
	}

	@Override
	public String toString() {
		return "Department [department_id=" + department_id + ", dept_name=" + dept_name + ", employees=" + employees
				+ ", sops=" + sops + "]";
	}
    

}
