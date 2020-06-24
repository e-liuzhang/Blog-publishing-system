package com.edc.entity;

import java.util.Date;

public class User {
	 private String userEmail;
	 private String userName;
	 private String password;
	 private String bio;
	 private String avator;
	 private int gender;
	 private Date birthday;
	 private Date create_time;
	 private Date last_time;
	 private String address;
	 private int status;
	 public User() {
	  super();
	 }
	 public User(String userEmail, String userName, String password, String bio, String avator, int gender,
	   Date birthday, Date create_time, Date last_time, String adress, int status) {
	  super();
	  this.userEmail = userEmail;
	  this.userName = userName;
	  this.password = password;
	  this.bio = bio;
	  this.avator = avator;
	  this.gender = gender;
	  this.birthday = birthday;
	  this.create_time = create_time;
	  this.last_time = last_time;
	  this.address = adress;
	  this.status = status;
	 }
	 public String toString() {
	  return "User [userEmail=" + userEmail + ", userName=" + userName + ", password=" + password + ", bio=" + bio
	    + ", avator=" + avator + ", gender=" + gender + ", birthday=" + birthday + ", create_time="
	    + create_time + ", last_time=" + last_time + ", address=" + address + ", status=" + status + "]";
	 }
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getBio() {
		return bio;
	}
	public void setBio(String bio) {
		this.bio = bio;
	}
	public String getAvator() {
		return avator;
	}
	public void setAvator(String avator) {
		this.avator = avator;
	}
	public int getGender() {
		return gender;
	}
	public void setGender(int gender) {
		this.gender = gender;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public Date getCreate_time() {
		return create_time;
	}
	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}
	public Date getLast_time() {
		return last_time;
	}
	public void setLast_time(Date last_time) {
		this.last_time = last_time;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String adress) {
		this.address = adress;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
}