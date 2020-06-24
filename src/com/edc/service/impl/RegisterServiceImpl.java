package com.edc.service.impl;

import java.util.List;

import com.edc.dao.UserDao;
import com.edc.dao.impl.UserDaoImpl;
import com.edc.entity.User;
import com.edc.service.RegisterService;

public class RegisterServiceImpl implements RegisterService {

	@Override
	public int Register(User user) {
		// TODO Auto-generated method stub
		UserDao ud=new UserDaoImpl();
		int ret= ud.Add(user);
		return ret;
	}

	@Override
	public List<User> CheckEmail(String email) {
		// TODO Auto-generated method stub
		UserDao ud=new UserDaoImpl();
		List<User> list= ud.QueryByEmail(email);
		return list;
	}

	@Override
	public List<User> CheckName(String name) {
		// TODO Auto-generated method stub
		UserDao ud=new UserDaoImpl();
		List<User> list= ud.QueryByName(name);
		return list;
	}
	

}
