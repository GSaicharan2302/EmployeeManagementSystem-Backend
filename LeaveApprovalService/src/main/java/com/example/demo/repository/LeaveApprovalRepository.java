package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.DTO.LeaveViewEmployee;
import com.example.demo.model.LeaveApprovalTeam;

public interface LeaveApprovalRepository extends JpaRepository<LeaveApprovalTeam,Integer> {
	@Query(value="select l.status,e.ename from leave_approval_team l inner join employeestl e on l.emp_id=e.eid where e.eid =:id ",nativeQuery=true)
	public List<Object[]> getstatusinfo(@Param("id")String eid);
	@Query(value="select l.id from leave_approval_team l inner join employeestl e on l.emp_id=e.eid where e.eid =:eid",nativeQuery=true)
	public int getleaveid(@Param("eid") String eid);
	
	@Query(value="select l.emp_id,e.ename,l.status from leave_approval_team l inner join employeestl e on l.emp_id=e.eid where e.manager_id =:mid",nativeQuery=true)
	public List<Object[]> getEmployeeList(@Param("mid") String mid);
	
	@Query(value="select * from leave_approval_team l where l.id =:id",nativeQuery=true)
	public LeaveApprovalTeam updateLeaveStatus(@Param("id")int id);
	
	@Query(value="select e.ename,l.from_date,l.to_date,l.type,l.status from leave_approval_team l inner join employeestl e on l.emp_id=e.eid where e.eid =:eid",nativeQuery=true)
	public List<Object[]> getLeaveStatus(@Param("eid")String eid);
	
	@Query(value="select l.id,l.emp_id,l.from_date,l.to_date,l.type,l.status from leave_approval_team l inner join employeestl e on l.emp_id=e.eid where e.manager_id =:mid",nativeQuery=true)
	public List<Object[]> getEmployeeListByManager(@Param("mid")String mid);
	
	
	

}
