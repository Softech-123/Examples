package com.example.trainingdemo.entity;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
@Entity
@Table(name = "sops")
public class SOP {
	@Id
	private String sop_id;
    
	@Column(name = "sop_title")
    private String sop_title;
    
	 @ManyToOne
	   @JoinColumn(name = "department_id")
	   private Department department;
    
    @ManyToMany(mappedBy = "sops")
    @JsonIgnore
    private List<Employee> employees;
    
    @Column(name = "file_path")
    private String file_path;

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

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	public String getFile_path() {
		return file_path;
	}

	public void setFile_path(String file_path) {
		this.file_path = file_path;
	}

	public SOP() {
		
	}

	public SOP(String sop_id, String sop_title, Department department, List<Employee> employees, String file_path) {
		super();
		this.sop_id = sop_id;
		this.sop_title = sop_title;
		this.department = department;
		this.employees = employees;
		this.file_path = file_path;
	}

	@Override
	public String toString() {
		return "SOP [sop_id=" + sop_id + ", sop_title=" + sop_title + ", department=" + department + ", employees="
				+ employees + ", file_path=" + file_path + "]";
	}
  }
 





 



