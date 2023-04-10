package com.example.demo.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.Data;

@Entity
@Data
public class Task {
	@Id
	@GeneratedValue
	public int taskid;
	@Column
	public String taskname;
	@Column
	public int deadline;
	@Column
	public String managertaskid;
	@Column
	public String status;
	
	@OneToOne(targetEntity=EmployeeSTL.class, cascade=CascadeType.ALL)
	@JoinColumn(name="workerid",referencedColumnName="eid")
	public EmployeeSTL empJob;
	
	
	
//	@OneToOne(targetEntity=EmployeeSTL.class,cascade=CascadeType.ALL)
//	@JoinColumn(name="eid" , referencedColumnName="workerid")
//	public EmployeeSTL employee;

	
}
