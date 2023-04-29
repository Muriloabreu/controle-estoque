package com.api.controleestoque.models;

import java.util.Objects;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "TB_ENTRADA_PROD")
public class EntradaProdutoModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	
	
	
	/*Construtor*/
	
	public EntradaProdutoModel() {
		super();
	}

	
	
	



	/*Métodos Acessores*/

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	

	
	
	
	
	
	
	
	
	

}
