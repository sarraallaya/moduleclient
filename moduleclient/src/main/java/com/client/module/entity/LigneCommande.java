package com.client.module.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "Ligne_Commande")
public class LigneCommande implements Serializable {

	 private static final long serialVersionUID = 4812193101593832864L;
	 
	 
	 @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    @Column(name = "id")
		private Integer id;
		    
	       @Column(name = "qte", nullable = false)
		   private Long qte;
		   
	       @Column(name = "prix_unitaire", nullable = false)
		    private BigDecimal prixUnitaire;
	       
	       @Column(name = "prix_total", nullable = false)
		    private BigDecimal prixTotal;
		    
	       @Column(name = "etat", nullable = false)
		    private Long etat;
		    
	       @ManyToOne(fetch = FetchType.LAZY)
	       @JoinColumn(name = "id_commande", referencedColumnName = "id", insertable = false, updatable = false ,nullable = false)
	       @OnDelete(action = OnDeleteAction.CASCADE)
	       private Commande commande;

	       @ManyToOne(fetch = FetchType.LAZY)
	       @JoinColumn(name = "id_produit", referencedColumnName = "id", insertable = false, updatable = false ,nullable = false)
	       @OnDelete(action = OnDeleteAction.CASCADE)
	       private Produit produit;
	       
	       
	       
		
		    public Integer getId() {
		        return id;
		    }

		    public void setId(Integer id) {
		        this.id = id;
		    }
		    
		   
		    public Long getQte() {
		        return qte;
		    }

		    public void setQte(Long qte) {
		        this.qte = qte;
		    }
		    
		
		    public BigDecimal getPrixUnitaire() {
		        return prixUnitaire;
		    }

		    public void setPrixUnitaire(BigDecimal prixUnitaire) {
		        this.prixUnitaire = prixUnitaire;
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
		    
		    
		    public Commande getCommande() {
		        return commande;
		    }

		    public void setCommande(Commande commande) {
		        this.commande = commande;
		    }
		    
		    
		    public Produit getProduit() {
		        return produit;
		    }

		    public void setProduit(Produit produit) {
		        this.produit = produit;
		    }
		 
		    
	  
}
