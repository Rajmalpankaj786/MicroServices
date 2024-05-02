package com.masai.user.Controller;

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
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.PutExchange;

import com.masai.user.Entity.User;
import com.masai.user.Service.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserController {
 
	@Autowired
	private UserService service;
	
	@PostMapping
	public ResponseEntity<User> addUser(@RequestBody User user){
	return new ResponseEntity<User>(service.addUser(user) , HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<User>> viewAllUser(){
		return new ResponseEntity<List<User>>(service.ViewAllUser() , HttpStatus.OK);
	}
	
	@GetMapping(value = "/{userId}")
	public ResponseEntity<User> viewUserById(@PathVariable String userId){
		return new ResponseEntity<User>(service.findById(userId),HttpStatus.OK);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<User> updateUser(@RequestBody User user ,@PathVariable String id){
		
		return new ResponseEntity<User>(service.updateUser(user, id) ,HttpStatus.OK) ;
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<User> deleteUser(@PathVariable String id){
		return new ResponseEntity<User>(service.deleteUser(id), HttpStatus.OK);
	}
}
