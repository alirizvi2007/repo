package com.epam.order.dto;

import lombok.Data;

@Data
public class OrderItem {
	
	private Integer productCode;
	
	private String productName;
	
	private int quantity;



}
