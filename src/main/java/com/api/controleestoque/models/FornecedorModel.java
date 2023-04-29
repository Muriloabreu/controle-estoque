package com.api.controleestoque.models;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "TB_FORNECEDORES")
public class FornecedorModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(nullable = false, length = 100)
	private String nome;
	@Column(nullable = false, length = 100)
	private String cnpj;
	@Column(nullable = false)
	private LocalDateTime dataRegistro;
	
	
	/* Construtor */
	public FornecedorModel() {
		super();
	}

	

	public FornecedorModel(Long id, String nome, String cnpj, LocalDateTime dataRegistro) {
		super();
		this.id = id;
		this.nome = nome;
		this.cnpj = cnpj;
		this.dataRegistro = dataRegistro;
	}



	/* Métodos Acessores */
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	
	public LocalDateTime getDataRegistro() {
		return dataRegistro;
	}
	
	public void setDataRegistro(LocalDateTime dataRegistro) {
		this.dataRegistro = dataRegistro;
	}

}
