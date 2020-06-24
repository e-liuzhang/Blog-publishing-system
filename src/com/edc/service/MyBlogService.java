package com.edc.service;

import java.util.List;

import com.edc.entity.Blog;

public interface MyBlogService {
	List<Blog> getMy(String userId);
}
