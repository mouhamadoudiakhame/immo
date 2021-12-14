package com.example.immo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.immo.modeles.Maison;

public interface MaisonRepo extends JpaRepository<Maison, Long>{

}
