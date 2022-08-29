package com.example.bank.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping (path="api/v1/user")
public class UserController {
	
	final private UserService userService;

	@Autowired
	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	@GetMapping
	public List<User> getUsers()
	{
		return this.userService.getUsers();
	}
	
	@GetMapping(params="email")
	public User getUser(@RequestParam(name ="email") String email) throws Exception
	{
		return this.userService.getUser(email);
	}
	
	@PostMapping
	public String createUser(@RequestBody User user) throws Exception
	{
		return this.userService.createUser(user);
	}
	
	@PutMapping("/{userID}")
	public String addMoney(@PathVariable String userID, @RequestBody Long amount)
	{
		return this.userService.addMoney(userID, amount);
	}
	

}
