package com.client.module.entity;

import java.io.Serializable;
import java.time.LocalDate;



import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;

@Entity
@Table(name = "Client")
public class Client implements Serializable  {
	
	 private static final long serialVersionUID = 3692193101593832925L;
	 
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
	private Integer id;
	    
       @Column(name = "code", nullable = false)
	   private String code;
	   
       @Column(name = "nom", nullable = false)
	    private String nom;
	    
       @Column(name = "prenom", nullable = false)
	    private String prenom;
	    
       @Column(name = "date_naissance", nullable = false)
	    private LocalDate dateNaissance;
	    
       @Column(name = "adresse", nullable = false)
	    private String adresse;
	    
       @Column(name = "ville", nullable = false)
	    private String ville;
	    
       @Column(name = "code_postal", nullable = false)
	    private Long codePostal;
	    
       @Column(name = "tel")
	    private String tel;
	    
       @Column(name = "fax")
	    private String fax;
	    
       @Column(name = "gsm", nullable = false)
	    private String gsm;
	    
       @Column(name = "email", nullable = false, unique = true)
	    private String email;
	    
	
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
	    
	
	    public String getNom() {
	        return nom;
	    }

	    public void setNom(String nom) {
	        this.nom = nom;
	    }
	    
	    public String getPrenom() {
	        return prenom;
	    }

	    public void setPrenom(String prenom) {
	        this.prenom = prenom;
	    }
	    
	    public LocalDate getDateNaissance() {
	        return dateNaissance;
	    }

	    public void setDateNaissance(LocalDate dateNaissance) {
	        this.dateNaissance = dateNaissance;
	    }
	    
	   
	    public String getAdresse() {
	        return adresse;
	    }

	    public void setAdresse(String adresse) {
	        this.adresse = adresse;
	    }
	   
	 
	    public String getVille() {
	        return ville;
	    }

	    public void setVille(String ville) {
	        this.ville = ville;
	    }
	    
	    
	    public Long getCodePostal() {
	        return codePostal;
	    }

	    public void setCodePostal(Long codePostal) {
	        this.codePostal = codePostal;
	    }
	    
	    public String getTel() {
	        return tel;
	    }

	    public void setTel(String tel) {
	        this.tel = tel;
	    }
	    
	    public String getFax() {
	        return fax;
	    }

	    public void setFax(String fax) {
	        this.fax = fax;
	    }
	    
	    public String getGsm() {
	        return gsm;
	    }

	    public void setGsm(String gsm) {
	        this.gsm = gsm;
	    }

	    public String getEmail() {
	        return email;
	    }

	    public void setEmail(String email) {
	        this.email = email;
	    }	   

}
