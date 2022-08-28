package com.example.bank.user;

import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.*;

@Entity(name= "users")
public class User {
	
	@Column(name= "userID",
			nullable= false,
			updatable= false)
	@Id
	private String userID;
	@Column(name= "firstName",
			nullable= false)
	private String firstName;
	@Column(name= "lastName",
			nullable= false)
	private String lastName;
	@Column(name= "email",
			nullable= false)
	private String email;
	@Column(name= "dob",
			nullable= false)
	private LocalDate dob;
	@Column(name= "pob",
			nullable= false)
	private String pob;
	@Column(name= "balance",
			nullable= false)
	private Long balance;
	
	public User()	{}
	public User(String userID, String firstName, String lastName, String email, LocalDate dob, String pob,
			Long balance) {
		super();
		this.userID= userID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.dob = dob;
		this.pob = pob;
		this.balance = balance;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public LocalDate getDob() {
		return dob;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	public String getPob() {
		return pob;
	}
	public void setPob(String pob) {
		this.pob = pob;
	}
	public Long getBalance() {
		return balance;
	}
	public void setBalance(Long balance) {
		this.balance = balance;
	}
	@Override
	public int hashCode() {
		return Objects.hash(balance, dob, email, firstName, lastName, pob, userID);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(balance, other.balance) && Objects.equals(dob, other.dob)
				&& Objects.equals(email, other.email) && Objects.equals(firstName, other.firstName)
				&& Objects.equals(lastName, other.lastName) && Objects.equals(pob, other.pob)
				&& Objects.equals(userID, other.userID);
	}
	@Override
	public String toString() {
		return "User [userID=" + userID + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", dob=" + dob + ", pob=" + pob + ", balance=" + balance + "]";
	}
	
	
}
