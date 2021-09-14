package com.apps.org.dao;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.apps.org.dao.repositories.CityRepository;
import com.apps.org.dao.repositories.CountryRepository;
import com.apps.org.dao.repositories.StateRepository;
import com.apps.org.entity.City;
import com.apps.org.entity.Country;
import com.apps.org.entity.State;
import com.apps.org.model.AddressModel;
import com.apps.org.model.response.ErrorResponse;

@Component
public class AddressDao {

	@Autowired private CityRepository cityRepository;

	@Autowired private StateRepository satterepository;

	@Autowired private CountryRepository countryRepository;
	
	public void populateEntityRelations(City city, AddressModel requestObj, ErrorResponse errorResponse) {
		
		Set<City> cities = new HashSet<City>();
		Set<State> states = new HashSet<State>();
		
		State state = satterepository.findByStateName(requestObj.getState());
		Country country = countryRepository.findByCountryCode(requestObj.getCountryCode());
		
		if (null != city) {
			
		}
	}

	//create method to check and persist non-existing details
}
