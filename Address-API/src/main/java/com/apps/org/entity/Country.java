package com.apps.org.entity;

import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "country", uniqueConstraints = @UniqueConstraint(columnNames = {"country_code"}) )
public class Country extends Auditable<String> implements Serializable {

	private static final long serialVersionUID = 4926468583005150703L;
		
	@Id
	@NotNull
	@Column(name = "country_code", unique=true, nullable=false)
	private Integer countryCode;
	
	@NotNull
	@Column(name = "country_name", unique=true, nullable=false)
	private String countryName;
	
//	@NotNull
//	@Column(name = "origin_name", unique=true, nullable=false)
//	private String originName;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy="country", orphanRemoval = false)
	private Set<State> states;


	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public Integer getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(Integer countryCode) {
		this.countryCode = countryCode;
	}

//	public String getOriginName() {
//		return originName;
//	}
//
//	public void setOriginName(String originName) {
//		this.originName = originName;
//	}

	public Set<State> getStates() {
		return states;
	}

	public void setStates(Set<State> states) {
		this.states = states;
	}

	@Override
	public int hashCode() {
		return Objects.hash(countryCode, countryName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Country))
			return false;
		Country other = (Country) obj;
		return Objects.equals(countryCode, other.countryCode) && Objects.equals(countryName, other.countryName)
				//&& Objects.equals(originName, other.originName)
				;
	}

	@Override
	public String toString() {
		StringBuffer builder = new StringBuffer("Country { ")
				.append("countryName=").append(countryName).append(", countryCode=").append(countryCode)
				//.append(", originName=").append(originName)
				.append(" }");
		return builder.toString();
	}

	
	
}
