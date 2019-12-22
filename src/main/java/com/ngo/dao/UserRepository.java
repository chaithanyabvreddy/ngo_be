package com.ngo.dao;

import org.springframework.data.repository.CrudRepository;

import com.ngo.User;



public interface UserRepository extends CrudRepository<User, Long>{

}
