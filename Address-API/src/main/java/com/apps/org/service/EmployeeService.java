package com.apps.org.service;

import org.springframework.stereotype.Service;

import com.apps.org.entity.Employee;
import com.apps.org.model.request.EmployeeRequest;
import com.apps.org.model.response.PageResponse;

@Service
public interface EmployeeService {
	
	public PageResponse getAllEmployees(int page, int size);
	public PageResponse addNewEmployee(EmployeeRequest employeeRequest);
	public Employee getEmployee(Long id);
	public PageResponse updateEmployee(EmployeeRequest employeeRequest);

}
