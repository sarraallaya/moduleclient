package com.client.module.model;

import java.math.BigDecimal;


public class LigneCommandeDto {
	
		private Integer id;
		    
	     
		   private Long qte;
		   
	     
		    private BigDecimal prixUnitaire;
	       
	      
		    private BigDecimal prixTotal;
		    
	     
		    private Long etat;
		    
	       
	       @Override
			public String toString() {
				return "LigneCommandeDto [id=" + id + ", qte=" + qte + ", prixUnitaire=" + prixUnitaire + ", prixTotal="
						+ prixTotal + ", etat=" + etat + ", commande=" + commande + ", produit=" + produit + "]";
			}

		private Integer commande;

	       private Integer produit;
	       
	       
	       
		
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
		    
		    
		    public Integer getCommande() {
		        return commande;
		    }

		    public void setCommande(Integer commande) {
		        this.commande = commande;
		    }
		    
		    
		    public Integer getProduit() {
		        return produit;
		    }

		    public void setProduit(Integer produit) {
		        this.produit = produit;
		    }
}
