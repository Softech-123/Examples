package com.example.trainingdemo.entity;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
@Entity
@Table(name = "sops")
public class SOP {
	@Id
	private String sop_id;
    
	@Column(name = "sop_title")
    private String sop_title;
    
    @ManyToMany
    @JsonIgnore
    @JoinTable(
        name = "department_sop",
        joinColumns = @JoinColumn(name = "sop_id"),
        inverseJoinColumns = @JoinColumn(name = "department_id")
    )
    private List<Department> departments;
    
    @ManyToMany(mappedBy = "sops")
    @JsonIgnore
    private List<Employee> employees;

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

	public List<Department> getDepartments() {
		return departments;
	}

	public void setDepartments(List<Department> departments) {
		this.departments = departments;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	public SOP() {
		
	}

	public SOP(String sop_id, String sop_title, List<Department> departments, List<Employee> employees) {
		super();
		this.sop_id = sop_id;
		this.sop_title = sop_title;
		this.departments = departments;
		this.employees = employees;
	}

	@Override
	public String toString() {
		return "SOP [sop_id=" + sop_id + ", sop_title=" + sop_title + ", departments=" + departments + ", employees="
				+ employees + "]";
	}
    }
