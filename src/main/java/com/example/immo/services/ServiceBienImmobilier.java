package com.example.immo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.immo.exceptions.BienImmobilierNotFoundException;
import com.example.immo.exceptions.PersonneNotFoundException;
import com.example.immo.modeles.BienImmobilier;
import com.example.immo.modeles.Personne;
import com.example.immo.repo.BienImmobilierRepo;

public class ServiceBienImmobilier {
	private final BienImmobilierRepo bienImmobilierRepo;
	
	@Autowired
	public ServiceBienImmobilier(BienImmobilierRepo bienImmobilierRepo) {
		this.bienImmobilierRepo = bienImmobilierRepo;
	}
	
	public BienImmobilier ajouterBienImmobilier(BienImmobilier personne) {
		return bienImmobilierRepo.save(personne);
	}
	
	List<BienImmobilier> getAllPersonnes() {
		return bienImmobilierRepo.findAll();
	}
	
	public void supprimerPersonne(Long id) {
		bienImmobilierRepo.deleteById(id);
	}
	
	public BienImmobilier trouverPersonneParId(Long id) {
		return bienImmobilierRepo.findById(id)
				.orElseThrow(() -> new BienImmobilierNotFoundException(("BienImmobilier avec id " + id + " non trouve !!!")));
	}
}
