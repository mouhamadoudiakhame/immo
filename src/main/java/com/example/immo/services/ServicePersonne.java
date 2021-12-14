package com.example.immo.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.immo.exceptions.PersonneNotFoundException;
import com.example.immo.modeles.Personne;
import com.example.immo.repo.PersonneRepo;

@Service
@Transactional
public class ServicePersonne {
	private final PersonneRepo personneRepo;
	
	@Autowired
	public ServicePersonne(PersonneRepo personneRepo) {
		this.personneRepo = personneRepo;
	}
	
	public Personne ajouterPersonne(Personne personne) {
		return personneRepo.save(personne);
	}
	
	List<Personne> getAllPersonnes() {
		return personneRepo.findAll();
	}
	
	public void supprimerPersonne(Long id) {
		personneRepo.deleteById(id);
	}
	
	public Personne trouverPersonneParId(Long id) {
		return personneRepo.findById(id)
				.orElseThrow(() -> new PersonneNotFoundException(("Personne avec id " + id + " non trouve !!!")));
	}
	
}
