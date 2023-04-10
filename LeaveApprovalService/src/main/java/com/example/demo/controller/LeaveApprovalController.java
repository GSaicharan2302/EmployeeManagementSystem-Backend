package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.DTO.LeaveViewEmpListManager;
import com.example.demo.DTO.LeaveViewEmployee;
import com.example.demo.model.EmployeeSTL;
import com.example.demo.model.LeaveApprovalTeam;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.repository.LeaveApprovalRepository;

@RestController
@RequestMapping("/leaveApproval")
@CrossOrigin("*")
public class LeaveApprovalController {
	
	public LeaveApprovalRepository lar;
	@Autowired
	public EmployeeRepository er;
	@Autowired
	public LeaveApprovalController(LeaveApprovalRepository lar) {
		super();
		this.lar = lar;
	}

	@PostMapping("{eid}")
	public LeaveApprovalTeam createLeaveRequest(@PathVariable String eid,@RequestBody LeaveApprovalTeam l)
	{
		EmployeeSTL e=er.findById(eid).orElseThrow();
		l.status="pending";
		l.empLeave=e;
		return lar.save(l);
		
	}
	
	@GetMapping("checkstatus/{eid}")
	public List<LeaveViewEmployee> getLeaveStatus(@PathVariable String eid)
	{
		List<Object[]> l=lar.getLeaveStatus(eid);
		List<LeaveViewEmployee> li=new ArrayList<LeaveViewEmployee>();
		for(Object[] i:l)
		{
			String name=(String)i[0];
			String fdate=(String)i[1];
			String tdate=(String)i[2];
			String type=(String)i[3];
			String status=(String)i[4];
			LeaveViewEmployee lv=new LeaveViewEmployee(name,fdate,tdate,type,status);
			li.add(lv);
		}
		return li;
		
		
	}
	@GetMapping("getemplist/{mid}")
	public List<LeaveViewEmpListManager> getEmployeeList(@PathVariable String mid)
	{
		List<LeaveViewEmpListManager> lve=new ArrayList<LeaveViewEmpListManager>();
		
		List<Object[]> listEmp=lar.getEmployeeListByManager(mid);
		for(Object[] o : listEmp)
		{
			int id=(Integer)o[0];
			String emp_id=(String)o[1];
			String from_date=(String)o[2];
			String to_date=(String)o[3];
			String type=(String)o[4];
			String status=(String)o[5];
			LeaveViewEmpListManager lemplist=new LeaveViewEmpListManager(id,emp_id,from_date,to_date,type,status);
			lve.add(lemplist);
		}
		return lve;
	}
	@PutMapping("{mid}/{eid}/{lid}/{value}")
	public LeaveApprovalTeam updateLeave(@PathVariable String mid,@PathVariable String eid,@PathVariable String value,@PathVariable int lid)
	{
		
		EmployeeSTL e=er.findById(eid).orElseThrow();
		LeaveApprovalTeam l=lar.updateLeaveStatus(lid);
		l.status=value;
		return lar.save(l);
		
		
	}
	@GetMapping("/getleavestatus/{eid}")
	public List<Object[]> setLeaveStatus(@PathVariable String eid)
	{
		return lar.getLeaveStatus(eid);
	}
}
