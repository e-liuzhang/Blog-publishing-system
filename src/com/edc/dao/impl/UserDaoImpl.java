package com.edc.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.edc.dao.UserDao;
import com.edc.entity.User;
import com.edc.dao.BaseDao;

public class UserDaoImpl implements UserDao {

	@Override
	public List<User> Query() {
		String sql="select * from ETC_USER";
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<User> list=new ArrayList<User>();
		try {
			conn=BaseDao.getConnection();
			pstmt=BaseDao.setParam(conn, sql);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				String userEmail=rs.getString("N_ID");
				String userName=rs.getString("U_NAME");
				String password=rs.getString("U_PWD");
				String bio=rs.getString("U_BIO");
				String avator=rs.getString("U_avator");
				int gender=rs.getInt("U_SEX");
				Date birthday=rs.getDate("U_BIRTHDAY");
				Date create_time=rs.getDate("U_CREATETIME");
				Date last_time=rs.getDate("U_UPDATETIME");
				String address=rs.getString("U_ADRESS");
				int status=rs.getInt("U_STATUS");
				list.add(new User(userEmail, userName, password, bio, avator, gender, birthday, create_time, last_time, address, status));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			BaseDao.closeAll(conn, pstmt, rs);
		}
		return list;
	}

	@Override
	public int Add(User user) {
		// TODO Auto-generated method stub
		String sql="insert into ETC_USER values(?,?,?,null,'img/avatar-default.png',-1,null,sysdate,null,null,3)";
		Connection conn=null;
		PreparedStatement pstmt=null;
		int result=0;
		try {
			conn=BaseDao.getConnection();
			pstmt=BaseDao.setParam(conn, sql,user.getUserEmail(),user.getUserName(),user.getPassword());
			 result=BaseDao.exeUpdate(pstmt);
			if (result>0) {
				System.out.println("插入成功");
			} else {
				System.out.println("插入失败");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			BaseDao.closeAll(conn, pstmt, null);
		}
		return result;
	}

	@Override

	public int Update(User user) {
 		String sql="update ETC_USER set U_NAME=?,U_BIRTHDAY=to_date(?,'yyyy-MM-dd'),U_BIO=?,U_ADDRESS=?,U_AVATOR=?,U_SEX=?  where U_ID=?";
 		System.out.println(user.getUserName()+user.getBirthday()+user.getBio()+user.getAddress()+user.getAvator()+user.getGender()+user.getUserEmail());
		Connection conn=null;
		PreparedStatement pstmt=null;
		int result=0;
		try {
			conn=BaseDao.getConnection();
			pstmt=BaseDao.setParam(conn,sql,user.getUserName(),new SimpleDateFormat("yyyy-MM-dd").format(user.getBirthday()),user.getBio(),user.getAddress(),user.getAvator(),user.getGender(),user.getUserEmail());
			result=BaseDao.exeUpdate(pstmt);
			if (result>0) {
				System.out.println("修改成功");
			} else {
				System.out.println("修改失败");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			BaseDao.closeAll(conn, pstmt, null);
		}
		return result;
	}

	@Override
	public List<User> QueryByEmail(String email) {
		String sql="select * from ETC_USER WHERE U_ID=?";
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<User> list=new ArrayList<User>(); 
		try {
			conn=BaseDao.getConnection();
			pstmt=BaseDao.setParam(conn, sql,email);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				String userEmail=rs.getString("U_ID");
				String userName=rs.getString("U_NAME");
				String password=rs.getString("U_PWD");
				String bio=rs.getString("U_BIO");
				String avator=rs.getString("U_avator");
				int gender=rs.getInt("U_SEX");
				Date birthday=rs.getDate("U_BIRTHDAY");
				Date create_time=rs.getDate("U_CREATETIME");
				Date last_time=rs.getDate("U_UPDATETIME");
				String address=rs.getString("U_ADDRESS");
				int status=rs.getInt("U_STATUS");
				list.add(new User(userEmail, userName, password, bio, avator, gender, birthday, create_time, last_time, address, status));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			BaseDao.closeAll(conn, pstmt, rs);
		}
		 
		return list;
	}

	@Override
	public List<User> QueryByName(String name) {
		String sql="select * from ETC_USER WHERE U_NAME=?";
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<User> list=new ArrayList<User>(); 
		try {
			conn=BaseDao.getConnection();
			pstmt=BaseDao.setParam(conn, sql,name);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				String userEmail=rs.getString("U_ID");
				String userName=rs.getString("U_NAME");
				String password=rs.getString("U_PWD");
				String bio=rs.getString("U_BIO");
				String avator=rs.getString("U_avator");
				int gender=rs.getInt("U_SEX");
				Date birthday=rs.getDate("U_BIRTHDAY");
				Date create_time=rs.getDate("U_CREATETIME");
				Date last_time=rs.getDate("U_UPDATETIME");
				String address=rs.getString("U_ADDRESS");
				int status=rs.getInt("U_STATUS");
				list.add(new User(userEmail, userName, password, bio, avator, gender, birthday, create_time, last_time, address, status));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			BaseDao.closeAll(conn, pstmt, rs);
		}
		 
		return list;
	}

	@Override
	public int UpdatePW(User user) {
 		String sql="update ETC_USER set U_PWD=? where U_ID=?";
		Connection conn=null;
		PreparedStatement pstmt=null;
		int result=0;
		try {
			conn=BaseDao.getConnection();
			pstmt=BaseDao.setParam(conn,sql,user.getPassword(),user.getUserEmail());
			result=BaseDao.exeUpdate(pstmt);
			if (result>0) {
				System.out.println("修改密码成功");
			} else {
				System.out.println("修改密码失败");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			BaseDao.closeAll(conn, pstmt, null);
		}
		return result;
	}

}
