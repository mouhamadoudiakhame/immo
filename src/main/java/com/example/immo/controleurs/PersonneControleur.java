package com.example.immo.controleurs;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.immo.modeles.Personne;
import com.example.immo.services.ServicePersonne;

@RestController
@RequestMapping("/personnes")
public class PersonneControleur {
	private final ServicePersonne servicePersonne;
	
	public PersonneControleur(ServicePersonne servicePersonne) {
		this.servicePersonne = servicePersonne;
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Personne>> getAllPersonnes() {
		List<Personne> personnes = servicePersonne.getAllPersonnes();
		return new ResponseEntity<List<Personne>>(personnes, HttpStatus.OK);
		
	}
	
	@GetMapping("/chercher/{id}")
	public ResponseEntity<Personne> chercherPersonneParId(@PathVariable("id") Long id) {
		Personne personne = servicePersonne.trouverPersonneParId(id);
		return new ResponseEntity<Personne>(personne, HttpStatus.OK);
	}
	
	@DeleteMapping("/supprimer/{id}")
	public ResponseEntity<Personne> supprimerPersonneParId(@PathVariable("id") Long id) {
		servicePersonne.supprimerPersonne(id);
		return new ResponseEntity<Personne>(HttpStatus.OK);
	}
	
	@PostMapping("/ajouter")
	public ResponseEntity<Personne> ajouterUnePersonne(@RequestBody Personne personne) {
		Personne newPersonne = servicePersonne.ajouterPersonne(personne);
		return new ResponseEntity<Personne>(newPersonne, HttpStatus.CREATED);
	}
	
	@PutMapping("/miseajour")
	public ResponseEntity<Personne> mettreAJourUnePersonne(@RequestBody Personne personne) {
		Personne updatedPersonne = servicePersonne.ajouterPersonne(personne);
		return new ResponseEntity<Personne>(updatedPersonne, HttpStatus.OK);
	}
}
