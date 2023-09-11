package com.user.controller;


import java.util.List;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


import com.user.entity.User;
import com.user.service.UserService;

@RestController
@Scope(value = "request")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	private Logger log = LoggerFactory.getLogger(UserController.class);
	
	
	@GetMapping(value = "/user/{id}/isAdmin", produces = { MediaType.APPLICATION_JSON_VALUE })
    public boolean isAdmin(@PathVariable("id") Integer id) {
        User user = userService.getUserById(id);
        if (user != null) {
            return userService.isAdmin(user);
        }
        return false;
    }
	
	
	
	
	@PostMapping(value = "/user", produces = {MediaType.APPLICATION_JSON_VALUE}, 
			consumes = {MediaType.APPLICATION_JSON_VALUE})
	@ResponseStatus(code = HttpStatus.CREATED)
	public User addUser(@RequestBody User user) {
		log.debug("Received a request to add a user: " + user);
		User addedUser = userService.addUser(user);
		log.info("User added: ", addedUser);
		return addedUser;
	}
		
		
		
		@PutMapping(value = "/user", produces = {MediaType.APPLICATION_JSON_VALUE}, 
				consumes = {MediaType.APPLICATION_JSON_VALUE})
		@ResponseStatus(code = HttpStatus.OK)
		public User updateUser(@RequestBody User user) {
			log.debug("Received a request to update a user: " + user);
			User updatedUser = userService.updateUser(user);
			log.info("User updated: ", updatedUser);
			return updatedUser;
		}
    
	
	
	
	
	
	
	
	
	
	@DeleteMapping(value = "/user/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void deleteUserById(@PathVariable("id") Integer id) {
		log.debug("Received a request to delete a user with id: " + id);
		userService.deleteUserById(id);
		log.info("User deleted with id: ", id);
	}
	
	@GetMapping(value = "/user/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
	public User getUserById(@PathVariable("id") Integer id) {
		log.debug("Received a request to get a user with id: " + id);
		User userById = userService.getUserById(id);
		log.info("Return Value: ", userById);
		return userById;
	}
	
	@GetMapping(value = "/user", produces = {MediaType.APPLICATION_JSON_VALUE})
	public List<User> getAlluser() {
		log.debug("Received a request to view all Users");
		 List<User> allUser = userService.getAllUsers();
		 log.info("All Users Return Value: " + allUser);
		 return allUser;
		
	}
	
	
}
