package com.edc.dao;

import java.util.List;
import com.edc.entity.Blog;

public interface BlogDao {
//	查询所有博客
	public List<Blog> Query();
//	查询个人博客
	public List<Blog> QueryByUid(String userId);
	
//	写博客
	public int Add(Blog blog);
	
//	编辑博客
	public int Edit(Blog blog);
	
//	删除博客
	public int Del(String id);
}
