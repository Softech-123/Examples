package com.example.trainingdemo.entity;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

  @Entity
  @Table(name = "departments")
  public class Department {
	@Id
	private String department_id;
	
    @Column(name = "dept_name")
    private String dept_name;
    
    @OneToMany(mappedBy = "department")
    @JsonManagedReference
    @JsonIgnore
    private Set<Employee> employees;
    
    @OneToMany(mappedBy = "department")
    @JsonManagedReference
    @JsonIgnore
    private Set<SOP> sops;

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

	public Set<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}

	public Set<SOP> getSops() {
		return sops;
	}

	public void setSops(Set<SOP> sops) {
		this.sops = sops;
	}

	public Department() {
		
		}
   public Department(String department_id, String dept_name, Set<Employee> employees, Set<SOP> sops) {
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
