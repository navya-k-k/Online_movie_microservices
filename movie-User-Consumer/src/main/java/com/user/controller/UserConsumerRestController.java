package com.user.controller;

import java.util.List;


//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.user.entity.User;
import com.user.proxy.UserConsumerProxy;

@RestController
@Scope("request")
public class UserConsumerRestController {
	
	@Autowired
	private UserConsumerProxy userconsumerproxy;
	
	//private Logger log = LoggerFactory.getLogger(MovieConsumerRestController.class);
	
	@GetMapping("/get-user/{id}")
	public User getUserById(@PathVariable("id") int id) {
	
		//log.debug("In getMovieById with Id: " + id);
		User user = userconsumerproxy.getUserById(id);
		//log.debug("In getMovieById with return value Employee: " + movie);
		return user;
	}

	@GetMapping("/get-users")
	public List<User> getAllUsers() {
	
		List<User> users = userconsumerproxy.getAlluser();
		//log.debug("In getAllMovies with return value Movies: " + movies);
		return users;
		
	}
	
	@DeleteMapping("/delete-user/{id}")
	public void deleteUserById(@PathVariable("id") Integer id) {
		//log.debug("Request recieved to delete a Movie with Id: " + id);
		userconsumerproxy.deleteUserById(id);
	}
	
	@PostMapping("/add-user")
	public User addUser(@RequestBody User user) {
		//log.debug("Request recieved to add an Employee: " + movie);
		return userconsumerproxy.addUser(user);
	}
	
	@GetMapping("/check-user-admin/{id}")
    public boolean checkIfUserIsAdmin(@PathVariable("id") Integer id) {
        // Use the Feign client to check if the user is an admin
        return userconsumerproxy.checkIfUserIsAdmin(id);
    }
	
	
	@PutMapping("/update-user")
	public User updateUser(@RequestBody User user) {
		//log.debug("Request recieved to update an Employee: " + movie);
		return userconsumerproxy.updateUser(user);
	}
	
	
	
	
	
	
	
}
