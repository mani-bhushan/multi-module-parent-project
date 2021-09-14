package com.apps.org.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.apps.org.custom.exceptions.handler.CustomExceptionHandler;
import com.apps.org.dao.repositories.EmployeeRepository;
import com.apps.org.entity.Employee;
import com.apps.org.model.EmployeeIOModel;
import com.apps.org.model.Errors;
import com.apps.org.model.request.EmployeeRequest;
import com.apps.org.model.response.EmployeeResponse;
import com.apps.org.model.response.ErrorResponse;
import com.apps.org.model.response.PageResponse;
import com.apps.org.service.EmployeeService;
import com.apps.org.util.AppElements;
import com.apps.org.util.EmployeeUtils;

@Service
@Qualifier("employeeService")
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository repository;

	public PageResponse getAllEmployees(int page, int size) {

		try {
			Pageable paging = PageRequest.of(page, size);
			Page<Employee> employeePage = repository.findAll(paging);
			List<Employee> employees = employeePage.getContent();
			PageResponse pageResponse = EmployeeUtils.populateResponse(employees);
			EmployeeUtils.populateHeaders(pageResponse, employeePage);
			return pageResponse;
		} catch (Exception ex) {
			throw new CustomExceptionHandler(HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST.value(), "Could not find employee", ex.getMessage());
		}

	}

	@Transactional(rollbackOn = Exception.class)
	public PageResponse addNewEmployee(EmployeeRequest employeeRequest) {

		PageResponse pageResponse = new PageResponse();
		pageResponse.setErrorResponse(new ErrorResponse());
		List<Employee> employees = new ArrayList<Employee>();

		for (EmployeeIOModel requestObj : employeeRequest) {
			boolean isValidRequest = EmployeeUtils.validateAddEmployeeRequest(requestObj, pageResponse.getErrorResponse());
			if (isValidRequest) {
				Employee employee =  repository.findByEmpName(requestObj.getEmpName());
				if (null != employee) {
					Errors errors = EmployeeUtils.populateErrorResponse(
							requestObj, AppElements.ALREADY_EXISTING.code, 
							AppElements.ALREADY_EXISTING.message, null);
					pageResponse.getErrorResponse().add(errors);
				} else {
					employee = EmployeeUtils.populateEmployeeEntityFromEmployeeRequest(requestObj);
					employees.add(employee);
				}
			}
		}
		try {
			if (CollectionUtils.isNotEmpty(employees)) {
				List<Employee> savedEmployees = new ArrayList<Employee>();
				employees.forEach(employee -> {
					Employee savedEmployee = repository.saveAndFlush(employee);
					savedEmployees.add(savedEmployee);
				});
				EmployeeResponse employeeResponse = EmployeeUtils.populateEmployeeResponse(savedEmployees);
				pageResponse.setEmployeeResponse(employeeResponse);
			}
		} catch (Exception ex) {
			Errors errors = EmployeeUtils.populateErrorResponse(
					null, AppElements.DB_EXCEPTION.code, 
					AppElements.DB_EXCEPTION.message, ex);
			pageResponse.getErrorResponse().add(errors);
		}
		return pageResponse;
	}

	public Employee getEmployee(Long id) {

		return repository.findById(id)
				.orElseThrow(() -> new CustomExceptionHandler(HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST.value(), "No Employee Found", String.valueOf(id)));
	}

	public PageResponse updateEmployee(EmployeeRequest employeeRequest) {
		PageResponse pageResponse = new PageResponse();
		pageResponse.setErrorResponse(new ErrorResponse());
		List<Employee> employees = new ArrayList<Employee>();


		return null;
	}



}
