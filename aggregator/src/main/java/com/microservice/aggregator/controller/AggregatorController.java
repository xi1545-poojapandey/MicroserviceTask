package com.microservice.aggregator.controller;

import com.microservice.aggregator.model.Order;
import com.microservice.aggregator.model.User;
import com.microservice.aggregator.service.OrderClient;
import com.microservice.aggregator.service.UserClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class AggregatorController {
	@Autowired
	UserClient userClient;

	@Autowired
	OrderClient orderClient;

	@GetMapping("/findUser")
	public Optional<User> findUser(Long id){
		return  userClient.getUser(id);
	}

	@GetMapping("/findAllUser")
	public List<User> findAllUser(){
		return  userClient.getAllUsers();
	}

	/*@PostMapping("/{orderAmount}")
	public ResponseEntity<?> createOrder(String orderAmount){return orderClient.createOrder(orderAmount);}*/

	@GetMapping("/getAllOrders")
	public List<Order> getAllOrders(){return orderClient.getAllOrders();}
}


