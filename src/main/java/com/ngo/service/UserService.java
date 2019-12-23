package com.ngo.service;

import java.util.List;

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
	
	
	public UserForm getUserByUserName(String userName) {
		UserForm userForm = new UserForm();
		List<User> users = userRepository.getUserByUserName(userName);
		if (users.size() != 1) {
			userForm.setErrorMessage("user/password does not exist");
			return userForm;
		} else {
			User user = users.get(0);
			BeanUtils.copyProperties(user, userForm);
			return userForm;
		}

	}
	
	public UserForm getUserByUserNameAndPassword(UserForm userForm) {
		List<User> users = userRepository.getUserByUserNameAndPassword(userForm.getUserName(),
				userForm.getPassword());
		if (users.size() != 1) {
			userForm.setErrorMessage("user/password does not exist");
			return userForm;
		} else {
			User user = users.get(0);
			BeanUtils.copyProperties(user, userForm);
			return userForm;
		}

	}




}
