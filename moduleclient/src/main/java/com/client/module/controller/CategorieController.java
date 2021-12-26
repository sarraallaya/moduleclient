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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.client.module.entity.Categorie;

import com.client.module.service.CategorieServiceImp;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/rest/categorie/api")
@Api(value = "Categorie Rest Controller: contient toutes les opérations pour gérer des categories")
public class CategorieController {

	

	@Autowired
	private CategorieServiceImp categorieService;

	@PostMapping("/ajouterCategorie")
	@ApiOperation(value = "Ajout d'une nouvelle categorie", response = Categorie.class)
	@ApiResponses(value = { @ApiResponse(code = 409, message = "Conflict: Categorie existe déjà"),
			@ApiResponse(code = 201, message = "Created: La categorie est inserée avec suuces"),
			@ApiResponse(code = 304, message = "Not Modified: La categorie n'a pas été ajoutée") })
	public ResponseEntity<Categorie> ajouterNouvelleCategorie(@RequestBody Categorie categorieRequest) {
		
	
		Optional<Categorie> categorieExiste = categorieService.findCategorieById(categorieRequest.getId());
		if (categorieExiste.isPresent() == true) {
		
			return new ResponseEntity<Categorie>(HttpStatus.CONFLICT);
		}
		
		Categorie categorie = categorieService.saveCategorie(categorieRequest);
		if (categorie != null && categorie.getId() != null) {
			
			return new ResponseEntity<Categorie>(categorie, HttpStatus.CREATED);
		}
		return new ResponseEntity<Categorie>(HttpStatus.NOT_MODIFIED);

	}
	
	@PutMapping("/modifierCategorie")
	@ApiOperation(value = "Modifier une categorie", response = Categorie.class)
	@ApiResponses(value = { @ApiResponse(code = 404, message = "Not Found : La categorie n'existe pas"),
			@ApiResponse(code = 200, message = "Ok: La categorie est modifier avec succes"),
			@ApiResponse(code = 304, message = "Not Modified: La categorie n'a pas été modifiée") })
	public ResponseEntity<Categorie> modifierCategorie(@RequestBody Categorie categorieRequest) {
		
		if (!categorieService.checkIfIdexists(categorieRequest.getId())) {
			return new ResponseEntity<Categorie>(HttpStatus.NOT_FOUND);
		}
		
		Categorie cat = categorieService.updateCategorie(categorieRequest);
		if (cat != null) {
	
			return new ResponseEntity<Categorie>(cat, HttpStatus.OK);
		}
		return new ResponseEntity<Categorie>(HttpStatus.NOT_MODIFIED);
	}

	@DeleteMapping("/supprimerCategorie/{categorieId}")
	@ApiOperation(value = "Suppression d'une categorie existante", response = String.class)
	@ApiResponse(code = 204, message = "No Content: Categorie supprimée avec succes")
	public ResponseEntity<String> supprimerCategorie(@PathVariable Integer categorieId) {
		categorieService.deleteCategorie(categorieId);
		return new ResponseEntity<String>(HttpStatus.NO_CONTENT);
	}
	
	
	@GetMapping("/listeCategories")
	@ApiOperation(value="La liste de toutes les categories", response = List.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Ok: liste des categories"),
			@ApiResponse(code = 204, message = "No Content: pas de résultat"),
	})
	public ResponseEntity<List<Categorie>> listeCategories() {
		List<Categorie> categories = categorieService.getAllCategories();
		if (!CollectionUtils.isEmpty(categories)) {
			
		
			return new ResponseEntity<List<Categorie>>(categories, HttpStatus.OK);
		}
		return new ResponseEntity<List<Categorie>>(HttpStatus.NO_CONTENT);
	}

}