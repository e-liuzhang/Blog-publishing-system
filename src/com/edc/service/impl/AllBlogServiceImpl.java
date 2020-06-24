package com.edc.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.edc.dao.BlogDao;
import com.edc.dao.impl.BlogDaoImpl;
import com.edc.entity.Blog;
import com.edc.service.AllBlogService;

public class AllBlogServiceImpl implements AllBlogService {

	@Override
	public List<Blog> getALL() {
		BlogDao bd=new BlogDaoImpl();
		List<Blog> list=bd.Query();
	
		return list;
	 
	}

}
