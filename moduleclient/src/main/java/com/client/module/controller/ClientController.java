package com.client.module.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.client.module.entity.Client;
import com.client.module.service.ClientServiceImp;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/rest/client/api")
@Api(value = "Client Rest Controller: contient toutes les opérations pour gérer des clients")
public class ClientController {
	
	
	
	@Autowired
	private ClientServiceImp clientService;

	@PostMapping("/ajouterClient")
	@ApiOperation(value = "Ajout d'un client", response = Client.class)
	@ApiResponses(value = { @ApiResponse(code = 409, message = "Conflict: Client existe déjà"),
			@ApiResponse(code = 201, message = "Created: Le client est inseré avec suuces"),
			@ApiResponse(code = 304, message = "Not Modified: Le client n'a pas été ajouté") })
	public ResponseEntity<Client> ajouterNouveauClient(@RequestBody Client clientRequest) {
		
	
		Optional<Client> clientExiste = clientService.findClientById(clientRequest.getId());
		if (clientExiste.isPresent() == true) {
		
			return new ResponseEntity<Client>(HttpStatus.CONFLICT);
		}
		
		Client client = clientService.saveClient(clientRequest);
		if (client != null && client.getId() != null) {
			
			return new ResponseEntity<Client>(client, HttpStatus.CREATED);
		}
		return new ResponseEntity<Client>(HttpStatus.NOT_MODIFIED);

	}
	
	
	
	@GetMapping("/listeClients")
	@ApiOperation(value="La liste de tous les clients", response = List.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Ok: liste des clients"),
			@ApiResponse(code = 204, message = "No Content: pas de résultat"),
	})
	public ResponseEntity<List<Client>> listeClients() {
		List<Client> clients = clientService.getAllClients();
		if (!CollectionUtils.isEmpty(clients)) {
			
		
			return new ResponseEntity<List<Client>>(clients, HttpStatus.OK);
		}
		return new ResponseEntity<List<Client>>(HttpStatus.NO_CONTENT);
	}

}
