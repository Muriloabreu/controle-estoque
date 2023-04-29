package com.api.controleestoque.dtos;


import jakarta.validation.constraints.NotBlank;

public class FornecedorDtos {
	
	@NotBlank
	private String nome;
	@NotBlank
	private String cnpj;
	
	/* Construtor */
	
	public FornecedorDtos() {
		super();
	}

	public FornecedorDtos(@NotBlank String nome, @NotBlank String cnpj) {
		super();
		this.nome = nome;
		this.cnpj = cnpj;
	}
	
	/* Métodos Acessores */
	
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
	
	
	

}
