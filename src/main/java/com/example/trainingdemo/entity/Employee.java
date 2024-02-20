package com.example.trainingdemo.entity;
import java.time.LocalDate;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


  @Entity
  @Table(name = "employees")
  public class Employee {
  @Id
  @Column(name = "employee_id")
    private String employee_id;

    @Column(name = "employee_name")
    private String employee_name;
    
 @Column(name = "startDate")
    private LocalDate startDate;
 
 @Column(name = "endDate")
    private LocalDate endDate;
 
 @Column(name = "completed")
    private boolean completed;
 
 @ManyToOne
 @JoinColumn(name = "department_id")
 private Department department;
 
 @ManyToOne
 @JoinColumn(name = "sop_id")
 private SOP sop;

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

public LocalDate getStartDate() {
	return startDate;
}

public void setStartDate(LocalDate startDate) {
	this.startDate = startDate;
}

public LocalDate getEndDate() {
	return endDate;
}

public void setEndDate(LocalDate endDate) {
	this.endDate = endDate;
}

public boolean isCompleted() {
	return completed;
}

public void setCompleted(boolean completed) {
	this.completed = completed;
}

public Department getDepartment() {
	return department;
}

public void setDepartment(Department department) {
	this.department = department;
}

public SOP getSop() {
	return sop;
}

public void setSop(SOP sop) {
	this.sop = sop;
}

public Employee() {
	super();
	// TODO Auto-generated constructor stub
}

public Employee(String employee_id, String employee_name, LocalDate startDate, LocalDate endDate, boolean completed,
		Department department, SOP sop) {
	super();
	this.employee_id = employee_id;
	this.employee_name = employee_name;
	this.startDate = startDate;
	this.endDate = endDate;
	this.completed = completed;
	this.department = department;
	this.sop = sop;
}

@Override
public String toString() {
	return "Employee [employee_id=" + employee_id + ", employee_name=" + employee_name + ", startDate=" + startDate
			+ ", endDate=" + endDate + ", completed=" + completed + ", department=" + department + ", sop=" + sop + "]";
}
 



}
