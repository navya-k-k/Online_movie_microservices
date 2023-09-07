package com.onlineMovie.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.onlineMovie.service.UserService;


import com.onlineMovie.entity.User;
import com.onlineMovie.repository.UserRepo;

@Service
@Transactional
public class UserServiceImplementation implements UserService {

    @Autowired
    private UserRepo userRepo;
    
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public User registerUser(User user) {
        String validationErrors = validateUser(user);

        if (!validationErrors.isEmpty()) {
            
        	return null;
        }

        user.setPassword(passwordEncoder.encode(user.getPassword()));

       
        return userRepo.save(user);
    }
 // Validate user data 
    private String validateUser(User user) {
        StringBuilder validationErrors = new StringBuilder();

        if (user == null) {
            validationErrors.append("User object is null.\n");
        }

        if (StringUtils.isEmpty(user.getUsername())) {
            validationErrors.append("Username is required.\n");
        }

        if (StringUtils.isEmpty(user.getPassword())) {
            validationErrors.append("Password is required.\n");
        }

        if (StringUtils.isEmpty(user.getEmail())) {
            validationErrors.append("Email is required.\n");
        } else if (!user.getEmail().matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
            validationErrors.append("Invalid email format.\n");
        }

        if (StringUtils.isEmpty(user.getFirstName())) {
            validationErrors.append("First name is required.\n");
        }

        if (StringUtils.isEmpty(user.getLastName())) {
            validationErrors.append("Last name is required.\n");
        }
        if (user.getPhoneNo() == null) {
            validationErrors.append("Phone number is required.\n");
        }

        if (StringUtils.isEmpty(user.getAddress())) {
            validationErrors.append("Address is required.\n");
        }

        if (StringUtils.isEmpty(user.getRole())) {
            validationErrors.append("Role is required.\n");
        }

        return validationErrors.toString();
    }

    @Override
    public User loginUser(String username, String password) {
        if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password)) {
            
            return null;
        }

        User user = userRepo.findByUsername(username);

        if (user == null) {
            
            return null;
        }

        
        if (password.equals(user.getPassword())) {
            return user; 
        } else {
           
            return null;
        }
    }

    @Override
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    @Override
    public User getUserById(Integer userId) {
        return userRepo.findById(userId).orElse(null);
    }

    @Override
    public User updateUser(Integer userId, User user) {
        User existingUser = userRepo.findById(userId).orElse(null);
        if (existingUser != null) {
            
            existingUser.setFirstName(user.getFirstName());
            existingUser.setLastName(user.getLastName());
            

            return userRepo.save(existingUser);
        }
        return null;
    }

    @Override
    public void deleteUser(Integer userId) {
        userRepo.deleteById(userId);
    }
}
