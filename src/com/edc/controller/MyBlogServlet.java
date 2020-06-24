package com.edc.controller;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;

import com.alibaba.fastjson.JSON;
import com.edc.entity.Blog;
import com.edc.service.AllBlogService;
import com.edc.service.MyBlogService;
import com.edc.service.impl.AllBlogServiceImpl;
import com.edc.service.impl.MyBlogServiceImpl;

/**
 * Servlet implementation class MyBlogServlet
 */
@WebServlet("/MyBlogServlet")
public class MyBlogServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyBlogServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 MyBlogService abs=new MyBlogServiceImpl();
		// 获取session
		HttpSession session = request.getSession();
		// 获取session传过来的值
		String userInfo=request.getSession().getAttribute("user").toString();
		JSONObject userJSON;
		try {
			userJSON = new JSONObject(userInfo);
			String userId=(String) userJSON.get("userEmail");
			List<Blog> list=abs.getMy(userId);
			session.setAttribute("myBlog",JSON.toJSON(list));		
			response.sendRedirect("/ETC/my-blog.jsp");
			System.out.println("myBlog:"+session.getAttribute("myBlog"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
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
