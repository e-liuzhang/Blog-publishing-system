package com.edc.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.alibaba.fastjson.JSON;
import com.edc.entity.Blog;
import com.edc.service.AllBlogService;
import com.edc.service.impl.AllBlogServiceImpl;

/**
 * Servlet implementation class AllBlogServlet
 */
@WebServlet("/AllBlogServlet")
public class AllBlogServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AllBlogServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 AllBlogService abs=new AllBlogServiceImpl();
		 List<Blog> list=abs.getALL();
		 HttpSession session = request.getSession();
		 session.setAttribute("allBlog",JSON.toJSON(list));		
		 response.sendRedirect("/ETC/index.jsp");
		 System.out.println("allBlog:"+session.getAttribute("allBlog"));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
