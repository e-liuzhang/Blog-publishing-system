package com.edc.service.impl;

import com.edc.dao.UserDao;
import com.edc.dao.impl.UserDaoImpl;
import com.edc.entity.User;
import com.edc.service.ChangePWDService;

public class ChangePWDServiceImpl implements ChangePWDService {

	@Override
	public int UpdatePW(User user) {
		UserDao ud=new UserDaoImpl();
		int ret= ud.UpdatePW(user);
		return ret;
	}

}
