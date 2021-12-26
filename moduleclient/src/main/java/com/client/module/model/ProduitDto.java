package com.client.module.model;

import java.math.BigDecimal;



public class ProduitDto {
	
	
 
     private Integer id;

   
    private String code;
    
   
    @Override
	public String toString() {
		return "ProduitDto [id=" + id + ", code=" + code + ", marque=" + marque + ", modele=" + modele
				+ ", caracteristiques=" + caracteristiques + ", prixUnitaire=" + prixUnitaire + ", quantite=" + quantite
				+ ", categorie=" + categorie + "]";
	}

	private String marque;
    
   
    private String modele;


    private String caracteristiques;
    
  
    private BigDecimal prixUnitaire;
   
    private Long quantite;
    
 
    private Integer categorie;
    
    
 
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

  
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    
   
    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }


    
    public String getModele() {
        return modele;
    }

    public void setModele(String modele) {
        this.modele = modele;
    }
    

    public String getCaracteristiques() {
        return caracteristiques;
    }

    public void setCaracteristiques(String caracteristiques) {
        this.caracteristiques = caracteristiques;
    }
    
   
    public BigDecimal getPrixUnitaire() {
        return prixUnitaire;
    }

    public void setPrixUnitaire(BigDecimal prixUnitaire) {
        this.prixUnitaire = prixUnitaire;
    }

 
    public Long getQuantite() {
        return quantite;
    }

    public void setQuantite(Long quantite) {
        this.quantite = quantite;
    }

  
    
    public Integer getCategorie() {
        return categorie;
    }

    public void setCategorie(Integer categorie) {
        this.categorie = categorie;
    }

}
