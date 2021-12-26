package com.client.module.service;

import java.util.List;
import java.util.Optional;


import com.client.module.entity.Produit;

public interface ProduitService {
	public List<Produit> getAllProduits();
	public  Optional<Produit> findProduitById(Integer categorieId);
	
	public Produit saveProduit(Produit produit);
	
	public Produit updateProduit(Produit produit);
	
	public void deleteProduit(Integer produit);
	
	public List<Produit> findBooksByMarqueOrPartMarque(String marque);
	
	public Produit findProduitByCode(String code);
	
	public boolean checkIfIdExists(Integer id);
	
	public List<Produit> getProduitsByCategorie(Integer idCategorie);

}
