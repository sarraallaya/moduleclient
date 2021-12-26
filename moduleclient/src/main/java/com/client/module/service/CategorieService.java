package com.client.module.service;

import java.util.List;
import java.util.Optional;

import com.client.module.entity.Categorie;


public interface CategorieService {
	
	public List<Categorie> getAllCategories();
	public  Optional<Categorie>  findCategorieById(Integer categorieId);
	
	public Categorie saveCategorie(Categorie categorie);

	public Categorie updateCategorie(Categorie categorie);

	public void deleteCategorie(Integer categorieId);
	
	public boolean checkIfIdexists(Integer id);

}
