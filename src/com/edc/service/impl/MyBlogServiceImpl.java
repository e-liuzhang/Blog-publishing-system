package com.edc.service.impl;

import java.util.List;

import com.edc.dao.BlogDao;
import com.edc.dao.impl.BlogDaoImpl;
import com.edc.entity.Blog;
import com.edc.service.MyBlogService;

public class MyBlogServiceImpl implements MyBlogService {

	@Override
	public List<Blog> getMy(String userId) {
		BlogDao bd=new BlogDaoImpl();
		List<Blog> list=bd.QueryByUid(userId);
		return list;
	}

}
