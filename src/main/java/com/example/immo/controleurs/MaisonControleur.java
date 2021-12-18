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

import com.example.immo.modeles.Maison;
import com.example.immo.services.ServiceMaison;
import com.example.immo.services.ServicePersonne;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/maisons")
public class MaisonControleur {
	private final ServiceMaison serviceMaison;
	private final ServicePersonne servicePersonne;
	
	public MaisonControleur(ServiceMaison serviceMaison, ServicePersonne servicePersonne) {
		this.serviceMaison = serviceMaison;
		this.servicePersonne = servicePersonne;
	}
	
	@ApiOperation(value = "Recupere tous les rendez-vous!")
	@GetMapping("/all")
	public ResponseEntity<List<Maison>> getAllMaisons() {
		List<Maison> maisons = serviceMaison.getAllMaisons();
		return new ResponseEntity<List<Maison>>(maisons, HttpStatus.OK);
		
	}
	
	@GetMapping("/chercher/{id}")
	public ResponseEntity<Maison> chercherMaisonParId(@PathVariable("id") Long id) {
		Maison maison = serviceMaison.trouverMaisonParId(id);
		return new ResponseEntity<Maison>(maison, HttpStatus.OK);
	}
	
	@DeleteMapping("/supprimer/{id}")
	public ResponseEntity<Maison> supprimerMaisonParId(@PathVariable("id") Long id) {
		serviceMaison.supprimerMaison(id);
		return new ResponseEntity<Maison>(HttpStatus.OK);
	}
	
	@PostMapping("/ajouter")
	public ResponseEntity<Maison> ajouterUneMaison(@RequestBody Maison maison) {
		maison.setImageUrl("https://dakarvente.com/media/annonces/pics/8ae57d756b2f11cea3f992411286755c.jpg");
		Maison newMaison = serviceMaison.ajouterMaison(maison);
		return new ResponseEntity<Maison>(newMaison, HttpStatus.CREATED);
	}
	
	@PutMapping("/miseajour")
	public ResponseEntity<Maison> mettreAJourUneMaison(@RequestBody Maison maison) {
		Maison m =  serviceMaison.trouverMaisonParId(maison.getId_bien_immobilier());
		m.setLibelle(maison.getLibelle());
		m.setAdresse(maison.getAdresse());
		m.setDescription(maison.getDescription());
		m.setPrix(maison.getPrix());
		m.setSurface(maison.getSurface());
		m.setIdPersonne(maison.getIdPersonne()) ;
		System.out.println("==== : " + m.getIdPersonne());
		serviceMaison.ajouterMaison(m);
		return new ResponseEntity<Maison>(m, HttpStatus.OK);

	}
}


