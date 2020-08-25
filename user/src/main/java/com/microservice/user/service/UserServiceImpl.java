package com.microservice.user.service;

import com.microservice.user.model.User;
import com.microservice.user.model.UserDto;
import com.microservice.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;

	public User createUser(UserDto userDto){

		User user= new User();
		user.setAge(userDto.getAge());
		user.setEmail(userDto.getAge());
		user.setName(userDto.getName());
		return userRepository.save(user);
	}



	@Override
	public Optional<User> getUser(Long id) {
		return userRepository.findById(id);
	}

	public List<User> getAllUser(){

		return userRepository.findAll();
	}
}
