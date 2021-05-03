package com.cermeno.jobfinder.service;

import java.util.List;
import java.util.Optional;

import com.cermeno.jobfinder.model.VacantPosition;

public interface VacantService {

	List<VacantPosition> findAll();
	
	Optional<VacantPosition> findById(Integer vacantId);
	
	void save(VacantPosition vacant);
}