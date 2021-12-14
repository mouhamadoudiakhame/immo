package com.example.immo.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.immo.exceptions.MaisonNotFoundException;
import com.example.immo.exceptions.PersonneNotFoundException;
import com.example.immo.modeles.Maison;
import com.example.immo.modeles.Personne;
import com.example.immo.repo.MaisonRepo;
import com.example.immo.repo.PersonneRepo;

@Service
@Transactional
public class ServiceMaison {
	private final MaisonRepo maisonRepo;
	
	@Autowired
	public ServiceMaison(MaisonRepo maisonRepo) {
		this.maisonRepo = maisonRepo;
	}
	
	public Maison ajouterMaison(Maison maison) {
		return maisonRepo.save(maison);
	}
	
	List<Maison> getAllMaisons() {
		return maisonRepo.findAll();
	}
	
	public void supprimerMaison(Long id) {
		maisonRepo.deleteById(id);
	}
	
	public Maison trouverMaisonParId(Long id) {
		return maisonRepo.findById(id)
				.orElseThrow(() -> new MaisonNotFoundException(("Personne avec id " + id + " non trouve !!!")));
	}
}
