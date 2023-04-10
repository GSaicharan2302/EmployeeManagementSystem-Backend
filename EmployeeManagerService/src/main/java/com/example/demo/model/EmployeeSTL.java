package com.example.demo.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.Data;

@Data
@Entity
public class EmployeeSTL {

	@Id
	@Column(length=50)
	public String eid;
	@Column
	public String ename;
	@Column
	public int salary;
	@Column
	public String Role;
	@Column
	public String Branch;
	@Column
	public int temporaryid;
	
@OneToOne(targetEntity=ManagerSTL.class ,cascade=CascadeType.ALL)
	@JoinColumn(name="manager_id" ,referencedColumnName="mid")

	public ManagerSTL manager;
	
	
	
}
