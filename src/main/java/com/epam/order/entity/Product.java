package com.epam.order.entity;

import java.math.BigDecimal;
import java.util.Collection;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "orders")
@Data
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String customerName;
	private String orderDate;
	private String shippingAddress;
	@ElementCollection(fetch = FetchType.LAZY)
	private Collection<Integer> orderItems;
	private BigDecimal total;

}
