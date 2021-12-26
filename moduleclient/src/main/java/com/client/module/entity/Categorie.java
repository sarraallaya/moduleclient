package com.client.module.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


import lombok.Data;

@Data
@Entity
@Table(name="categorie")
public class Categorie implements Serializable  {

	 private static final long serialVersionUID = 2612193101593832963L;
	 
	    @Id  
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    @Column(name = "id")
	    private Integer id;
	  
	    @Column(name = "code" , nullable = false, unique = true)
	    private String code;
	    
	    @Column(name = "libelle", nullable = false)
	    private String libelle;
	    
    

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


    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

  
  /*  public List<Produit> getProduitList() {
        return produitList;
    }
    public void setProduitList(List<Produit> produitList) {
        this.produitList = produitList;
}*/
}