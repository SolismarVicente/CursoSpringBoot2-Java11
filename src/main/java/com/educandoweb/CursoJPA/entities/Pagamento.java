package com.educandoweb.cursojpa.entities;

import java.io.Serializable;
import java.time.Instant;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tb_pagamento")
//Pagamento: no vídeo está Payment
public class Pagamento implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	private Instant momentoPagamento;
	
	//A classe Pedido será independente, enquanto que
	//a classe Pagamento será dependente de Pedido
	@JsonIgnore
	@OneToOne
	@MapsId
	private Pedido pedido;
	
	public Pagamento() {
		
	}

	public Pagamento(Long codigo, Instant momentoPagamento, Pedido pedido) {
		super();
		this.codigo = codigo;
		this.momentoPagamento = momentoPagamento;
		this.pedido = pedido;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public Instant getMomentoPagamento() {
		return momentoPagamento;
	}

	public void setMomentoPagamento(Instant momentoPagamento) {
		this.momentoPagamento = momentoPagamento;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
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
		Pagamento other = (Pagamento) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}
	
}
