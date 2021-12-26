package com.client.module.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.client.module.entity.Client;
import com.client.module.repository.ClientRepository;

@Service("clientService")
@Transactional
public class ClientServiceImp implements ClientService {
	
	@Autowired
	private ClientRepository clientRepository;
	
	
	@Override
	public List<Client> getAllClients(){
		return clientRepository.findAll();
	}
	
	@Override
	public Client saveClient(Client client) {
		return clientRepository.save(client);
	}

	@Override
	public Client updateClient(Client client) {
		return clientRepository.save(client);
	}

	@Override
	public void deleteClient(Integer clientId) {
		clientRepository.deleteById(clientId);
	}

	@Override
	public boolean checkIfIdexists(Integer id) {
		return clientRepository.existsById(id);
	}

	@Override
	public Client findClientByEmail(String email) {
		return clientRepository.findClientByEmailIgnoreCase(email);
	}
	
	@Override
	public Optional<Client> findClientById(Integer clientId) {
		return clientRepository.findById(clientId);
	}

	@Override
	public Page<Client> getPaginatedClientsList(int begin, int end){
		Pageable page = PageRequest.of(begin, end);
		return clientRepository.findAll(page);
	}
	
	@Override
	public List<Client> findClientByNom(String nom){
		return clientRepository.findClientByNomIgnoreCase(nom);
	}

}
