package com.ngo.controller;

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
	@RequestMapping(value = "/getUserDetails", method = RequestMethod.GET)
	public ResponseEntity<UserForm> getUserDetails(@RequestParam(name = "userName") String userName) {
		//dcumenting what this method does
		UserForm userForm = userService.getUserByUserName(userName);
		if (userForm.getErrorMessage() != null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(userForm);
		} else {
			return ResponseEntity.status(HttpStatus.OK).body(userForm);
		}

	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = "/createUser", method = RequestMethod.POST)
	public ResponseEntity<UserForm> createUser(@RequestBody UserForm userForm) {
		System.out.println(userForm);
		UserForm savedUserForm = userService.createUser(userForm);
		return ResponseEntity.status(HttpStatus.OK).body(savedUserForm);
	}
	

	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = "/authenticateUser", method = RequestMethod.POST)
	public ResponseEntity<UserForm> getUserByUserNameAndPassword(@RequestBody UserForm userForm) {
		System.out.println(userForm);
		UserForm savedUserForm = userService.getUserByUserNameAndPassword(userForm);
		if (savedUserForm.getErrorMessage() != null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(savedUserForm);
		} else {
			return ResponseEntity.status(HttpStatus.OK).body(savedUserForm);
		}
	}
	
}
