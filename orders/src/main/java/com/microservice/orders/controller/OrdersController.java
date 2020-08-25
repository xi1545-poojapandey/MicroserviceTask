package com.microservice.orders.controller;

import com.microservice.orders.model.Order;
import com.microservice.orders.service.OrdersServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/orders")
public class OrdersController {

	@Autowired
	OrdersServiceImpl ordersServiceImpl;



	@PostMapping(name = "/{orderAmount}")
	public  ResponseEntity<?> createOrder(@RequestParam(name="orderAmount") String orderAmount){
		Order order= ordersServiceImpl.createOrder(orderAmount);
		if(order!=null){

			return new ResponseEntity<>(order, HttpStatus.CREATED);
		}

		else{
			return new ResponseEntity<>(order, HttpStatus.BAD_REQUEST);
		}

	}
	/*@GetMapping(name ="/{orderId}")
	public Optional<Order> getOrder(@PathVariable(name="orderId") Long orderId) {

		return ordersServiceImpl.getOrder(orderId);

	}*/


	@GetMapping
	public List<Order> getAllOrders(){

		return ordersServiceImpl.getAllOrders();
	}
}
