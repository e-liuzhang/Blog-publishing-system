package com.edc.service.impl;

import com.edc.dao.BlogDao;
import com.edc.dao.UserDao;
import com.edc.dao.impl.BlogDaoImpl;
import com.edc.dao.impl.UserDaoImpl;
import com.edc.entity.Blog;
import com.edc.service.WriteService;

public class WriteServiceImpl implements WriteService {

	@Override
	public int Write(Blog blog) {
		// TODO Auto-generated method stub
		BlogDao bd=new BlogDaoImpl();
		int ret= bd.Add(blog);
		return ret;
	}

}
