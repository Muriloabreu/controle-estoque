package com.api.controleestoque.dtos;

import com.api.controleestoque.models.ProdutosModel;

import jakarta.validation.constraints.NotNull;

public class SaidaProdutoDtos {
	
	
	@NotNull
	private ProdutosModel produto;
	@NotNull
	private Integer quantidade;
	
	
	public SaidaProdutoDtos() {
		super();
	}


	public SaidaProdutoDtos(@NotNull ProdutosModel produto, @NotNull Integer quantidade) {
		
		this.produto = produto;
		this.quantidade = quantidade;
	}


	public ProdutosModel getProdutosModel() {
		return produto;
	}


	public void setProdutosModel(ProdutosModel produto) {
		this.produto = produto;
	}


	public Integer getQuantidade() {
		return quantidade;
	}


	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	
	
	
	
	

}
