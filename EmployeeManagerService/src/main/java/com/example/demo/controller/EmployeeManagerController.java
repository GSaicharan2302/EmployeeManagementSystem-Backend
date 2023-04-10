package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.DTO.EmployeeDTO;
import com.example.demo.model.DemoEmployee;
import com.example.demo.model.EmployeeSTL;
import com.example.demo.model.ManagerSTL;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.repository.ManagerRepository;
import com.example.demo.repository.RegisterEmployeeRepo;

@RestController
@RequestMapping("/employeemanagerservice")
@CrossOrigin("*")
public class EmployeeManagerController {
	@Autowired
	public EmployeeManagerController(ManagerRepository mr) {
		super();
		this.mr = mr;
		
	}

	public ManagerRepository mr;
	
	@Autowired
	public EmployeeRepository er;
	@Autowired
	public RegisterEmployeeRepo rer;
	
	@PostMapping("registeremployees")
	public DemoEmployee createEmployee(@RequestBody DemoEmployee emp)
	{
		return rer.save(emp);
		
	}
	@GetMapping("displayemployee/{id}")
	public DemoEmployee displayEmployeebyid(@PathVariable int id)
	{
		return rer.findById(id).orElseThrow();
	}
	@GetMapping("displayemployees")
	public List<DemoEmployee> displayAllRegisteredemployees()
	{
		return rer.findAll();
		
	}
	@PostMapping("{id}")
	public EmployeeSTL createEmployee(@RequestBody EmployeeSTL e,@PathVariable int id)
	{
		DemoEmployee temp=rer.findById(id).orElseThrow();
		e.ename=temp.name;
		return er.save(e);
		
	}
//	
	@GetMapping()
	public List<DemoEmployee> getListOfEmployees()
	{
		return rer.findAll();
		
	}
//	
	@GetMapping("{id}")
	public List<EmployeeDTO> getEmployee(@PathVariable String id)
	{
		List<Object[]> o=mr.getEmployeeInformation(id);
		List<EmployeeDTO> list=new ArrayList<EmployeeDTO>();
		for(Object[] i:o)
		{
			String eid=(String) i[0];
			String name=(String) i[1];
			EmployeeDTO empdto=new EmployeeDTO(eid,name);
			list.add(empdto);
		}
		return list;
		
	}
	
	@GetMapping("/getpermanentid/{id}")
	public String getpermemployeeid(@PathVariable int id)
	{
		return er.getpermanentid(id);
	}
//	
	
}
