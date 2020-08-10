package com.epam.order.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.epam.order.dto.OrderDto;
import com.epam.order.dto.OrderItem;
import com.epam.order.entity.Product;
import com.epam.order.feignclient.RemoteCallService;
import com.epam.order.repository.OrderRepository;
import com.epam.order.service.OrderService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

	@Autowired
	RemoteCallService remoteCallService;

	@Autowired(required = true)
	OrderRepository orderRepository;

	private List<OrderItem> orderItem;

	@Override
	public List<Product> getOrders() {
		log.error("Getting Details of All Orders....");
		List<Product> product = new ArrayList<Product>();
		System.out.println("=====" + orderRepository.findAll());
		orderRepository.findAll().forEach(orderItem -> {
			product.add(orderItem);
		});

		return product;
	}

	public void addOrder(@RequestBody OrderDto orderData) throws Exception {
		List<Integer> orderCodes = orderItem.stream().map(x -> x.getProductCode()).collect(Collectors.toList());
		List<Integer> orderItemList = orderData.getOrderItems();
		if (orderCodes.containsAll(orderItemList)) {
			Product order = new Product();
			BeanUtils.copyProperties(orderData, order);
			orderRepository.save(order);
			log.info("Order Placed Successfully.....");
		} else {
			orderItemList.removeAll(orderCodes);
			throw new Exception(orderItemList + "Not Found in Order Item");
		}
	}

	@PostConstruct
	public void init() {
		orderItem = remoteCallService.getData();
	}
}
