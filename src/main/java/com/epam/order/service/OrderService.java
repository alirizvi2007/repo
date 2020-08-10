package com.epam.order.service;

import java.util.List;

import com.epam.order.dto.OrderDto;
import com.epam.order.entity.Product;


public interface OrderService {
	
	public List<Product> getOrders();
	
	public void addOrder(OrderDto orderDto) throws Exception;

}
