package com.example.demo.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.Data;

@Data
@Entity
public class ManagerSTL {
	@Id
	@Column(length = 50)
	public String mid;
	@Column
	public String mname;
	@Column
	public String Grade;
	@Column
	public String branch;
	
	
	                     
	
}
