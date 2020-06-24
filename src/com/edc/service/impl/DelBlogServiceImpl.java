package com.edc.service.impl;


import com.edc.dao.BlogDao;
import com.edc.dao.impl.BlogDaoImpl;
import com.edc.service.DelBlogService;

public class DelBlogServiceImpl implements DelBlogService {

	@Override
	public int Del(String id) {
		BlogDao bd=new BlogDaoImpl();
		int ret= bd.Del(id);
		return ret;
	}

}
