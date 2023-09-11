package com.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;


import com.user.entity.User;
import com.user.repository.UserRepository;

@Service
@Scope(value ="singleton")

public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public boolean isAdmin(User user) {
        return "admin".equalsIgnoreCase(user.getRole());
    }
    

	@Override
	public User addUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public User updateUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public User getUserById(Integer id) {
		return userRepository.findById(id).get();
	}

	@Override
	public void deleteUserById(Integer id) {
		userRepository.deleteById(id);
		
	}


	


	
	

}
