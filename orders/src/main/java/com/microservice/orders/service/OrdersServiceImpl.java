package com.microservice.orders.service;

import com.microservice.orders.model.Order;
import com.microservice.orders.repository.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class OrdersServiceImpl {
	@Autowired
	OrdersRepository ordersRepository;

	public Order createOrder(String orderAmount) {

		Order order = new Order();
		order.setOrderAmount(orderAmount);
		order.setOrderDate(new Date());
		return ordersRepository.save(order);

	}

	public Optional<Order> getOrder(Long orderId) {
		return ordersRepository.findById(orderId);

	}

	public List<Order> getAllOrders(){

		return ordersRepository.findAll();
	}


}
