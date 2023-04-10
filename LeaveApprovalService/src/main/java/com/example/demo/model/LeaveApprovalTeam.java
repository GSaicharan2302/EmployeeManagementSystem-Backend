package com.example.demo.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.Data;

@Entity
@Data
public class LeaveApprovalTeam {
	@Id
	@GeneratedValue
	public int id;
	@Column
	public String from_date;
	@Column
	public String to_date;
	@Column
	public String type;
	@Column
	public String status;
	@Column
	public int no_of_days;
	@OneToOne(targetEntity=EmployeeSTL.class,cascade=CascadeType.ALL)
	@JoinColumn(name="emp_id" , referencedColumnName="eid")
	public EmployeeSTL empLeave;
}
