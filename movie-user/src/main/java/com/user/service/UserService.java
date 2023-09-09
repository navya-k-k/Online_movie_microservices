package com.user.service;


import java.util.List;

import com.user.entity.User;

public interface UserService {
	
	public User addUser(User user);
	public User updateUser(User user);
	public List<User> getAllUsers ();
	public User getUserById (Integer id);
	public void deleteUserById (Integer id);
	public boolean isAdmin(User user);
	}
