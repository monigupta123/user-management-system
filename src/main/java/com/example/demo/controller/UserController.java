package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.User;
import com.example.demo.service.UserService;

@RestController
@RequestMapping(path="/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping(path="/save")
	public ResponseEntity<User> saveUser(@RequestBody User user) {
		User u = userService.saveUser(user);
		return new ResponseEntity<>(u, HttpStatus.CREATED);
	}
	
	@GetMapping(path="/all")
	public ResponseEntity<List<User>> getAllUser() {
		List<User> users = userService.getAllUser();
		return new ResponseEntity<>(users, HttpStatus.OK);
	}
	
	@GetMapping(path="/{userId}")
	public ResponseEntity<User> findById(@PathVariable Long userId) {
		User u = userService.getUserById(userId);
		return new ResponseEntity<> (u, HttpStatus.OK);
	}
	
	@GetMapping(path="/discount")
	public ResponseEntity<List<User>> findByDiscount(@RequestParam(name= "value") Double discount) {
		List<User> users = userService.findByDiscount(discount);
		return new ResponseEntity<> (users, HttpStatus.OK);
	}
	
	@PutMapping(path="/update")
	public ResponseEntity<User> updateUser(@RequestBody User user) {
		User u = userService.updateUser(user);
		return new ResponseEntity<>(u, HttpStatus.CREATED);
	}
	
	@DeleteMapping(path="/{userId}")
	public ResponseEntity<Void> deleteById(@PathVariable Long userId) {
		userService.deleteById(userId);
		return new ResponseEntity<> (HttpStatus.CREATED);
	}
	

	@DeleteMapping(path="/delete")     
	public ResponseEntity<Void> deleteUser(@RequestBody User user) {
		userService.deleteUser(user);
		return new ResponseEntity<> (HttpStatus.CREATED);
	}
}
