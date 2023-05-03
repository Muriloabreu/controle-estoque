package com.api.controleestoque.dtos;

import com.api.controleestoque.models.ProdutosModel;

import jakarta.validation.constraints.NotNull;

public class EntradaProdutoDtos {
	
	@NotNull
	private ProdutosModel produtosModel;
	@NotNull
	private Double precoUnitario;
	@NotNull
	private Integer quantidade;
	
	
	public EntradaProdutoDtos() {
		super();
	}


	public EntradaProdutoDtos(@NotNull ProdutosModel produtosModel, @NotNull Double precoUnitario,
			@NotNull Integer quantidade) {
		super();
		this.produtosModel = produtosModel;
		this.precoUnitario = precoUnitario;
		this.quantidade = quantidade;
	}


	public ProdutosModel getProdutosModel() {
		return produtosModel;
	}


	public void setProdutosModel(ProdutosModel produtosModel) {
		this.produtosModel = produtosModel;
	}


	public Double getPrecoUnitario() {
		return precoUnitario;
	}


	public void setPrecoUnitario(Double precoUnitario) {
		this.precoUnitario = precoUnitario;
	}


	public Integer getQuantidade() {
		return quantidade;
	}


	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	
	
	
	
	
	
	
	
	
	

}
