package com.apps.org.dao.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apps.org.entity.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, String> {

	public Country findByCountryCode(Integer countryCode);

	public Country findByCountryName(String countryName);

	public Page<Country> findAll(Pageable pageable);
}
