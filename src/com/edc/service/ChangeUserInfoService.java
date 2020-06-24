package com.edc.service;

import java.util.List;

import com.edc.entity.User;

public interface ChangeUserInfoService {
	int Update(User user);
	List<User> CheckEmail(String email);
	List<User> CheckName(String name);
}
