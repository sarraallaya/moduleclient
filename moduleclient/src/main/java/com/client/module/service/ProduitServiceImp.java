package com.client.module.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.client.module.entity.Produit;
import com.client.module.repository.ProduitRepository;


@Service("produitService")
@Transactional
public class ProduitServiceImp implements ProduitService {

	@Autowired
	private ProduitRepository produitRepository;
	
	@Override
	public List<Produit> getAllProduits(){
		return produitRepository.findAll();
	}
	
	@Override
	public Optional<Produit>  findProduitById(Integer produitId) {
		return produitRepository.findById(produitId);
	}

	
	@Override
	public Produit saveProduit(Produit produit) {
		return produitRepository.save(produit);
	}
	
	@Override
	public Produit updateProduit(Produit produit) {
		return produitRepository.save(produit);
	}
	
	@Override
	public void deleteProduit(Integer produitId) {
		produitRepository.deleteById(produitId);
	}

	@Override
	public boolean checkIfIdExists(Integer id) {
		return produitRepository.existsById(id);
	}

	@Override
	public List<Produit> findBooksByMarqueOrPartMarque(String marque) {
		return produitRepository.findByMarqueLikeIgnoreCase((new StringBuilder()).append("%").append(marque).append("%").toString());
	}

	@Override
	public Produit findProduitByCode(String code) {
		return produitRepository.findByCodeIgnoreCase(code);
	}

	@Override
	public List<Produit> getProduitsByCategorie(Integer idCategory) {
		return produitRepository.findByCategorie(idCategory);
	}
	
	
}