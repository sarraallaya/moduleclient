package com.client.module.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.client.module.entity.LigneCommande;


@Repository
public interface LigneCommandeRepository extends JpaRepository<LigneCommande, Integer> {
	
	LigneCommande findByIdAndCommande(Integer id,Integer idCommande);


}