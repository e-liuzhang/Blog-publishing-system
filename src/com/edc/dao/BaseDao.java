package com.edc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BaseDao {
	private static final String DRIVER="oracle.jdbc.driver.OracleDriver";
	private static final String URL="jdbc:oracle:thin:@localhost:1521:orcl";
	private static final String USERNAME="SCOTT";
	private static final String USERPWD="tiger";
	
	//获取连接对象
	public static Connection getConnection() {
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		Connection conn=null;
		try {
			conn = DriverManager.getConnection(URL, USERNAME, USERPWD);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	public static PreparedStatement setParam(Connection conn,String sql,Object...param) throws SQLException{
		PreparedStatement pstmt=null;
		pstmt=conn.prepareStatement(sql);
		for(int i=0;i<param.length;i++) {
			pstmt.setObject(i+1, param[i]);
		}
		return pstmt;
	}
	
	
	//增删改的通用方法
	public static int exeUpdate(PreparedStatement pstmt) throws SQLException  {
		int result=0;
			//增删改都是对数据库的记录进行更改，他们都是使用executeUpdate这个方法来完成，返回值都是受影响行数
		result=pstmt.executeUpdate();
		return result;
		
	}
	
	
	public static void closeAll(Connection conn,PreparedStatement pstmt,ResultSet rs) {
		try {
			if(pstmt!=null) {
				pstmt.close();
			}
			if(conn!=null) {
				conn.close();
			}
			if(rs!=null) {
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
