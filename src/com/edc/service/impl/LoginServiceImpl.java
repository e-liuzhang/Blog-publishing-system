package com.edc.service.impl;

import java.util.List;

import com.edc.dao.UserDao;
import com.edc.dao.impl.UserDaoImpl;
import com.edc.entity.User;
import com.edc.service.LoginService;

public class LoginServiceImpl implements LoginService {

	@Override
	public List<User> CheckEmail(String email) {
		UserDao ud=new UserDaoImpl();
		List<User> list= ud.QueryByEmail(email);
		return list;
	}
	
}
