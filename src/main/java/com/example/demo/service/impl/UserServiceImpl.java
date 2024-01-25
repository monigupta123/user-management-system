package com.example.demo.service.impl;

import java.util.List;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.User;
import com.example.demo.model.Address;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public User saveUser(User user) {
		// TODO Auto-generated method stub
		
		//Generate discount on basis of user age
		Double discount = (double)0.10*user.getAge();
		user.setDiscount(discount);
		
		Address a = user.getAddress();
		a.setUser(user);
		user.setAddress(a);
		User u2=null;
		try {
			u2 = userRepository.save(user);
			
		} catch (RuntimeException r) {
			return new User();
		}
		return u2;
//		User u = userRepository.save(user);
//		if (u.getUserId() != null) {
//			return u;
//		} else {
//			return new User();
//		}
		
	}

	@Override
	public User getUserById(Long userId) {
		// TODO Auto-generated method stub
		Optional<User> user = userRepository.findById(userId);
		if (user.isEmpty()) {
			return new User();
		} else {
			return user.get();
		}
	}

	@Override
	public List<User> getAllUser() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

	@Override
	public List<User> findByDiscount(Double discount) {
		// TODO Auto-generated method stub
		return userRepository.findByDiscount(discount);
	
	}

	@Override
	public User updateUser(User u) {
		// TODO Auto-generated method stub
		return userRepository.save(u);
	}

	@Override
	public void deleteUser(User u) {
		userRepository.delete(u);
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		userRepository.deleteById(id);
	}
	
	
	
	
	
	
	
	

}
