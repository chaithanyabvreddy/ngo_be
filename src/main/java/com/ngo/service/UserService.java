package com.ngo.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ngo.User;
import com.ngo.UserForm;
import com.ngo.dao.UserRepository;






@Service
public class UserService {
	@Autowired
	public UserRepository userRepository;

	public UserForm createUser(UserForm userForm) {
		User user = new User();
		BeanUtils.copyProperties(userForm, user);
		User savedPark = userRepository.save(user);
		userForm.setId(savedPark.getId());
		return userForm;
	}
	



}
