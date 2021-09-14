package com.apps.org.entity;

import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "state")
// @UniqueConstraint(columnNames = {"state_id, country_code"}) 
public class State extends Auditable<String> implements Serializable {

	private static final long serialVersionUID = 4926468583005150704L;
	
	@Id
	@GeneratedValue(generator="gsn_seq")
	@Column(name = "state_id", unique=true, nullable = false)
	private Long stateId;

	@NotNull
	@Column(name = "state_name", nullable=false)
	private String stateName;
	
	@NotNull
	@Column(name = "is_special_State", nullable=false)
	private Boolean isSpecialState;
	
	@ManyToOne 								// Many States can be associated with One Country.
	@JoinColumn(name="country_code", referencedColumnName = "country_code")
	private Country country;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY,mappedBy="state", orphanRemoval = false)		//One State can be associated with multiple cities.
	private Set<City> cities;

	public Long getStateId() {
		return stateId;
	}

	public void setStateId(Long stateId) {
		this.stateId = stateId;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public Set<City> getCities() {
		return cities;
	}

	public void setCities(Set<City> cities) {
		this.cities = cities;
	}

	public Boolean getIsSpecialState() {
		return isSpecialState;
	}

	public void setIsSpecialState(Boolean isSpecialState) {
		this.isSpecialState = isSpecialState;
	}

	@Override
	public int hashCode() {
		return Objects.hash( stateName, isSpecialState );
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof State))
			return false;
		State other = (State) obj;
		return Objects.equals(stateId, other.stateId) && Objects.equals(stateName, other.stateName)
				&& Objects.equals(isSpecialState, other.isSpecialState);
	}

	@Override
	public String toString() {
		StringBuffer builder = new StringBuffer("State { ")
				.append("stateId=").append(stateId).append(", stateName=").append(stateName)
				.append(", isSpecial=").append(isSpecialState)
				.append(", country=").append(country).append(", cities=").append(cities)
				.append(" }");
		return builder.toString();
	}
	
}
