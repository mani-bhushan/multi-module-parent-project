package com.apps.org.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "address", uniqueConstraints = @UniqueConstraint(columnNames = {"address_id"}) )
public class Address extends Auditable<String> implements Serializable {

	private static final long serialVersionUID = 4926468583005150702L;
	
	@Id
	@GeneratedValue(generator="gsn_seq")
	@Column(name = "address_id", unique=true, nullable = false)
	private Long addressId;
	
	@NotNull
	@Column(name = "address_line", nullable = false)
	private String addressLine;
	
	@Column(name = "house_number")
	private String houseNumber;
	
	@Column(name = "street_name", nullable = false)
	private String streetName;
	
	@NotNull
	@Column(name = "country", nullable = false)
	private String country;
	
	@NotNull
	@Column(name = "state", nullable = false)
	private String state;
	
	@NotNull
	@Column(name = "city", nullable = false)
	private String city;

	@NotNull
	@Column(name = "country_code", nullable = false)
	private Integer countryCode;
	
	@NotNull
	@Column(name = "zip_code", nullable = false)
	private Integer zipCode;
	
	@Column(name = "mobile", nullable = false)
	private Long mobile;
	
	@Column(name = "std_code")
	private Integer stdCode;
	
	@Column(name = "telephone")
	private Long telephone;
	
	@Column(name = "lat")
	private String lat;
	
	@Column(name = "lon")
	private String lon;
	
	@NotNull
	//@DefaultY
	@Column(name = "is_primary", nullable = false)
	private Boolean isPrimary;
	
	@ManyToOne 	//Many address can be associated with One employee
	@JoinColumn(name="emp_id", referencedColumnName = "emp_id")
	private Employee employee;
	

	public Long getAddressId() {
		return addressId;
	}

	public void setAddressId(Long addressId) {
		this.addressId = addressId;
	}

	public String getAddressLine() {
		return addressLine;
	}

	public void setAddressLine(String addressLine) {
		this.addressLine = addressLine;
	}

	public String getHouseNumber() {
		return houseNumber;
	}

	public void setHouseNumber(String houseNumber) {
		this.houseNumber = houseNumber;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public String getLat() {
		return lat;
	}

	public void setLat(String lat) {
		this.lat = lat;
	}

	public String getLon() {
		return lon;
	}

	public void setLon(String lon) {
		this.lon = lon;
	}

	public Long getMobile() {
		return mobile;
	}

	public void setMobile(Long mobile) {
		this.mobile = mobile;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	public Boolean getIsPrimary() {
		return isPrimary;
	}

	public void setIsPrimary(Boolean isPrimary) {
		this.isPrimary = isPrimary;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Integer getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(Integer countryCode) {
		this.countryCode = countryCode;
	}

	public Integer getZipCode() {
		return zipCode;
	}

	public void setZipCode(Integer zipCode) {
		this.zipCode = zipCode;
	}

	public Integer getStdCode() {
		return stdCode;
	}

	public void setStdCode(Integer stdCode) {
		this.stdCode = stdCode;
	}

	public Long getTelephone() {
		return telephone;
	}

	public void setTelephone(Long telephone) {
		this.telephone = telephone;
	}

	@Override
	public int hashCode() {
		return Objects.hash(addressId, addressLine, streetName, city, state, country, countryCode, zipCode);
	}
	
	

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Address))
			return false;
		Address other = (Address) obj;
		return  Objects.equals(addressLine, other.addressLine)
				&& Objects.equals(isPrimary, other.isPrimary) && Objects.equals(houseNumber, other.houseNumber)
				&& Objects.equals(mobile, other.mobile) && Objects.equals(streetName, other.streetName)
				&& Objects.equals(city, other.city) && Objects.equals(state, other.state)
				&& Objects.equals(country, other.country) && Objects.equals(countryCode, other.countryCode)
				&& Objects.equals(zipCode, other.zipCode);
	}

	@Override
	public String toString() {
		StringBuffer buffer = new StringBuffer("Address { ")
				.append("addressId=").append(addressId).append(", addressLine=").append(addressLine)
				.append(", houseNumber=").append(houseNumber).append(", streetName=").append(streetName)
				.append(", lat=").append(lat).append(", lon=").append(lon).append(", mobile=").append(mobile)
				.append(", employee=").append(employee).append(", isPrimary=").append(isPrimary)
				.append(", state=").append(state).append(", city=").append(city).append(", country=").append(country)
				.append(", stdCode=").append(stdCode).append(", telephone=").append(telephone)
				.append(" }");
		return buffer.toString();
	}

}
