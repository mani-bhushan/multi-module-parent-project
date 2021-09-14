package com.apps.org.dao.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apps.org.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	public Employee findByEmpId(String empId);
	
	public Employee findByEmpName(String empName);
	
	public Page<Employee> findAll(Pageable pageable);

	//public Iterable<Employee> saveAndFlush(List<Employee> employees);
	
}