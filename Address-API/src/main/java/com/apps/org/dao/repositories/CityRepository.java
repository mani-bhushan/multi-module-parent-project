package com.apps.org.dao.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apps.org.entity.City;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {
	
	public City findByCityId(String cityId);
	
	public City findByCityName(String cityName);
	
	public Page<City> findAll(Pageable pageable);

}
