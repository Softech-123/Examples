package com.example.trainingdemo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class SOP {
	@Id
	@Column(name = "sop_id")
    private String sop_id;
    
	@Column(name = "sop_title")
    private String sop_title;

	@ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

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

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
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

	public SOP(String sop_id, String sop_title, Employee employee, Department department) {
		super();
		this.sop_id = sop_id;
		this.sop_title = sop_title;
		this.employee = employee;
		this.department = department;
	}

	@Override
	public String toString() {
		return "SOP [sop_id=" + sop_id + ", sop_title=" + sop_title + ", employee=" + employee + ", department="
				+ department + "]";
	}
    
}
