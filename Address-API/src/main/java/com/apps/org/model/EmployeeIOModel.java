package com.apps.org.model;

import java.util.List;

import com.apps.org.custom.annotations.Age;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_NULL)
public class EmployeeIOModel {

	@JsonProperty("empId")
	private String empId;
	
	@JsonProperty("empName")
	private String empName;
	
	@JsonProperty("birthDate")
	@Age(value=18)
	private String birthDate;
	
	@JsonProperty("hireDate")
	private String hireDate;
	
	@JsonProperty("gender")
	private String gender;
	
	@JsonProperty("designation")
	private String designation;
	
	@JsonProperty("isActive")
	private String isActive;
	
	@JsonProperty("createdBy")
	private String createdBy;
	
	@JsonProperty("updatedBy")
	private String updatedBy;
	
	@JsonProperty("cretedOn")
	private String cretedOn;
	
	@JsonProperty("updatedOn")
	private String updatedOn;
	
	@JsonProperty("address")
	private List<AddressIOModel> address = null;
	
	@JsonProperty("startDate")
	private String startDate;
	
	@JsonProperty("endDate")
	private String endDate;
	
	@JsonProperty("dueDate")
	private String dueDate;
	
	@JsonProperty("nationality")
	private String nationality;
	
	
	public EmployeeIOModel () {}
	
	public EmployeeIOModel (boolean isresponseModel) {
		this.isresponseModel = isresponseModel;
	}
	
	@JsonIgnore private boolean isresponseModel;

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	@Age(value=18)
	public String getBirthDate() {
		return birthDate;
	}

	@Age(value=18)
	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public String getHireDate() {
		return hireDate;
	}

	public void setHireDate(String hireDate) {
		this.hireDate = hireDate;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public String getCretedOn() {
		return cretedOn;
	}

	public void setCretedOn(String cretedOn) {
		this.cretedOn = cretedOn;
	}

	public String getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(String updatedOn) {
		this.updatedOn = updatedOn;
	}

	public List<AddressIOModel> getAddress() {
		return address;
	}

	public void setAddress(List<AddressIOModel> address) {
		this.address = address;
	}
	
	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getDueDate() {
		return dueDate;
	}

	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}
	
	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	@Override
	public String toString() {

		StringBuffer buffer = new StringBuffer("Employee ")
				.append((isresponseModel) ? "Response :" : "Request :").append(" {\n")
				.append("EmployeeId: ").append(this.empId).append(",/n")
				.append("EmployeeName: ").append(this.empName).append(",/n")
				.append("BirthDate: ").append(this.birthDate).append(",/n")
				.append("HireDate: ").append(this.hireDate).append(",/n")
				.append("Gender: ").append(this.gender).append(",/n")
				.append("Designation: ").append(this.designation)
				.append("/n }");

		return buffer.toString();
	}


}
