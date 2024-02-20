package com.example.trainingdemo.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "sops")
public class SOP {
	@Id
	@Column(name = "sop_id")
    private String sop_id;
    
	@Column(name = "sop_title")
    private String sop_title;
	
	@OneToMany(mappedBy = "sop")
    private List<Employee> employees;

	@ManyToOne
	 @JoinColumn(name = "department_id")
	 private  Department department;

	public String getSop_id() {
		return sop_id;
	}

	public void setSop_id(String sop_id) {
		this.sop_id = sop_id;
	}

	public String getSop_title() {
		return sop_title;
	}

	public void setSop_title(String sop_title) {
		this.sop_title = sop_title;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public SOP() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SOP(String sop_id, String sop_title, List<Employee> employees, Department department) {
		super();
		this.sop_id = sop_id;
		this.sop_title = sop_title;
		this.employees = employees;
		this.department = department;
	}

	@Override
	public String toString() {
		return "SOP [sop_id=" + sop_id + ", sop_title=" + sop_title + ", employees=" + employees + ", department="
				+ department + "]";
	}
	
	


	
}
