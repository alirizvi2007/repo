package com.epam.order.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Controller;

import com.epam.order.entity.Product;
@Controller
public interface OrderRepository   extends CrudRepository<Product, Long>{

}
