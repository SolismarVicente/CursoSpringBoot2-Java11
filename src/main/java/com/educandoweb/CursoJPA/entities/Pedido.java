package com.educandoweb.cursojpa.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.educandoweb.cursojpa.entities.enums.StatusPedido;
import com.fasterxml.jackson.annotation.JsonFormat;

//pedido: no video está Order
@Entity
@Table(name = "tb_pedido")
public class Pedido implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
	private Instant momento;
	
	private Integer statusPedido;
	
	//Implementação do relacionamento entre pedido(order) e
	//usuario: (user)
	//No pedido eu consigo puxar o usuario(cliente) e os itens do pedido
	@ManyToOne
	@JoinColumn(name = "tb_usuario_codigo")
	private Usuario cliente;
	
	@OneToMany(mappedBy = "chavePrimaria.pedido")
	private Set<ItemPedido> itensPedidos = new HashSet<>();
	
	@OneToOne(mappedBy = "pedido", cascade = CascadeType.ALL)
	private Pagamento pagamento;
	
	public Pedido() {
		
	}

	public Pedido(Long codigo, Instant momento, StatusPedido orderStatus, Usuario cliente) {
		super();
		this.codigo = codigo;
		this.momento = momento;
		setOrderStatus(orderStatus);
		this.cliente = cliente;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public Instant getMomento() {
		return momento;
	}

	public void setMomento(Instant momento) {
		this.momento = momento;
	}
	
	public StatusPedido getStatusPedido() {
		return StatusPedido.transformaCodigoString(statusPedido);
	}

	public void setOrderStatus(StatusPedido statusPedido) {
		if (statusPedido != null) {
			this.statusPedido = statusPedido.getCode();
		}
	}

	public Usuario getCliente() {
		return cliente;
	}

	public void setCliente(Usuario cliente) {
		this.cliente = cliente;
	}
	
	public Set<ItemPedido> getItensPedidos() {
		return itensPedidos;
	}

	public Pagamento getPagamento() {
		return pagamento;
	}

	public void setPagamento(Pagamento pagamento) {
		this.pagamento = pagamento;
	}

	//calcular valorTotal do Pedido
	public Double getTotal() {
		double soma = 0.0;
		for (ItemPedido x : itensPedidos) {
			soma= soma + x.getSubTotal();
		}
		return soma;
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
		Pedido other = (Pedido) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}
	
	
}
