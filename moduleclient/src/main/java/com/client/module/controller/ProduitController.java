package com.client.module.controller;

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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.client.module.entity.Categorie;
import com.client.module.entity.Produit;
import com.client.module.model.ProduitDto;
import com.client.module.service.CategorieServiceImp;
import com.client.module.service.ProduitServiceImp;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/rest/produit/api")
@Api(value = "Produit Rest Controller: contient toutes les opérations pour gérer des produits")
public class ProduitController {


	@Autowired
	private ProduitServiceImp produitService;
	
	@Autowired
	private CategorieServiceImp categorieService;

	@PostMapping("/ajouterProduit")
	@ApiOperation(value = "Ajout d'un nouveau produit", response = Produit.class)
	@ApiResponses(value = { @ApiResponse(code = 409, message = "Conflict: produit existe déjà"),
			@ApiResponse(code = 201, message = "Created: Le produit est inseré avec suuces"),
			@ApiResponse(code = 304, message = "Not Modified: Le produit n'a pas été ajouté") })
	public ResponseEntity<Produit> ajouterNouveauProduit(@RequestBody ProduitDto produitRequest) {
		
	
		Optional<Produit> produitExiste = produitService.findProduitById(produitRequest.getId());
		if (produitExiste.isPresent() == true) {
		
			return new ResponseEntity<Produit>(HttpStatus.CONFLICT);
		}
		
		Optional<Categorie> categorieExiste = categorieService.findCategorieById(produitRequest.getCategorie());

		if (categorieExiste.isPresent() == true) {
	
			Produit produitAjout = new Produit();
			produitAjout.setCaracteristiques(produitRequest.getCaracteristiques());
			produitAjout.setCategorie(categorieExiste.get());
			produitAjout.setCode(produitRequest.getCode());
			produitAjout.setId(produitRequest.getId());
			produitAjout.setMarque(produitRequest.getMarque());
			produitAjout.setModele(produitRequest.getModele());
			produitAjout.setPrixUnitaire(produitRequest.getPrixUnitaire());
			produitAjout.setQuantite(produitRequest.getQuantite());
			Produit produit = produitService.saveProduit(produitAjout);
		
			if (produit != null && produit.getId() != null) {
				
				return new ResponseEntity<Produit>(produit, HttpStatus.CREATED);
			}
		}
		
		
		return new ResponseEntity<Produit>(HttpStatus.NOT_MODIFIED);

	}
	


	@DeleteMapping("/supprimerProduit/{produitId}")
	@ApiOperation(value = "Suppression d'un produit existant", response = String.class)
	@ApiResponse(code = 204, message = "No Content: produit supprimé avec succes")
	public ResponseEntity<String> supprimerProduit(@PathVariable Integer produitId) {
		produitService.deleteProduit(produitId);
		return new ResponseEntity<String>(HttpStatus.NO_CONTENT);
	}
	
	
	@GetMapping("/listeProduits")
	@ApiOperation(value="La liste de tous les produits", response = List.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Ok: liste des produit"),
			@ApiResponse(code = 204, message = "No Content: pas de résultat"),
	})
	public ResponseEntity<List<Produit>> listeProduits() {
		List<Produit> produits = produitService.getAllProduits();
		if (!CollectionUtils.isEmpty(produits)) {
			
		
			return new ResponseEntity<List<Produit>>(produits, HttpStatus.OK);
		}
		return new ResponseEntity<List<Produit>>(HttpStatus.NO_CONTENT);
	}

}
