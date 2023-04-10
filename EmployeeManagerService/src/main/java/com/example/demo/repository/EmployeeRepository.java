package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.EmployeeSTL;

public interface EmployeeRepository extends JpaRepository<EmployeeSTL,String> {
	
	@Query(value="select e.eid from employeestl e where temporaryid =:id",nativeQuery=true)
	public String getpermanentid(@Param("id")int id);

}
