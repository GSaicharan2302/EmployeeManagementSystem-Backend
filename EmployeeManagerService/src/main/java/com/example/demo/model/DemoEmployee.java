package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class DemoEmployee {
	@Id
	@GeneratedValue
	public int id;
	@Column
	public String name;
	@Column
	public String dob;
	@Column
	public String currentaddress;
	@Column
	public String permanentaddress;
	@Column
	public String contactno;
	
	

}
