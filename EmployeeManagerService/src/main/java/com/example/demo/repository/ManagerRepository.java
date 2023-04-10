package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.DTO.EmployeeDTO;
import com.example.demo.model.EmployeeSTL;
import com.example.demo.model.ManagerSTL;

public interface ManagerRepository extends JpaRepository<ManagerSTL,String>{
	
//	@Query("select new com.example.demo.DTO.EmployeeDTO(e.eid,e.ename) from ManagerSTL m  inner join m.employees e where m.mid =:id")
//	public List<EmployeeDTO> getEmployeeInformation(@Param("id")String id);
	
	@Query(value="select e.eid,e.ename from employeestl e inner join managerstl m on e.manager_id=m.mid where m.mid =:id ",nativeQuery=true)
	public List<Object[]> getEmployeeInformation(@Param("id")String id);
}
