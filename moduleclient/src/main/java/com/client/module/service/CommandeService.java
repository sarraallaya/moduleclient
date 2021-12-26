package com.client.module.service;


import java.util.List;

import com.client.module.entity.Commande;

public interface CommandeService {
	
	public Commande saveCommande(Commande commande);
	
	public Commande updateCommande(Commande commande);
	
	public void deleteCommande(Integer commande,Integer idClient);
	
	public Commande findCommandeByIdClient(Integer id,Integer idClient);
	
	public boolean checkIfIdexists(Integer id);
	
	public List<Commande> getCommandesByClient(Integer idClient);

}
