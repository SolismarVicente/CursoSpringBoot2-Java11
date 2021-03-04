package com.educandoweb.cursojpa.entities;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.educandoweb.cursojpa.entities.pk.ChavePrimariaItemPedido;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tb_item_pedido")
public class ItemPedido implements Serializable {

	private static final long serialVersionUID = 1L;

	//codigo composto
	@EmbeddedId
	private ChavePrimariaItemPedido chavePrimaria = new ChavePrimariaItemPedido();
	
	private Integer quantidade;
	private Double preco;
	
	public ItemPedido() {
		
	}

	public ItemPedido(Pedido pedido, Produto produto, Integer quantidade, Double preco) {
		super();
		chavePrimaria.setPedido(pedido);
		chavePrimaria.setProduto(produto);
		this.quantidade = quantidade;
		this.preco = preco;
	}
	
	@JsonIgnore
	//o getPedido que chama o pedido associado a este item do pedido
	//ficando um loop infinito
	public Pedido getPedido() {
		return chavePrimaria.getPedido();
	}
	
	public void setPedido(Pedido pedido) {
		chavePrimaria.setPedido(pedido);
	}
	
	public Produto getProduto() {
		System.out.println("getProduto");
		return chavePrimaria.getProduto();
	}
	
	public void setProduto(Produto produto) {
		System.out.println("setProduto");
		chavePrimaria.setProduto(produto);
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((chavePrimaria == null) ? 0 : chavePrimaria.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItemPedido other = (ItemPedido) obj;
		if (chavePrimaria == null) {
			if (other.chavePrimaria != null)
				return false;
		} else if (!chavePrimaria.equals(other.chavePrimaria))
			return false;
		return true;
	}
	
}
