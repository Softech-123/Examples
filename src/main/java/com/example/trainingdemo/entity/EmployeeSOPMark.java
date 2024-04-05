package com.example.trainingdemo.entity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
@Entity
@Table(name = "employee_sop_marks")
public class EmployeeSOPMark {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    //@JsonIgnore
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "sop_id")
    //@JsonIgnore
    private SOP sop;

    @Column(name = "marks")
    private Integer marks = 0;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public SOP getSop() {
		return sop;
	}

	public void setSop(SOP sop) {
		this.sop = sop;
	}

	public Integer getMarks() {
		return marks;
	}

	public void setMarks(Integer marks) {
		this.marks = marks;
	}

	public EmployeeSOPMark() {
		
	}
    public EmployeeSOPMark(Long id, Employee employee, SOP sop, Integer marks) {
		super();
		this.id = id;
		this.employee = employee;
		this.sop = sop;
		this.marks = marks;
	}

	@Override
	public String toString() {
		return "EmployeeSOPMark [id=" + id + ", employee=" + employee + ", sop=" + sop + ", marks=" + marks + "]";
	}
}

