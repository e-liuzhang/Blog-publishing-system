package com.edc.service.impl;

import java.util.List;

import com.edc.dao.UserDao;
import com.edc.dao.impl.UserDaoImpl;
import com.edc.entity.User;
import com.edc.service.ChangeUserInfoService;

public class ChangeUserInfoServiceImpl implements ChangeUserInfoService {

	@Override
	public int Update(User user) {
		UserDao ud=new UserDaoImpl();
		int ret= ud.Update(user);
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
