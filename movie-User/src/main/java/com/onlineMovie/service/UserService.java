package com.onlineMovie.service;


import java.util.List;

import com.onlineMovie.entity.User;

public interface UserService {
    User registerUser(User user);
    
    User loginUser(String username, String password);
    
    List<User> getAllUsers();
    
    User getUserById(Integer userId);
    
    User updateUser(Integer userId, User user);
    
    void deleteUser(Integer userId);
}
