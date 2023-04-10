package com.example.demo.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class EmployeeDTO {
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	String name;
	String id;

	public EmployeeDTO(String id,String name) {
		super();
		this.name = name;
		this.id=id;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
