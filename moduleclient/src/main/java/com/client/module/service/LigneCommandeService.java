package com.client.module.service;


import com.client.module.entity.LigneCommande;


public interface LigneCommandeService {
	
	public LigneCommande saveLigneCommande(LigneCommande ligneCommande);
	
	public LigneCommande updateLigneCommande(LigneCommande ligneCommande);
	
	public void deleteLigneCommande(Integer ligneCommande);
	
	public LigneCommande findLigneCommandeByIdCommande(Integer id,Integer idCommande);

}