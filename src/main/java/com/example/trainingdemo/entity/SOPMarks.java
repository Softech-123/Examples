package com.example.trainingdemo.entity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "empsopmarks")
public class SOPMarks {
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    
       @Column(name = "employee_id")
	    private String employee_id;
	    
	    @Column(name = "sop_id")
	    private String sop_id;
	    
	    @Column(name = "marks")
	    private Integer marks=0;

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		
		public String getEmployee_id() {
			return employee_id;
		}

		public void setEmployee_id(String employee_id) {
			this.employee_id = employee_id;
		}

		public String getSop_id() {
			return sop_id;
		}

		public void setSop_id(String sop_id) {
			this.sop_id = sop_id;
		}

		public Integer getMarks() {
			return marks;
		}

		public void setMarks(Integer marks) {
			this.marks = marks;
		}

		public SOPMarks() {
			super();
			// TODO Auto-generated constructor stub
		}

		@Override
		public String toString() {
			return "SOPMarks [id=" + id + ", employee_id=" + employee_id + ", sop_id=" + sop_id + ", marks=" + marks
					+ "]";
		}
}
