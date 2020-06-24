package com.edc.service;

import java.util.List;

import com.edc.entity.User;

public interface LoginService {
	List<User> CheckEmail(String email);
}
