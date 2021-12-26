package com.client.module.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.client.module.entity.LigneCommande;
import com.client.module.repository.LigneCommandeRepository;


@Service("ligneCommandeService")
@Transactional
public class LigneCommandeServiceImp implements LigneCommandeService {

	@Autowired
	private LigneCommandeRepository ligneCommandeRepository;
	
	@Override
	public LigneCommande saveLigneCommande(LigneCommande lignecommande) {
		return ligneCommandeRepository.save(lignecommande);
	}
	
	@Override
	public LigneCommande updateLigneCommande(LigneCommande ligneCommande) {
		return ligneCommandeRepository.save(ligneCommande);
	}
	
	@Override
	public void deleteLigneCommande(Integer ligneCommandeId) {
		ligneCommandeRepository.deleteById(ligneCommandeId);
	}


		@Override
		public LigneCommande findLigneCommandeByIdCommande(Integer id,Integer idCommande) {
			return ligneCommandeRepository.findByIdAndCommande(id,idCommande);
		}
	
	
	
}
