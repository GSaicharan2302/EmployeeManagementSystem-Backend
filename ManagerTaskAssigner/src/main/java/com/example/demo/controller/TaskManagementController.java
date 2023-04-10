package com.example.demo.controller;

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
import org.springframework.web.client.RestTemplate;

import com.example.demo.DTO.TaskEmpDTO;
import com.example.demo.model.EmployeeSTL;
import com.example.demo.model.Task;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.repository.TaskManagementRepo;

@RestController
@RequestMapping("/checktasks")
@CrossOrigin("*")
public class TaskManagementController {
	
	public TaskManagementRepo tmr;
	@Autowired
	public EmployeeRepository er;
	 private RestTemplate restTemplate;

	@Autowired
	public TaskManagementController(TaskManagementRepo tmr) {
		super();
		this.tmr = tmr;
	}
	
	
	@PostMapping("{id}/{eid}")
	public Task createTask(@PathVariable String id,@RequestBody Task t,@PathVariable String eid)
	{
		
		t.managertaskid=id;
		EmployeeSTL e=er.findById(eid).orElseThrow();
		t.empJob=e;
		return tmr.save(t);
		
	}
	
	@GetMapping("{id}")
	public List<TaskEmpDTO> getEmpTask(@PathVariable("id") String id)
	{
	
		return tmr.getTasksInformation(id);
		
		
	}
	
	@PutMapping("{tid}/{value}")
	public Task puttaskstatus(@PathVariable("tid")int tid,@PathVariable("value")String status)
	{
		Task t=tmr.updateTaskStatus(tid);
		t.status=status;
		
		return tmr.save(t) ;
		
	}

}
