package com.edc.dao;

import java.util.List;

import com.edc.entity.User;


public interface UserDao {
//	查询所有用户
	public List<User> Query();
	
//	根据Email即主键查询用户
	public List<User> QueryByEmail(String email);	
	
//	根据name即主键查询用户
	public List<User> QueryByName(String name);	
//	添加用户
	public int Add(User user);
	
//更新用户信息
	public int Update(User user);
//修改密码	
	public int UpdatePW(User user);
}
