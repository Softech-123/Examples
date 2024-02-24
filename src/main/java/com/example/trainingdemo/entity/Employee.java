package com.example.trainingdemo.entity;
import java.time.LocalDate;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
@Entity
  @Table(name = "employees")
  public class Employee {
  @Id
   private String employee_id;

  @Column(name = "employee_name")
    private String employee_name;
  

   @ManyToOne
   @JoinColumn(name = "department_id")
   @JsonBackReference
   @JsonIgnore
   private Department department;
 
   @ManyToMany(mappedBy = "employees")
   @JsonBackReference
   @JsonIgnore
    private Set<SOP> sops;
    
   @Column(name = "start_date")
    private LocalDate start_date;
 
   @Column(name = "end_date")
    private LocalDate end_date;
 
   @Column(name = "completed")
    private boolean completed;

public String getEmployee_id() {
	return employee_id;
}

public void setEmployee_id(String employee_id) {
	this.employee_id = employee_id;
}

public String getEmployee_name() {
	return employee_name;
}

public void setEmployee_name(String employee_name) {
	this.employee_name = employee_name;
}

public Department getDepartment() {
	return department;
}

public void setDepartment(Department department) {
	this.department = department;
}

public Set<SOP> getSops() {
	return sops;
}

public void setSops(Set<SOP> sops) {
	this.sops = sops;
}

public LocalDate getStart_date() {
	return start_date;
}

public void setStart_date(LocalDate start_date) {
	this.start_date = start_date;
}

public LocalDate getEnd_date() {
	return end_date;
}

public void setEnd_date(LocalDate end_date) {
	this.end_date = end_date;
}

public boolean isCompleted() {
	return completed;
}

public void setCompleted(boolean completed) {
	this.completed = completed;
}

public Employee() {
	super();
	// TODO Auto-generated constructor stub
}

public Employee(String employee_id, String employee_name, Department department, Set<SOP> sops, LocalDate start_date,
		LocalDate end_date, boolean completed) {
	super();
	this.employee_id = employee_id;
	this.employee_name = employee_name;
	this.department = department;
	this.sops = sops;
	this.start_date = start_date;
	this.end_date = end_date;
	this.completed = completed;
}

@Override
public String toString() {
	return "Employee [employee_id=" + employee_id + ", employee_name=" + employee_name + ", department=" + department
			+ ", sops=" + sops + ", start_date=" + start_date + ", end_date=" + end_date + ", completed=" + completed
			+ "]";
}
}
