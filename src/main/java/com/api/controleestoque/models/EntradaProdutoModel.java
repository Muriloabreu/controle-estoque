package com.api.controleestoque.models;


import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "TB_ENTRADA_PROD")
public class EntradaProdutoModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@ManyToOne
	@JoinColumn(name = "id_entrada_Produto")
	private ProdutosModel produtosModel;
	@Column(nullable = false)
    private Double precoUnitario;
    @Column(nullable = false)
    private Integer quantidade;
    @Column(nullable = false)
    private LocalDateTime dataRegistro;
	
	
	/*Construtor*/
	
	public EntradaProdutoModel() {
		super();
	}
	
	public EntradaProdutoModel(Long id, ProdutosModel produtosModel, Double precoUnitario, Integer quantidade,
			LocalDateTime dataRegistro) {
		super();
		this.id = id;
		this.produtosModel = produtosModel;
		this.precoUnitario = precoUnitario;
		this.quantidade = quantidade;
		this.dataRegistro = dataRegistro;
	}


	/*Métodos Acessores*/

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public LocalDateTime getDataRegistro() {
		return dataRegistro;
	}

	public void setDataRegistro(LocalDateTime dataRegistro) {
		this.dataRegistro = dataRegistro;
	}
	
	
	

	
	
	
	
	
	
	
	
	

}
