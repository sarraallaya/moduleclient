package com.client.module.model;

import com.client.module.model.LigneCommandeDto;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.client.module.entity.Client;

public class CarnetCommande {


   
    private Integer id;

    
    private Integer client;
    
    List <LigneCommandeDto> ligneCommandeDto;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }



    @Override
	public String toString() {
		return "CarnetCommande [id=" + id + ", client=" + client + ", ligneCommandeDto=" + ligneCommandeDto + "]";
	}

	public Integer getClient() {
        return client;
    }

    public void setClient(Integer client) {
        this.client = client;
    }
    
    public List<LigneCommandeDto> getLigneCommandeDto() {
        return ligneCommandeDto;
    }

    public void setLigneCommandeDto(List <LigneCommandeDto> ligneCommandeDto) {
        this.ligneCommandeDto = ligneCommandeDto;
    }
}
