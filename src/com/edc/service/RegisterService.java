package com.edc.service;
import java.util.List;

import com.edc.entity.User;

public interface RegisterService {
	int Register(User user);
	List<User> CheckEmail(String email);
	List<User> CheckName(String name);
	
}
