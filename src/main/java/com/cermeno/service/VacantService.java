package com.cermeno.service;

import java.util.List;
import java.util.Optional;

import com.cermeno.model.VacantPosition;

public interface VacantService {

	List<VacantPosition> findAll();
	
	Optional<VacantPosition> findById(Integer vacantId);
	
	void save(VacantPosition vacant);
}