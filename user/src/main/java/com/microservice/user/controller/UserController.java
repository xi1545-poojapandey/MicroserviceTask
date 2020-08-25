package com.microservice.user.controller;

import com.microservice.user.model.User;
import com.microservice.user.model.UserDto;
import com.microservice.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.jws.soap.SOAPBinding;
import javax.ws.rs.GET;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userService;

	@PostMapping("/createUser")
	public ResponseEntity<?> createUser(@RequestBody UserDto userDto){

		User user= userService.createUser(userDto);
		if(user!=null){

			return new ResponseEntity<>(user, HttpStatus.CREATED);
		}
		else{
			return new ResponseEntity<>(user, HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/{id}")
	public Optional<User> getUser(@PathVariable("id") Long id) {

		return userService.getUser(id);
	}

	@GetMapping
	public List<User> getAllUsers(){
		return userService.getAllUser();
	}
}
