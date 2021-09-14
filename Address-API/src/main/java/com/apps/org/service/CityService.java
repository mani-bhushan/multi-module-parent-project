package com.apps.org.service;

import org.springframework.stereotype.Service;

import com.apps.org.model.request.CityRequest;
import com.apps.org.model.response.PageResponse;

@Service
public interface CityService {
	
	public PageResponse addNewCities (CityRequest cityRequest);

}
