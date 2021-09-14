package com.apps.org.model.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_NULL)
public class PageResponse {

	@JsonIgnore
	private String currentPage;
	
	@JsonIgnore
	private String totalElements;
	
	@JsonIgnore
	private String totalPages;


	@JsonProperty("errorResponse")
	@JsonInclude(Include.NON_EMPTY)
	private ErrorResponse errorResponse;

	@JsonProperty("employeeResponse")
	@JsonInclude(Include.NON_EMPTY)
	private EmployeeResponse employeeResponse;
	
	@JsonProperty("cityResponse")
	@JsonInclude(Include.NON_EMPTY)
	private CityResponse cityResponse;
	
	
	public EmployeeResponse getEmployeeResponse() {
		return this.employeeResponse;
	}
	
	public void setEmployeeResponse(EmployeeResponse employeeResponse) {
		this.employeeResponse = employeeResponse;
	}

	public ErrorResponse getErrorResponse() { 
		return this.errorResponse; 
	}
	
	public void setErrorResponse(ErrorResponse errorResponse) { 
		this.errorResponse = errorResponse; 
	}
	
	public CityResponse getCityResponse() {
		return cityResponse;
	}

	public void setCityResponse(CityResponse cityResponse) {
		this.cityResponse = cityResponse;
	}

	public String getCurrentPage() {
		return currentPage;
	}
	
	public void setCurrentPage(String currentPage) {
		this.currentPage = currentPage;
	}
	
	public String getTotalElements() {
		return totalElements;
	}
	
	public void setTotalElements(String totalElements) {
		this.totalElements = totalElements;
	}
	
	public String getTotalPages() {
		return totalPages;
	}
	
	public void setTotalPages(String totalPages) {
		this.totalPages = totalPages;
	}

}
