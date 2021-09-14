package com.apps.org.dao.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apps.org.entity.State;

@Repository
public interface StateRepository extends JpaRepository<State, Long> {

	public State findByStateId(String stateId);

	public State findByStateName(String stateName);

	public Page<State> findAll(Pageable pageable);
}
