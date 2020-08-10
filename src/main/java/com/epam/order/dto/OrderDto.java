package com.epam.order.dto;

import java.math.BigDecimal;
import java.util.List;

import lombok.Data;

@Data
public class OrderDto {

	private int id;
	private String customerName;
	private String orderDate;
	private String shippingAddress;
	private List<Integer> orderItems;
	private BigDecimal total;

}
