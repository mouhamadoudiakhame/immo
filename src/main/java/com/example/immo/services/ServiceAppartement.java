package com.example.immo.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.immo.exceptions.AppartementNotFoundException;
import com.example.immo.exceptions.PersonneNotFoundException;
import com.example.immo.modeles.Appartement;
import com.example.immo.modeles.Personne;
import com.example.immo.repo.AppartementRepo;
import com.example.immo.repo.PersonneRepo;

@Service
@Transactional
public class ServiceAppartement {
private final AppartementRepo appartementRepo;
	
	@Autowired
	public ServiceAppartement(AppartementRepo appartementRepo) {
		this.appartementRepo = appartementRepo;
	}
	
	public Appartement ajouterAppartement(Appartement appartement) {
		return appartementRepo.save(appartement);
	}
	
	public List<Appartement> getAllAppartements() {
		return appartementRepo.findAll();
	}
	
	public void supprimerAppartement(Long id) {
		appartementRepo.deleteById(id);
	}
	
	public Appartement trouverAppartementParId(Long id) {
		return appartementRepo.findById(id)
				.orElseThrow(() -> new AppartementNotFoundException(("Appartement avec id " + id + " non trouve !!!")));
	}
}
