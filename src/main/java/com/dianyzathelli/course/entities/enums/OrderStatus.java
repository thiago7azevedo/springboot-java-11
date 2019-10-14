package com.dianyzathelli.course.entities.enums;

public enum OrderStatus {

	WAITING_PAYMENT(1),
	PAID(2),
	SHIPPED(3),
	DELIVERED(4),
	CANCELED(5);
	
	
	private int code;
	
	private OrderStatus(int code) {
		this.code = code;
	}
	
	public int getCode() {
		return code;
	}
	
	public static OrderStatus valueOf(int code) {
		for (OrderStatus value : OrderStatus.values()) { // percorre cada um dos valores e testa um por um se é iguyal.
			if(value.getCode() == code){
				return value;
			}
		}
		throw new IllegalArgumentException("Invalid OrderStatus Code!");
	}
}
