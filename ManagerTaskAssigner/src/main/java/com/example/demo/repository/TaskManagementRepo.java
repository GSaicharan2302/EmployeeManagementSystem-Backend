package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.DTO.TaskEmpDTO;
import com.example.demo.model.Task;

public interface TaskManagementRepo extends JpaRepository<Task,Integer> {
	@Query("select new com.example.demo.DTO.TaskEmpDTO(e.eid,e.ename,t.taskname,t.status) from Task t inner join t.empJob e where e.eid =:id" )
	public List<TaskEmpDTO> getTasksInformation(@Param("id") String eid);
	
	@Query(value="select * from task where taskid =:tid",nativeQuery=true)
	public Task updateTaskStatus(@Param("tid")int taskid);
	
	

}
