package com.educandoweb.cursojpa.entities.enums;

public enum StatusPedido {
	
	WAITING_PAYMENT(1),
	PAID(2),
	SHIPPED(3),
	DELIVERED(4),
	CANCELED(5);
	
	private int code;
	
	private StatusPedido(int code) {
		this.code = code;
	}
	
	public int getCode() {
		return code;
	}
	
	public static StatusPedido transformaCodigoString(int code) {
		for (StatusPedido valor : StatusPedido.values()) {
			if (valor.getCode() == code) {
				return valor;
			}
		} throw new IllegalArgumentException("código do OrderStatus inválido");
	}
}
