package com.client.module.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.client.module.entity.Categorie;

@Repository
public interface CategorieRepository extends JpaRepository<Categorie, Integer>{
	
}
