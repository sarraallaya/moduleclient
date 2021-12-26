package com.client.module.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;



@Entity
@Table(name="produit")
public class Produit implements Serializable {
    
	 private static final long serialVersionUID = 2695333101593832963L;
	    @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    @Column(name = "id")
	     private Integer id;

	    @Column(name = "code", nullable = false, unique = true)
	    private String code;
	    
	    @Column(name = "marque", nullable = false)
	    private String marque;
	    
	    @Column(name = "modele", nullable = false)
	    private String modele;

	    @Column(name = "caracteristiques", nullable = false)
	    private String caracteristiques;
	    
	    @Column(name = "prix_unitaire", nullable = false)
	    private BigDecimal prixUnitaire;
	    
	   
	    @Column(name = "quantite", nullable = false)
	    private Long quantite;
	    
	    @ManyToOne()
	    @JoinColumn(name="categorie", referencedColumnName = "id", insertable = false, updatable = false ,nullable = false)
	    @OnDelete(action = OnDeleteAction.CASCADE)
	    private Categorie categorie;
	    
	    
	 
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

	  
	    
	    public Categorie getCategorie() {
	        return categorie;
	    }

	    public void setCategorie(Categorie categorie) {
	        this.categorie = categorie;
	    }
	    
	  

}