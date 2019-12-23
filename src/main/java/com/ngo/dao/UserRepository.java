package com.ngo.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.ngo.User;

public interface UserRepository extends CrudRepository<User, Long> {

	public List<User> getUserByUserNameAndPassword(String userName, String password);

	public List<User> getUserByUserName(String userName);

}
