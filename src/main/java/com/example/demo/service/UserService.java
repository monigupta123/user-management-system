package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.User;

@Service
public interface UserService {
	
	User saveUser(User user);
	
	User getUserById(Long userId);
	
	List<User> getAllUser();
	
	List<User> findByDiscount(Double discount);
	
	User updateUser(User u);
	
	void deleteUser(User u);
	
	void deleteById(Long id);

}
