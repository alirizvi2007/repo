package com.epam.order.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan(basePackages= {"com.epam.order"})
@SpringBootApplication
@EnableFeignClients(basePackages={"com.epam.order.feignclient"})
@EnableJpaRepositories(basePackages = { "com.epam.order.repository" })
@EntityScan("com.epam.order.entity")  
public class OrderApplication {
	
	
	
	public static void main(String[] args) {
		SpringApplication.run(OrderApplication.class, args);
	}

}
