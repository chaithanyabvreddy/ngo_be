package com.ngo.service;

import java.util.ArrayList;
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
	
	public List<UserForm> getAllUsers() {

		Iterable<User> userList = userRepository.findAll();
		List<UserForm> userformList = new ArrayList<UserForm>();

		for (User temp : userList) {
			UserForm userForm = new UserForm();
			BeanUtils.copyProperties(temp, userForm);
			userformList.add(userForm);
		}
		return userformList;
	}
	
	public boolean delete(Long id) {
		try {
			userRepository.delete(id);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	


}
