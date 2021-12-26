package com.client.module.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.client.module.entity.Categorie;

import com.client.module.repository.CategorieRepository;

@Service("categorieService")
public class CategorieServiceImp implements CategorieService {
	

	@Autowired
	private CategorieRepository categorieRepository;
	
	@Override
	public List<Categorie> getAllCategories(){
		return categorieRepository.findAll();
	}
	
	@Override
	public Optional<Categorie>  findCategorieById(Integer categorieId) {
		return categorieRepository.findById(categorieId);
	}


	@Override
	public Categorie saveCategorie(Categorie categorie) {
		return categorieRepository.save(categorie);
	}

	@Override
	public Categorie updateCategorie(Categorie categorie) {
		return categorieRepository.save(categorie);
	}

	@Override
	public void deleteCategorie(Integer categorieId) {
		categorieRepository.deleteById(categorieId);
	}

	@Override
	public boolean checkIfIdexists(Integer id) {
		return categorieRepository.existsById(id);
	}
	




}
