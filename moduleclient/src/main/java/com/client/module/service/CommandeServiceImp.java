package com.client.module.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.client.module.entity.Commande;
import com.client.module.repository.CommandeRepository;


@Service("commandeService")
@Transactional
public class CommandeServiceImp implements CommandeService {

	@Autowired
	private CommandeRepository commandeRepository;
	
	@Override
	public Commande saveCommande(Commande commande) {
		return commandeRepository.save(commande);
	}
	
	@Override
	public Commande updateCommande(Commande commande) {
		return commandeRepository.save(commande);
	}
	
	@Override
	public void deleteCommande(Integer commandeId,Integer idClient) {
		commandeRepository.deleteByIdAndClient(commandeId,idClient);
	}



		@Override
		public Commande findCommandeByIdClient(Integer id,Integer idClient) {
			return commandeRepository.findByIdAndClient(id,idClient);
		}
		
	@Override
	public List<Commande> getCommandesByClient(Integer idClient) {
		return commandeRepository.findByClient(idClient);
	}
	@Override
	public boolean checkIfIdexists(Integer id) {
		return commandeRepository.existsById(id);
	}
	
}