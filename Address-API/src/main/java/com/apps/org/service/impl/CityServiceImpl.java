package com.apps.org.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.apps.org.dao.repositories.CityRepository;
import com.apps.org.dao.repositories.CountryRepository;
import com.apps.org.dao.repositories.StateRepository;
import com.apps.org.entity.City;
import com.apps.org.entity.Country;
import com.apps.org.entity.State;
import com.apps.org.model.AddressModel;
import com.apps.org.model.Errors;
import com.apps.org.model.request.CityRequest;
import com.apps.org.model.response.CityResponse;
import com.apps.org.model.response.ErrorResponse;
import com.apps.org.model.response.PageResponse;
import com.apps.org.service.CityService;
import com.apps.org.util.AppElements;
import com.apps.org.util.CityUtils;
import com.apps.org.util.EmployeeUtils;

@Service
@Qualifier("cityService")
public class CityServiceImpl implements CityService {

	@Autowired private CityRepository cityRepository;

	@Autowired private StateRepository stateRepository;

	@Autowired private CountryRepository countryRepository;
	
	//@Autowired private AddressDao addressDao;

	@Transactional(rollbackOn = Exception.class) //{Exception.class, CustomExceptionHandler.class})
	public PageResponse addNewCities(CityRequest cityRequest) {

		PageResponse pageResponse = new PageResponse();
		pageResponse.setErrorResponse(new ErrorResponse());
		List<City> cities = new ArrayList<City>();

		for (AddressModel requestObj : cityRequest) {
			boolean isValidRequest = CityUtils.validateNewCityRequest(requestObj, pageResponse.getErrorResponse());

			if (isValidRequest) {
				try {

					City city = cityRepository.findByCityName(requestObj.getCity());
					if (null != city) {
						Errors errors = CityUtils.populateErrorResponse(requestObj,
								AppElements.ALREADY_EXISTING.code,
								AppElements.ALREADY_EXISTING.message, null);
						pageResponse.getErrorResponse().add(errors);

					} else {


						Country country = countryRepository.findByCountryCode(requestObj.getCountryCode());
						State state = stateRepository.findByStateName(requestObj.getState());

						country = CityUtils.populateCountryEntity(country, requestObj);
						state = CityUtils.populateStateEntity(state, requestObj);
						city = CityUtils.populateCityEntityFromAddressRequest(city, requestObj);
						
						city.setState(state);
						state.setCountry(country);
						state.getCities().add(city);
						country.getStates().add(state);

						countryRepository.saveAndFlush(country);
						cities.add(city);
					}

				} catch (Exception ex) {
					Errors errors = EmployeeUtils.populateErrorResponse(null, AppElements.DB_EXCEPTION.code,
							AppElements.DB_EXCEPTION.message, ex);
					pageResponse.getErrorResponse().add(errors);
					ex.printStackTrace();
				}
			}
		}

		CityResponse cityResponse = CityUtils.populateCityResponse(cities);
		pageResponse.setCityResponse(cityResponse);
		return pageResponse;
	}
}
