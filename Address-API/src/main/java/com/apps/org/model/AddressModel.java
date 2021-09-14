package com.apps.org.model;

import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("address")
@JsonInclude(Include.NON_NULL)
public class AddressModel {

	@JsonIgnore private boolean isresponseModel;

	public AddressModel() { }

	public AddressModel(boolean isresponseModel) {
		this.isresponseModel = isresponseModel;
	}
	
	@JsonProperty("countryCode") protected Integer countryCode;
	@JsonProperty("country") protected String country;
	
	@JsonProperty("state") protected String state;
	@JsonProperty("stateId") protected Long stateId;
	@JsonProperty("isSpecialState") protected String isSpecialState;
	
	@JsonProperty("cityId") protected Long cityId;
	@JsonProperty("city") protected String city;
	@JsonProperty("isCapital") private String isCapital;
	@JsonProperty("zipCode") @Size(max=6, min=1, message="Please give a valid zip-code") protected Integer zipCode;
	@JsonProperty("stdCode") @Size(max=4, min=1, message="Please give a valid std-code") protected Integer stdCode;
	@JsonProperty("subDivisionCode") protected Long subDivisionCode;


	public Integer getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(Integer countryCode) {
		this.countryCode = countryCode;
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

	public Long getStateId() {
		return stateId;
	}

	public void setStateId(Long stateId) {
		this.stateId = stateId;
	}

	public String getIsSpecial() {
		return isSpecialState;
	}

	public void setIsSpecial(String isSpecial) {
		this.isSpecialState = isSpecial;
	}

	public Long getCityId() {
		return cityId;
	}

	public void setCityId(Long cityId) {
		this.cityId = cityId;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getIsCapital() {
		return isCapital;
	}

	public void setIsCapital(String isCapital) {
		this.isCapital = isCapital;
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

	public Long getSubDivisionCode() {
		return subDivisionCode;
	}

	public void setSubDivisionCode(Long subDivisionCode) {
		this.subDivisionCode = subDivisionCode;
	}

	public boolean isIsresponseModel() {
		return isresponseModel;
	}

	public void setIsresponseModel(boolean isresponseModel) {
		this.isresponseModel = isresponseModel;
	}

}
