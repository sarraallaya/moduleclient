package com.client.module.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.client.module.entity.Produit;
@Repository
public interface ProduitRepository extends JpaRepository<Produit, Integer> {
	
	Produit findByCodeIgnoreCase(String code);
	
	public List<Produit> findByMarqueLikeIgnoreCase(String marque);
	
	@Query(   "SELECT p "
			+ "FROM Produit p "
			+ "INNER JOIN p.categorie cat "
			+ "WHERE cat.id = :id"
		  )
	public List<Produit> findByCategorie(@Param("id") Integer idCategorie);

}
