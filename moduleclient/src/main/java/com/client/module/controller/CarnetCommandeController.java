package com.client.module.controller;


import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.client.module.entity.Categorie;
import com.client.module.entity.Client;
import com.client.module.entity.Commande;
import com.client.module.entity.LigneCommande;
import com.client.module.entity.Produit;
import com.client.module.service.CommandeServiceImp;
import com.client.module.service.LigneCommandeServiceImp;
import com.client.module.service. ClientServiceImp;
import com.client.module.service. ProduitServiceImp;
import com.client.module.model.CarnetCommande;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


@RestController
@RequestMapping("/rest/commande/api")
@Api(value = "Categorie Rest Controller: contient toutes les opérations pour gérer des commandes")
public class CarnetCommandeController {

	

	@Autowired
	private CommandeServiceImp commandeService;

	@Autowired
	private LigneCommandeServiceImp ligneCommandeService;
	
	@Autowired
	private ClientServiceImp  clientServiceImp;
	
	@Autowired
	private ProduitServiceImp  produitServiceImp;
	
	@PostMapping("/ajouterCommande")
	@ApiOperation(value = "Ajout d'une nouvelle commande de produits", response = Commande.class)
	@ApiResponses(value = { @ApiResponse(code = 409, message = "Conflict: Commande existe déjà"),
			@ApiResponse(code = 201, message = "Created: La Commande est inserée avec suuces"),
			@ApiResponse(code = 304, message = "Not Modified: La Commande n'a pas été ajoutée") })
	public ResponseEntity<Commande> ajouterNouvelleCommande(@RequestBody CarnetCommande carnetCommandeRequest) {
		
	
		Commande commandeAjout = new Commande();
		Optional<Client> client = clientServiceImp.findClientById(carnetCommandeRequest.getClient()) ;
		if(client.isPresent() == true)
		{
			commandeAjout.setClient(client.get());
			commandeAjout.setDate(LocalDate.now());
			commandeAjout.setEtat(1L);
			commandeAjout.setId(carnetCommandeRequest.getId());
			commandeAjout.setNumero("C_"+(int) Math.floor(Math.random() * 999) + 100);//générer numero commande
			BigDecimal prixtotal = BigDecimal.ZERO;
			for( int i=0;i<carnetCommandeRequest.getLigneCommandeDto().size() ;i++)
			{
				prixtotal.add( carnetCommandeRequest.getLigneCommandeDto().get(i).getPrixTotal());
				
			}
			commandeAjout.setPrixTotal(prixtotal)	;
			
			Commande commande = commandeService.saveCommande(commandeAjout);
			if (commande != null && commande.getId() != null) {
				
				for( int i=0;i<carnetCommandeRequest.getLigneCommandeDto().size() ;i++)
				{

					
					LigneCommande ligneCommande = new LigneCommande();
					
					//ajout chaque ligne de commande du client
					Optional<Produit> produit = produitServiceImp.findProduitById(carnetCommandeRequest.getLigneCommandeDto().get(i).getProduit());
					if(produit.isPresent() == true)
					{
						ligneCommande.setCommande(commande);
						ligneCommande.setEtat(1L);
						ligneCommande.setId(carnetCommandeRequest.getLigneCommandeDto().get(i).getId());
						ligneCommande.setPrixTotal(carnetCommandeRequest.getLigneCommandeDto().get(i).getPrixTotal());
						ligneCommande.setPrixUnitaire(carnetCommandeRequest.getLigneCommandeDto().get(i).getPrixUnitaire());
						ligneCommande.setProduit(produit.get());
						ligneCommande.setQte(carnetCommandeRequest.getLigneCommandeDto().get(i).getQte());
						LigneCommande lc = ligneCommandeService.saveLigneCommande(ligneCommande);
					}
						
					
				}
				return new ResponseEntity<Commande>(commande, HttpStatus.CREATED);
			}
		}
		
		return new ResponseEntity<Commande>(HttpStatus.NOT_MODIFIED);

	}

	@PutMapping("/modifierCommande")
	@ApiOperation(value = "Modifier une commande", response = Commande.class)
	@ApiResponses(value = { @ApiResponse(code = 404, message = "Not Found : La commande n'existe pas"),
			@ApiResponse(code = 200, message = "Ok: La commande est modifier avec succes"),
			@ApiResponse(code = 304, message = "Not Modified: La commande n'a pas été modifiée") })
	public ResponseEntity<Commande> modifierCommande(@RequestBody CarnetCommande carnetCommandeRequest) {
		
		if (!commandeService.checkIfIdexists(carnetCommandeRequest.getId())) {
			return new ResponseEntity<Commande>(HttpStatus.NOT_FOUND);
		}
		Commande commandeUpdate = new Commande();
		Optional<Client> client = clientServiceImp.findClientById(carnetCommandeRequest.getClient()) ;
		if(client.isPresent() == true)
		{
			commandeUpdate.setClient(client.get());
			commandeUpdate.setDate(LocalDate.now());
			commandeUpdate.setEtat(1L);
			commandeUpdate.setId(carnetCommandeRequest.getId());
			commandeUpdate.setNumero("C_"+(int) Math.floor(Math.random() * 999) + 100);//générer numero commande
			BigDecimal prixtotal = BigDecimal.ZERO;
			for( int i=0;i<carnetCommandeRequest.getLigneCommandeDto().size() ;i++)
			{
				prixtotal.add( carnetCommandeRequest.getLigneCommandeDto().get(i).getPrixTotal());
				
			}
			commandeUpdate.setPrixTotal(prixtotal)	;
		
		Commande com = commandeService.updateCommande(commandeUpdate);
		
		if (com != null && com.getId() != null) {
			
			for( int i=0;i<carnetCommandeRequest.getLigneCommandeDto().size() ;i++)
			{

				
				LigneCommande ligneCommande = new LigneCommande();
				
				//update  ligne de commande du client
				Optional<Produit> produit = produitServiceImp.findProduitById(carnetCommandeRequest.getLigneCommandeDto().get(i).getProduit());
				if(produit.isPresent() == true)
				{
					ligneCommande.setCommande(com);
					ligneCommande.setEtat(1L);
					ligneCommande.setId(carnetCommandeRequest.getLigneCommandeDto().get(i).getId());
					ligneCommande.setPrixTotal(carnetCommandeRequest.getLigneCommandeDto().get(i).getPrixTotal());
					ligneCommande.setPrixUnitaire(carnetCommandeRequest.getLigneCommandeDto().get(i).getPrixUnitaire());
					ligneCommande.setProduit(produit.get());
					ligneCommande.setQte(carnetCommandeRequest.getLigneCommandeDto().get(i).getQte());
					LigneCommande lc = ligneCommandeService.updateLigneCommande(ligneCommande);
				}
			}}
		
		if (com != null) {
	
			return new ResponseEntity<Commande>(com, HttpStatus.OK);
		}
		
	}
		return new ResponseEntity<Commande>(HttpStatus.NOT_MODIFIED);	
	}

	
	@DeleteMapping("/supprimerCategorie/{commandeId}/{clientd}")
	@ApiOperation(value = "Suppression d'une commande d'un client ", response = String.class)
	@ApiResponse(code = 204, message = "No Content: commande supprimée avec succes")
	public ResponseEntity<String> supprimerCommande(@PathVariable Integer commandeId,@PathVariable Integer clientd) {
		commandeService.deleteCommande(commandeId,clientd);
		return new ResponseEntity<String>(HttpStatus.NO_CONTENT);
	}
	
	
	@GetMapping("/listeCommandes/{clientId}")
	@ApiOperation(value="La liste de toutes les commande du client", response = List.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Ok: liste des commande"),
			@ApiResponse(code = 204, message = "No Content: pas de résultat"),
	})
	public ResponseEntity<List<Commande>> listeCommandes(@PathVariable Integer clientId) {
		List<Commande> commandes = commandeService.getCommandesByClient(clientId);
		if (!CollectionUtils.isEmpty(commandes)) {
			
		
			return new ResponseEntity<List<Commande>>(commandes, HttpStatus.OK);
		}
		return new ResponseEntity<List<Commande>>(HttpStatus.NO_CONTENT);
	}
}