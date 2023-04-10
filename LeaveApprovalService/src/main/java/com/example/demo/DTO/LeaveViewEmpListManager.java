package com.example.demo.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor

@Data
public class LeaveViewEmpListManager {
	public int getLid() {
		return lid;
	}
	public void setLid(int lid) {
		this.lid = lid;
	}
	int lid;
	String emp_id;
	String from_date;
	String to_date;
	String type;
	String status;
	public LeaveViewEmpListManager(int id,String emp_id2, String from_date2, String to_date2, String type2, String status2) {
		// TODO Auto-generated constructor stub
		this.lid=id;
		this.emp_id=emp_id2;
		this.from_date=from_date2;
		this.to_date=to_date2;
		this.type=type2;
		this.status=status2;
	}
	public String getEmp_id() {
		return emp_id;
	}
	public void setEmp_id(String emp_id) {
		this.emp_id = emp_id;
	}
	public String getFrom_date() {
		return from_date;
	}
	public void setFrom_date(String from_date) {
		this.from_date = from_date;
	}
	public String getTo_date() {
		return to_date;
	}
	public void setTo_date(String to_date) {
		this.to_date = to_date;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	

}
