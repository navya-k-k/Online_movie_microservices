package com.onlineMovie.service;

import com.onlineMovie.entity.User;
import com.onlineMovie.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class UserService {
    @Autowired

    private final UserRepo userRepo;
    
    

    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public User registerUser(User user) {
        if (!isEmailValid(user.getEmail())) {
            throw new IllegalArgumentException("Invalid email format");
        }

         return userRepo.save(user);
    }

    public User registerAdmin(User admin) {
        if (!isEmailValid(admin.getEmail())) {
            throw new IllegalArgumentException("Invalid email format");
        }

        return userRepo.save(admin);
    }

    public List<User> getAllUsers() {
        return (List<User>) userRepo.findAll();
    }

    public User getUserById(Integer id) {
        Optional<User> user = userRepo.findById(id);
        return user.orElse(null);
    }

    public User updateUser(Integer id, User updatedUser) {
        Optional<User> user = userRepo.findById(id);
        if (user.isPresent()) {
            User existingUser = user.get();
            
            existingUser.setUsername(updatedUser.getUsername());
            existingUser.setEmail(updatedUser.getEmail());
            
            return userRepo.save(existingUser);
        }
        return null;
    }

    public void deleteUser(Integer id) {
        userRepo.deleteById(id);
    }

    private boolean isEmailValid(String email) {
        String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    
}
