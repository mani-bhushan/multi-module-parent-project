package com.apps.org.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("address")
public class AddressIOModel extends AddressModel {

	@JsonIgnore private boolean isresponseModel;
	
	public AddressIOModel () {}
	
	public AddressIOModel (boolean isresponseModel) {
		this.isresponseModel = isresponseModel;
	}
	
	@JsonProperty("addressLine") private String addressLine;
	@JsonProperty("houseNumber") private String houseNumber;
	@JsonProperty("streetName") private String streetName;
	@JsonProperty("lat") private String lat;
	@JsonProperty("lon") private String lon;
	@JsonProperty("isPrimary") private String isPrimary;
	@JsonProperty("telephone") private Long telephone;
	@JsonProperty("mobile") private Long mobile;

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
	
	public String getIsPrimary() {
		return isPrimary;
	}

	public void setIsPrimary(String isPrimary) {
		this.isPrimary = isPrimary;
	}
	
	public Long getTelephone() {
		return telephone;
	}

	public void setTelephone(Long telephone) {
		this.telephone = telephone;
	}


	@Override
	public int hashCode() {
		return Objects.hash(addressLine, streetName, city, state, country, countryCode, stdCode, zipCode);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof AddressIOModel))
			return false;
		AddressIOModel other = (AddressIOModel) obj;
		return  Objects.equals(addressLine, other.addressLine) && Objects.equals(streetName, other.streetName)
				&& Objects.equals(city, other.city) && Objects.equals(state, other.state)
				&& Objects.equals(country, other.country)
				&& Objects.equals(countryCode, other.countryCode) && Objects.equals(zipCode, other.zipCode)
				&& Objects.equals(houseNumber, other.houseNumber)
				&& Objects.equals(lat, other.lat) && Objects.equals(lon, other.lon) 
				&& Objects.equals(mobile, other.mobile) && Objects.equals(telephone, other.telephone)
				&& Objects.equals(isPrimary, other.isPrimary)
				&& Objects.equals(stdCode, other.stdCode);
	}

	@Override
	public String toString() {
		StringBuffer builder = new StringBuffer("Address ")
				.append((isresponseModel) ? "Response :" : "Request :").append(" {\n")
				.append("addressLine=").append(addressLine).append(", houseNumber=").append(houseNumber)
				.append(", streetName=").append(streetName).append(", lat=").append(lat)
				.append(", lon=").append(lon).append(", countryCode=").append(countryCode)
				.append(", mobile=").append(mobile).append(", country=").append(country)
				.append(", state=").append(state).append(", city=").append(city)
				.append(", zipCode=").append(zipCode).append(", isPrimary=").append(isPrimary)
				.append(" }");
		return builder.toString();
	}
		
}
