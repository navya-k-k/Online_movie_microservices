package com.user.proxy;


import java.util.ArrayList;


import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.user.entity.User;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;

@FeignClient(name="movie-user") // same as application name in movie-movie application.properties
public interface UserConsumerProxy {

	
	@Retry(name = "user-consumer")
	@CircuitBreaker(name="user-consumer", fallbackMethod="fallbackMethodForGetUserById")
	@GetMapping(value = "/user/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
	public User getUserById(@PathVariable("id") Integer id);

	@Retry(name = "user-consumer")
	@CircuitBreaker(name="user-consumer", fallbackMethod="fallbackMethodForGetAllUsers")
	@GetMapping(value = "/user", produces = {MediaType.APPLICATION_JSON_VALUE})
	public List<User> getAlluser();
	
	
	@Retry(name = "user-consumer")
	@CircuitBreaker(name="user-consumer", fallbackMethod="fallbackMethodForDeleteUserById")
	@DeleteMapping(value = "/user/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void deleteUserById(@PathVariable("id") Integer id);
	
	@Retry(name = "user-consumer")
	@CircuitBreaker(name="user-consumer", fallbackMethod="samplefallbackMethod")
	@PutMapping(value = "/user", produces = {MediaType.APPLICATION_JSON_VALUE}, 
			consumes = {MediaType.APPLICATION_JSON_VALUE})
	@ResponseStatus(code = HttpStatus.OK)
	public User updateUser(@RequestBody User user);
	
	@Retry(name = "user-consumer")
	@CircuitBreaker(name="user-consumer", fallbackMethod="samplefallbackMethod")
	@PostMapping(value = "/user", produces = {MediaType.APPLICATION_JSON_VALUE}, 
			consumes = {MediaType.APPLICATION_JSON_VALUE})
	@ResponseStatus(code = HttpStatus.CREATED)
	public User addUser(@RequestBody User user);
	
	
	@Retry(name = "user-consumer")
	@CircuitBreaker(name = "user-consumer", fallbackMethod = "fallbackMethodForCheckIfUserIsAdmin")
	@GetMapping(value = "/user/{id}/isAdmin", produces = { MediaType.APPLICATION_JSON_VALUE })
	public boolean checkIfUserIsAdmin(@PathVariable("id") Integer id);

	
	
	
	
	
	
	
    
    
	

	public default List<User> fallbackMethodForGetAllUsers(Throwable cause) {
		System.out.println("Exception raised with message: ===> " + cause.getMessage());
		return new ArrayList<User>();
	}
	
	public default User fallbackMethodForGetUserById(Integer id, Throwable cause) {
		System.out.println("Exception raised with message: ===> " + cause.getMessage());
		
		User fallbackUser = new User(id, "Invalid name (Fall Back User)", "Invalid password", "invalid@example.com",
				 "invalid firstname","invalid last name", "000-000-0000", "invalid address","invalid role");
		return fallbackUser;
	}
	
	public default void fallbackMethodForDeleteUserById(Integer id, Throwable cause) {
		System.out.println("Exception raised with message: ===> " + cause.getMessage());

	}
	
	public default User samplefallbackMethod(User user, Throwable cause) {
		System.out.println("Exception raised with message: ===> " + cause.getMessage());
	
		User fallbackUser = new User(null, "Invalid name (Fall Back User)", "Invalid password", "invalid@example.com",
				 "invalid firstname","invalid lastname", "000-000-0000", "invalid address","invalid role");
		return fallbackUser;
	}
	
	public default boolean fallbackMethodForCheckIfUserIsAdmin(Integer id, Throwable cause) {
	    System.out.println("Exception raised with message: ===> " + cause.getMessage());
	    return false; // Return false as a fallback value when there's an issue or exception
	}

	
	

}
