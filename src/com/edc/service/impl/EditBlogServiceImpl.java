package com.edc.service.impl;

import com.edc.dao.BlogDao;
import com.edc.dao.impl.BlogDaoImpl;
import com.edc.entity.Blog;
import com.edc.service.EditBlogService;

public class EditBlogServiceImpl implements EditBlogService {

	@Override
	public int Edit(Blog blog) {
		BlogDao bd=new BlogDaoImpl();
		int ret=bd.Edit(blog);
		return ret;
		
	}

}
