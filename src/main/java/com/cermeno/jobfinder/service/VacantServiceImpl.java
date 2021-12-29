package com.cermeno.jobfinder.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.cermeno.jobfinder.model.VacantPosition;

@Service
public class VacantServiceImpl implements VacantService {
	private List<VacantPosition> vacants;

	// Returns a list of Vacant objects
	public VacantServiceImpl() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		vacants = new LinkedList<>();
		try {
			// Job offers
			VacantPosition vacant1 = new VacantPosition();
			vacant1.setId(1);
			vacant1.setName("Telecommunication engineer");
			vacant1.setDescription("Needed a telecommunication engineer who supports intranet infraestructure.");
			vacant1.setDate(sdf.parse("27/05/2020"));
			vacant1.setSalary(30000.0);
			vacant1.setHighlighted(true);
			vacant1.setLogo("company1.svg");

			VacantPosition vacant2 = new VacantPosition();
			vacant2.setId(2);
			vacant2.setName("Backend Developer");
			vacant2.setDescription("Needed a Backend Developer who develops and maintains sofware.");
			vacant2.setDate(sdf.parse("25/05/2020"));
			vacant2.setSalary(35000.0);
			vacant2.setHighlighted(false);
			vacant2.setLogo("company2.svg");

			VacantPosition vacant3 = new VacantPosition();
			vacant3.setId(3);
			vacant3.setName("Frontend Developer");
			vacant3.setDescription("Needed a Frontend Developer who develops and maintains web view components.");
			vacant3.setDate(sdf.parse("29/05/2020"));
			vacant3.setSalary(28000.0);
			vacant3.setHighlighted(false);

			VacantPosition vacant4 = new VacantPosition();
			vacant4.setId(4);
			vacant4.setName("Data Architect");
			vacant4.setDescription("Needed a Data Architect who builds the data structure.");
			vacant4.setDate(sdf.parse("01/06/2020"));
			vacant4.setSalary(40000.0);
			vacant4.setHighlighted(true);
			vacant4.setLogo("company4.svg");

			vacants.add(vacant1);
			vacants.add(vacant2);
			vacants.add(vacant3);
			vacants.add(vacant4);
		} catch (ParseException pe) {
			pe.printStackTrace();
		}
	}

	@Override
	public List<VacantPosition> findAll() {
		return vacants;
	}

	@Override
	public Optional<VacantPosition> findById(Integer vacantId) {
		for (VacantPosition vacantPosition : vacants) {
			if (vacantPosition.getId().equals(vacantId)) {
				return Optional.of(vacantPosition);
			}
		}
		return Optional.empty();
	}

	@Override
	public void save(VacantPosition vacant) {
		vacants.add(vacant);
	}
}