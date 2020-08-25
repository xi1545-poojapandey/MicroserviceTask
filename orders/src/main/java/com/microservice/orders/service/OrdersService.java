package com.microservice.orders.service;

import com.microservice.orders.model.Order;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface OrdersService {

	public Optional<Order> getOrder(Long orderId);
	public Order createOrder(String orderAmount);
	public List<Order> getAllOrders();

}
