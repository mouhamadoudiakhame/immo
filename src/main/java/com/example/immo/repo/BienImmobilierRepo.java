package com.example.immo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.immo.modeles.BienImmobilier;

public interface BienImmobilierRepo extends JpaRepository<BienImmobilier, Long>{

}
