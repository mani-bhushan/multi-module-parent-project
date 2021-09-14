package com.apps.org.dao.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.apps.org.entity.DAOUser;

@Repository
public interface UserRepository extends CrudRepository<DAOUser, Integer> {
	public DAOUser findByName(String name);
	
	public DAOUser findByEmail(String email);
}