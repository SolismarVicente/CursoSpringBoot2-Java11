package com.educandoweb.cursojpa.entities;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.educandoweb.cursojpa.entities.pk.ChavePrimariaItemPedido;

@Entity
@Table(name = "tb_item_pedido")
public class ItemPedido implements Serializable {

	private static final long serialVersionUID = 1L;

	//codigo composto
	@EmbeddedId
	private ChavePrimariaItemPedido chavePrimaria;
	
	private Integer quantidade;
	private Double preco;
	
	public ItemPedido() {
		
	}

	public ItemPedido(Produto produto, Pedido pedido, Integer quantidade, Double preco) {
		super();
		chavePrimaria.setProduto(produto);
		chavePrimaria.setPedido(pedido);
		this.quantidade = quantidade;
		this.preco = preco;
	}
	
	public Produto getProduto() {
		System.out.println("getProduto");
		return chavePrimaria.getProduto();
	}
	
	public void setProduto(Produto produto) {
		System.out.println("setProduto");
		chavePrimaria.setProduto(produto);
	}
	
	public Pedido getPedido() {
		return chavePrimaria.getPedido();
	}
	
	public void setPedido(Pedido pedido) {
		chavePrimaria.setPedido(pedido);
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
