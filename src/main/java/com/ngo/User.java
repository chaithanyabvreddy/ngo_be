package com.ngo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "user")
@JsonIgnoreProperties(ignoreUnknown = true)
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String firstName;
	private String lastName;
	private String emailId;
	private String aadharCard;
	private int phoneNumer;
	private String userName;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getAadharCard() {
		return aadharCard;
	}

	public void setAadharCard(String aadharCard) {
		this.aadharCard = aadharCard;
	}

	public int getPhoneNumer() {
		return phoneNumer;
	}

	public void setPhoneNumer(int phoneNumer) {
		this.phoneNumer = phoneNumer;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

}
