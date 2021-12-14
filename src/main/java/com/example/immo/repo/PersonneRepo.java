package com.example.immo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.immo.modeles.Personne;

public interface PersonneRepo extends JpaRepository<Personne, Long>{

}
