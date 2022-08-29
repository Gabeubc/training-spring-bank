package com.example.bank.user;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	
	static private Integer countID = 0;
	final private UserRepository userRepository;
	
	@Autowired
	public UserService(UserRepository userRepository)
	{
		this.userRepository=userRepository;
	}
	
	public List<User> getUsers()
	{
		return this.userRepository.findAll();
	}
	
	public User getUser(String email) throws Exception
	{
		if(!this.userRepository.findUserByEmail(email).isPresent())
			throw new Exception("there is no user associated to this email");
		return this.userRepository.findUserByEmail(email).get();
	}
	
	public String createUser(User user)throws Exception
	{
		String userID;
		countID++;
		userID="UX";
		for (int i=0 ; i< 6 - countID.toString().length(); i++)
			userID=userID + "0";
		userID=userID + countID;
		user.setUserID(userID);
		user.setBalance(0L);
		this.userRepository.save(user);
		if(!this.userRepository.findUserByEmail(user.getEmail()).isPresent())
			throw new Exception("An error occcured during the creation of you accoun. Please try again!");
		return "Welcome " + user.getFirstName();
	}
	
	@Transactional
	public String addMoney(String userID, Long balance)
	{
		try {
			this.userRepository.findById(userID).get().setBalance(this.userRepository.findById(userID).get().getBalance() + balance);
		}
		catch(Exception e)
		{
			System.out.println("error during add money");
		}
		return "end";
	}
}
