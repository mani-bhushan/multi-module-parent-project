package com.apps.org.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apps.org.model.request.CityRequest;
import com.apps.org.model.response.PageResponse;
import com.apps.org.service.CityService;


@CrossOrigin
@RestController
@RequestMapping("/api/v3")
public class CityController {

	
	@Autowired
	CityService cityService;
	
	public ResponseEntity<?> getCities(Long cityId) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@PostMapping("/cities")
	public ResponseEntity<?> addNewCities (
			@RequestBody @Valid CityRequest cityRequest) {
		
		try {
			PageResponse response = cityService.addNewCities(cityRequest);
			return new ResponseEntity<PageResponse>(response, HttpStatus.CREATED);
		} catch (Exception ex) {
			return new ResponseEntity<>(ex.getCause(), HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

}
