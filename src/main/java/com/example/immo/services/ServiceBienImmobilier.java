package com.example.immo.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.immo.exceptions.BienImmobilierNotFoundException;
import com.example.immo.exceptions.PersonneNotFoundException;
import com.example.immo.modeles.BienImmobilier;
import com.example.immo.modeles.Personne;
import com.example.immo.repo.BienImmobilierRepo;

@Service
@Transactional
public class ServiceBienImmobilier {
	private final BienImmobilierRepo bienImmobilierRepo;
	
	@Autowired
	public ServiceBienImmobilier(BienImmobilierRepo bienImmobilierRepo) {
		this.bienImmobilierRepo = bienImmobilierRepo;
	}
	
	public BienImmobilier ajouterBienImmobilier(BienImmobilier personne) {
		return bienImmobilierRepo.save(personne);
	}
	
	public List<BienImmobilier> getAllBienImmobiliers() {
		return bienImmobilierRepo.findAll();
	}
	
	public void supprimerBienImmobilier(Long id) {
		bienImmobilierRepo.deleteById(id);
	}
	
	public BienImmobilier trouverBienImmobilierParId(Long id) {
		return bienImmobilierRepo.findById(id)
				.orElseThrow(() -> new BienImmobilierNotFoundException(("BienImmobilier avec id " + id + " non trouve !!!")));
	}
}
