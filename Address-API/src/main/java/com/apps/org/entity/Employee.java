package com.apps.org.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.apps.org.entity.generators.EmployeeSequenceIdGenerator;

@Entity
@Table(name = "employee")
public class Employee extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 4926468583005150707L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="emp_seq")
	@GenericGenerator(
			name = "emp_seq", 
			strategy = "com.apps.org.entity.generators.EmployeeSequenceIdGenerator",
		    parameters = {
		    		@Parameter(name = EmployeeSequenceIdGenerator.INCREMENT_PARAM, value = "1"),
		    		@Parameter(name = EmployeeSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "EMP_"),
		    		@Parameter(name = EmployeeSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%05d") })
	@Column(name = "emp_id", unique=true, nullable=false)
	private String empId;
	
	@NotNull
	@Column(name = "emp_name", nullable=false)
	private String empName;
	
	@NotNull
	@Column(name = "birth_date", nullable=false)
	private Date birthDate;
	
	@NotNull
	@Column(name = "hire_date", nullable=false)
	private Date hireDate;	 
		
	@NotNull
	@Column(name = "gender", nullable=false)
	private String gender;
	
	@NotNull
	@Column(name = "designation", nullable=false)
	private String designation;
	
	@NotNull
	@Column(name = "nationality", nullable=false)
	private String nationality;
	
	@NotNull
	@Column(name = "is_active", nullable=false)
	private Boolean isActive;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="employee", fetch = FetchType.LAZY, orphanRemoval = false) 	// One employee can have multiple address.
	private Set<Address> addressList;

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

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public Date getHireDate() {
		return hireDate;
	}

	public void setHireDate(Date hireDate) {
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

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public Set<Address> getAddressList() {
		return addressList;
	}

	public void setAddressList(Set<Address> addressList) {
		this.addressList = addressList;
	}
	
	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	@Override
	public int hashCode() {
		return Objects.hash(birthDate, designation, empId, empName, gender, hireDate, isActive, nationality);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Employee))
			return false;
		Employee other = (Employee) obj;
		return Objects.equals(birthDate, other.birthDate) && Objects.equals(designation, other.designation) 
				&& Objects.equals(empName, other.empName) && Objects.equals(gender, other.gender)
				&& Objects.equals(hireDate, other.hireDate) && Objects.equals(isActive, other.isActive)
				&& Objects.equals(nationality, other.nationality) && Objects.equals(empId, other.empId);
	}

	@Override
	public String toString() {
		StringBuffer builder = new StringBuffer("Employee { ")
				.append("empId=").append(empId).append(", empName=").append(empName)
				.append(", birthDate=").append(birthDate).append(", hireDate=").append(hireDate)
				.append(", gender=").append(gender).append(", designation=").append(designation)
				.append(", isActive=").append(isActive).append(", nationality=").append(nationality)
				.append(", addressList=").append(addressList)
				.append(" }");
		return builder.toString();
		
	}
	

}
