package com.rest.webservices.restfulwebservices.controller;

import java.util.List;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import java.net.URI;

import com.rest.webservices.restfulwebservices.bean.*;

import com.rest.webservices.restfulwebservices.dao.UserService;
import com.rest.webservices.restfulwebservices.exceptions.UserNotFoundException;

@RestController
public class UserController {
	@Autowired
	private UserService userService;
	
	@GetMapping("/users")
	public List<User> retrieveAllUsers(){
		return userService.findAll();
	}
	
	@GetMapping("/users/{id}")
	public EntityModel<User> retrieveAUser(@PathVariable Integer id){
		User user = userService.findOne(id);
		if(user == null) {
			throw new UserNotFoundException("User with id "+id+" not found");
		}
		EntityModel<User> resource = EntityModel.of(user);
		WebMvcLinkBuilder linkTo = 
				linkTo(methodOn(this.getClass()).retrieveAllUsers());
		
		resource.add(linkTo.withRel("all-users"));
		
		//HATEOAS
		
		return resource;
	}
	
	@PostMapping("/users")
	public ResponseEntity<User> addUser( @Valid @RequestBody User user) {
		User savedUser = userService.saveUser(user);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId()).toUri();
		
		return ResponseEntity.created(location).build();
	}
	
	@DeleteMapping("/users/{id}")
	public void removeAUser(@PathVariable Integer id){
		User user = userService.deleteById(id);
		if(user == null) {
			throw new UserNotFoundException("User with id "+id+" not found");
		}
	}
}
