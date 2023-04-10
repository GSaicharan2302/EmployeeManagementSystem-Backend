package com.example.demo.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LeaveViewEmployee {

	
	
		String employee_name;
		String from_date;
		String to_date;
		String type;
		String status;
		public LeaveViewEmployee(String employee_name, String from_date, String to_date, String type, String status) {
			super();
			this.employee_name = employee_name;
			this.from_date = from_date;
			this.to_date = to_date;
			this.type = type;
			this.status = status;
		}
		public String getEmployee_name() {
			return employee_name;
		}
		public void setEmployee_name(String employee_name) {
			this.employee_name = employee_name;
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
