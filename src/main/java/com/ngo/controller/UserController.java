package com.ngo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ngo.UserForm;
import com.ngo.service.UserService;




@RestController
public class UserController {
	@Autowired
	public UserService userService;

	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = "/createUser", method = RequestMethod.POST)
	public ResponseEntity<UserForm> createUser(@RequestBody UserForm userForm) {
		System.out.println(userForm);
		UserForm savedUserForm = userService.createUser(userForm);
		return ResponseEntity.status(HttpStatus.OK).body(savedUserForm);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = "/getAllUsers", method = RequestMethod.GET)
	public ResponseEntity<List<UserForm>> getAllUsers() {

		List<UserForm> userFormList = userService.getAllUsers();
		return ResponseEntity.status(HttpStatus.OK).body(userFormList);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = "/deleteUser", method = RequestMethod.GET)
	public boolean delete(@RequestParam(name = "id") Long id) {
	boolean isdeleted =	userService.delete(id);
		return isdeleted;
	}
	

}
