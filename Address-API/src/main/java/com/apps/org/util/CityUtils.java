package com.apps.org.util;

import java.util.HashSet;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.apps.org.entity.City;
import com.apps.org.entity.Country;
import com.apps.org.entity.State;
import com.apps.org.model.AddressModel;
import com.apps.org.model.Errors;
import com.apps.org.model.response.CityResponse;
import com.apps.org.model.response.ErrorResponse;

public class CityUtils {

	
	public static City populateCityEntityFromAddressRequest(City city, AddressModel requestObj) {
		if (null == city) {
			city = new City();
			city.setCityName(requestObj.getCity());
			city.setStdCode(requestObj.getStdCode());
			city.setZipCode(requestObj.getZipCode());
			city.setIsCapital(AppConstants.Y.stringValue.equalsIgnoreCase(requestObj.getIsCapital()));
		}
		return city;
	}
	
	public static State populateStateEntity(State state, AddressModel requestObj) {
		if (null == state) {
			state = new State();

			state.setStateName(requestObj.getState());
			state.setIsSpecialState(AppConstants.Y.stringValue.equalsIgnoreCase(requestObj.getIsSpecial()));

			state.setCities(new HashSet<City>());
		}
		return state;
	}
	
	public static Country populateCountryEntity(Country country, AddressModel requestObj) {
		if (null == country) {
			country = new Country();

			country.setCountryCode(requestObj.getCountryCode());
			country.setCountryName(requestObj.getCountry());

			country.setStates(new HashSet<State>());
		}
		return country;
	}

	public static boolean validateNewCityRequest(AddressModel requestObj, ErrorResponse errorResponse) {

		StringBuffer errorData = new StringBuffer();
		if (StringUtils.isBlank(requestObj.getCity())) {
			errorData.append("City Name : Please provide city, ");
		}
		if (StringUtils.isBlank(requestObj.getState())) {

			errorData.append("State Name : Please provide state, ");
		}
		if (StringUtils.isBlank(requestObj.getCountry())) {
			errorData.append("Country Name : Please provide country,");
		}
		if (null == requestObj.getCountryCode()) {
			errorData.append("Country Code : Please provide country code, ");
		}
		if (requestObj.getCountryCode() < AppConstants.ONE.integerValue) {
			errorData.append("Country Code : Please provide country code greater than zero (0), ");
		}
		if (StringUtils.isBlank(requestObj.getIsCapital())) {
			errorData.append("Is Capital : Please provide Y or N, ");
		}
		if (!CommonUtils.isYOrN(requestObj.getIsCapital())) {
			errorData.append("Is Capital : Please provide Y or N, ");
		}
		if (StringUtils.isBlank(requestObj.getIsSpecial())) {
			errorData.append("Is Special : Please provide Y or N, ");
		}
		if (!CommonUtils.isYOrN(requestObj.getIsSpecial())) {
			errorData.append("Is Special : Please provide Y or N, ");
		}
		if (null == requestObj.getZipCode()) {
			errorData.append("Zip Code : Please provide zip-code, ");
		}
		if (requestObj.getZipCode() < AppConstants.ONE.integerValue) {
			errorData.append("Zip Code : Please provide zip-code greater than zero (0), ");
		}

		if(StringUtils.isNotBlank(errorData)) {
			Errors errors = new Errors();
			errors.setErrorCode(AppElements.FIELDS_MISSING.code);
			errors.setMessage(AppElements.FIELDS_MISSING.message + CommonUtils.cleanUpCommas(errorData.toString()));
			errorResponse.add(errors);
			return false;
		}

		return true;
	}

	public static Errors populateErrorResponse(AddressModel requestObj, 
			Integer errorCode,
			String errorMessage, 
			Exception ex) {

		Errors errors = new Errors();
		StringBuffer buffer = new StringBuffer(errorMessage);

		if (null != requestObj) {
			AddressModel modelResponse = populateAddressErrorsInResponseModel(requestObj);
			errors.setCityResponse(modelResponse);
		}
		if (null != ex) {
			buffer.append(ex.getMessage());
			errors.setCause(ex.getCause());
		}
		errors.setErrorCode(errorCode);
		errors.setMessage(buffer.toString());
		
		return errors;
	}

	private static AddressModel populateAddressErrorsInResponseModel(AddressModel requestObj) {
		
		AddressModel cityIOModel = new AddressModel(true);
		cityIOModel.setCity(requestObj.getCity());
		cityIOModel.setState(requestObj.getState());
		cityIOModel.setCountry(requestObj.getCountry());
		
		return cityIOModel;
	}

	public static CityResponse populateCityResponse(List<City> savedCities) {
		CityResponse cityResponse = new CityResponse();
		savedCities.forEach(city -> {
			
			AddressModel cityIOModel = new AddressModel(true);
			
			cityIOModel.setCityId(city.getCityId());
			cityIOModel.setCity(city.getCityName());
			cityIOModel.setIsCapital(city.getIsCapital() ? AppConstants.Y.stringValue : AppConstants.N.stringValue);
			
			cityIOModel.setStateId(city.getState().getStateId());
			cityIOModel.setState(city.getState().getStateName());
			
			cityIOModel.setCountryCode(city.getState().getCountry().getCountryCode());
			cityIOModel.setCountry(city.getState().getCountry().getCountryName());
			
			cityResponse.add(cityIOModel);
			
		});
		return cityResponse;
	}
	
}
