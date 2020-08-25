package com.microservice.aggregator.service;


import com.microservice.aggregator.model.Order;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@FeignClient(url = "http://localhost:8082/orders/", name = "Orders")
public interface OrderClient {

	@PostMapping(name = "/{orderAmount}")
	public ResponseEntity<?> createOrder(@RequestParam(name = "orderAmount") String orderAmount);

	/*@GetMapping(name = "/order/{orderId}")
	public Optional<Order> getOrder(@RequestParam(name = "orderId") Long orderId);*/

	@GetMapping
	public List<Order> getAllOrders();
}
