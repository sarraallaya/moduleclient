package com.client.module.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.client.module.entity.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {

	public Client findClientByEmailIgnoreCase(String email);
	
	public List<Client> findClientByNomIgnoreCase(String nom);
		
}
