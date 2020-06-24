package com.edc.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.edc.dao.BaseDao;
import com.edc.dao.BlogDao;
import com.edc.entity.Blog;

public class BlogDaoImpl implements BlogDao {

	@Override
	public List<Blog> Query() {
		String sql="select * from ETC_BLOG inner join ETC_USER on (ETC_BLOG.U_ID=ETC_USER.U_ID) order by B_CREATETIME DESC";
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<Blog> list=new ArrayList<Blog>();
		try {
			conn=BaseDao.getConnection();
			pstmt=BaseDao.setParam(conn, sql);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				int id=rs.getInt("B_ID");	
				String title=rs.getString("B_TITLE");
				Timestamp createTime=rs.getTimestamp("b_createTime");
				String introduction=rs.getString("b_Introduction");
				String content=rs.getString("b_content");
				String lable=rs.getString("b_lable");
				String uId=rs.getString("u_id");
				String uName=rs.getString("u_name");
				String uAvator=rs.getString("u_avator");
				String uAdress=rs.getString("u_address");
				list.add(new Blog(id, title, createTime, introduction, content, lable, uId,uName,uAvator,uAdress));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			BaseDao.closeAll(conn, pstmt, rs);
		}
		return list;
	}

	@Override
	public List<Blog> QueryByUid(String userId) {
		String sql="select * from ETC_BLOG inner join ETC_USER on (ETC_BLOG.U_ID=ETC_USER.U_ID) WHERE ETC_BLOG.U_ID=? order by B_CREATETIME DESC";
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<Blog> list=new ArrayList<Blog>();
		try {
			conn=BaseDao.getConnection();
			pstmt=BaseDao.setParam(conn, sql,userId);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				int id=rs.getInt("B_ID");
				String title=rs.getString("B_TITLE");
				Timestamp createTime=rs.getTimestamp("b_createTime");
				String introduction=rs.getString("b_Introduction");
				String content=rs.getString("b_content");
				String lable=rs.getString("b_lable");
				String uId=rs.getString("u_id");
				String uName=rs.getString("u_name");
				String uAvator=rs.getString("u_avator");
				String uAdress=rs.getString("u_address");
				list.add(new Blog(id, title, createTime, introduction, content, lable, uId,uName,uAvator,uAdress));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			BaseDao.closeAll(conn, pstmt, rs);
		}
		return list;
	}

	@Override
	public int Add(Blog blog) {
		// TODO Auto-generated method stub
		String sql="insert into ETC_BLOG values(seq_blogs.nextval,?,sysdate,?,?,?,?)";
		Connection conn=null;
		PreparedStatement pstmt=null;
		int result=0;
		try {
			conn=BaseDao.getConnection();
			pstmt=BaseDao.setParam(conn, sql,blog.getTitle(),blog.getIntroduction(),blog.getContent(),blog.getLable(),blog.getuId());
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
	public int Edit(Blog blog) {
		// TODO Auto-generated method stub
		String sql="update ETC_BLOG set B_TITLE=?,B_INTRODUCTION=?,B_CONTENT=?,B_LABLE=? where B_ID=?";
//		String sql="insert into ETC_BLOG values(seq_blogs.nextval,?,sysdate,?,?,?,?)";
		Connection conn=null;
		PreparedStatement pstmt=null;
		int result=0;
		try {
			conn=BaseDao.getConnection();
			pstmt=BaseDao.setParam(conn, sql,blog.getTitle(),blog.getIntroduction(),blog.getContent(),blog.getLable(),blog.getId());
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
	public int Del(String id) {
		String sql="delete from ETC_BLOG where B_ID=?";
		Connection conn=null;
		PreparedStatement pstmt=null;
		int result=0;
		try {
			conn=BaseDao.getConnection();
			pstmt=BaseDao.setParam(conn, sql,id);
			 result=BaseDao.exeUpdate(pstmt);
			if (result>0) {
				System.out.println("删除成功");
			} else {
				System.out.println("删除失败");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			BaseDao.closeAll(conn, pstmt, null);
		}
		return result;
	}

	public static void main(String[] args) {
		/*Blog blog=new Blog();
		BlogDao bd=new BlogDaoImpl();
		blog.setTitle("11");
		blog.setIntroduction("11");
		blog.setContent("111");
		blog.setLable("1212");
		blog.setuId("1");
		int a=bd.Add(blog);
		System.out.println(a);*/

	}

}
