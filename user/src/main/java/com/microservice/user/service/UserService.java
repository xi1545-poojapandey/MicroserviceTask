package com.microservice.user.service;

import com.microservice.user.model.User;
import com.microservice.user.model.UserDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface UserService {

	public Optional<User> getUser(Long id);
	public List<User> getAllUser();
	public User createUser(UserDto userDto);
}
