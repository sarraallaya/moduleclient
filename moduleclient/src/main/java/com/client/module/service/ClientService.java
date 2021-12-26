package com.client.module.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;

import com.client.module.entity.Client;
public interface ClientService {

	public List<Client> getAllClients();
	
	
	public Client saveClient(Client client);

	public Client updateClient(Client client);

	public void deleteClient(Integer customerId);
	
	public boolean checkIfIdexists(Integer id);

	public Client findClientByEmail(String email);
	
	public List<Client> findClientByNom(String nom);
	
	public Optional<Client> findClientById(Integer clientId);

	public Page<Client> getPaginatedClientsList(int begin, int end);

}
