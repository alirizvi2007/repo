package com.epam.order.feignclient;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.epam.order.dto.OrderItem;


@FeignClient(url = "http://localhost:8081", name = "orderitem")
public interface RemoteCallService {
	
	@RequestMapping(method=RequestMethod.GET, value="/orderitem/getorderitems")
	public List<OrderItem> getData();

}
