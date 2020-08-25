package com.microservice.aggregator.service;

import com.microservice.aggregator.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@FeignClient(url="http://localhost:8083/user/", name = "User")
public interface UserClient {

	@GetMapping("/{id}")
	public Optional<User> getUser(@PathVariable("id") Long id);

	@GetMapping
	public List<User> getAllUsers();





}
