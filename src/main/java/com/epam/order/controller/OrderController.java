package com.epam.order.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.epam.order.dto.OrderDto;
import com.epam.order.entity.Product;
import com.epam.order.exception.RecordNotFoundException;
import com.epam.order.service.OrderService;

@RestController
@RequestMapping("/order")

@RefreshScope
public class OrderController {

	@Autowired
	OrderService orderService;

	@GetMapping("/getorders")
	public ResponseEntity<List<Product>> getAllOrder() throws Exception {
		if (ObjectUtils.isEmpty(orderService.getOrders()))
			throw new RecordNotFoundException("No Record Present");
		return new ResponseEntity<List<Product>>(orderService.getOrders(), HttpStatus.OK);
	}

	@PostMapping("/addorder")
	public ResponseEntity<OrderDto> addOrder(@RequestBody OrderDto orderData) throws Exception {
		orderService.addOrder(orderData);
		return new ResponseEntity<OrderDto>(orderData, HttpStatus.OK);
	}

}
