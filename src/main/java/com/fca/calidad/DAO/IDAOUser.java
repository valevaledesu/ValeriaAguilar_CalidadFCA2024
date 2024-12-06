package com.fca.calidad.DAO;

import java.util.List;

import com.fca.calidad.model.User;

public interface IDAOUser {
	User findByUserName(String name);

	int save(User user);

	User findUserByEmail(String email);

	List<User> findAll();

	User findById(int id);

	boolean deleteById(int id);

	User updateUser(User userOld);


}