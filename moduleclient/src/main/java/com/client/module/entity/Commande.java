package com.client.module.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

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
@Table(name = "Commande")
public class Commande implements Serializable{

	 private static final long serialVersionUID = 5236193101593832925L;
	 
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Column(name = "id")
	    private Integer id;

        @Column(name = "numero_commande", nullable = false, unique = true)
	    private String numero;
	    
        @Column(name = "date_commande", nullable = false)
	    private LocalDate date;
        
        @Column(name = "prix_total", nullable = false)
	    private BigDecimal prixTotal;
	    
        @Column(name = "etat", nullable = false)
	    private Long etat;
	    
        @ManyToOne()
	    @JoinColumn(name="id_client", referencedColumnName = "id", insertable = false, updatable = false ,nullable = false)
        @OnDelete(action = OnDeleteAction.CASCADE)
        private Client client;
	    
	    
	
	    public Integer getId() {
	        return id;
	    }

	    public void setId(Integer id) {
	        this.id = id;
	    }

	    
	    public String getNumero() {
	        return numero;
	    }

	    public void setNumero(String numero) {
	        this.numero = numero;
	    }

	   
	    public LocalDate getDate() {
	        return date;
	    }

	    public void setDate(LocalDate date) {
	        this.date = date;
	    }
	    
	    
	    public BigDecimal getPrixTotal() {
	        return prixTotal;
	    }

	    public void setPrixTotal(BigDecimal prixTotal) {
	        this.prixTotal = prixTotal;
	    }

	 
	    public Long getEtat() {
	        return etat;
	    }

	    public void setEtat(Long etat) {
	        this.etat = etat;
	    }

	    public Client getClient() {
	        return client;
	    }

	    public void setClient(Client client) {
	        this.client = client;
	    }
	    
}
