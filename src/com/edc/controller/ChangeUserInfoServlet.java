package com.edc.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.alibaba.dubbo.common.utils.IOUtils;
import com.alibaba.fastjson.JSON;
import org.json.JSONObject;
import com.edc.entity.User;
import com.edc.service.ChangeUserInfoService;
import com.edc.service.impl.ChangeUserInfoServiceImpl;

/**
 * Servlet implementation class ChangeUserInfoServlet
 */
@WebServlet("/ChangeUserInfoServlet")
public class ChangeUserInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangeUserInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		response. setCharacterEncoding("UTF-8");
		ChangeUserInfoService cuis=new ChangeUserInfoServiceImpl();
		SimpleDateFormat sd =   new SimpleDateFormat( "yyyy-MM-dd" );
		User user=new User();
		BufferedReader reader = new BufferedReader(new InputStreamReader(request.getInputStream(), "UTF-8"));
		String body = IOUtils.read(reader);
		System.out.println("输入内容："+body);
		JSONObject jsonObj;
		try {
			jsonObj = new JSONObject(body);		
			PrintWriter out = response.getWriter();
			String putUsername=(String)jsonObj.get("username");
			String putBirthday=(String)jsonObj.get("birthday");
			String putBio=(String)jsonObj.get("bio");
			String putAddress=(String)jsonObj.get("address");
			String putAvator=(String)jsonObj.get("avator");
			String putGender=(String) jsonObj.get("gender");
 			List<User> userName=cuis.CheckName(putUsername);
 			// 获取session
			HttpSession session = request.getSession();
			// 获取session传过来的值
			String userInfo=request.getSession().getAttribute("user").toString();
			JSONObject userJSON=new JSONObject(userInfo);
 			if(userName.size()>0 && !userName.get(0).getUserName().equals((String) userJSON.get("userName"))) {
 				out.write("1");
 			}else {
 		
		  		userJSON.put("userName",putUsername);
				userJSON.put("birthday",putBirthday);
				userJSON.put("bio",putBio);
				userJSON.put("address",putAddress);
				userJSON.put("avator",putAvator); 
				userJSON.put("last_time",sd.format(new Date()));
				userJSON.put("gender",putGender);
				
				List<User> userEmail=cuis.CheckEmail((String) userJSON.get("userEmail"));
				System.out.println("userJSON"+userJSON);
			 
	//这里设计繁琐，待改进
				user.setUserEmail((String) userJSON.get("userEmail"));
				user.setUserName((String) userJSON.get("userName"));
				user.setPassword((String) userJSON.get("password"));
				user.setBio((String) userJSON.get("bio"));
				user.setAvator((String) userJSON.get("avator"));
				user.setGender(Integer.valueOf((String) userJSON.get("gender")));
				String birthday=(String) userJSON.get("birthday");			 
				user.setBirthday(sd.parse(birthday));
				user.setCreate_time(userEmail.get(0).getCreate_time());
				user.setLast_time(userEmail.get(0).getLast_time());
	
				user.setAddress((String) userJSON.get("address"));
				user.setStatus((int) userJSON.get("status"));
				
				int ret=cuis.Update(user);
				if(ret>0) {
					System.out.println(JSON.toJSON(user));
					session.setAttribute("user",JSON.toJSON(user));			
					session.removeAttribute("allBlog");
					session.removeAttribute("myBlog");
					out.write("0");
				}else {
					out.write("2");
				}				
	 		}
				
			

			
		} catch (java.text.ParseException e) {
			e.printStackTrace();
		}	
	
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
