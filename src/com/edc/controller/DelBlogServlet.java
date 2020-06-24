package com.edc.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;
import com.alibaba.dubbo.common.utils.IOUtils;
import com.edc.entity.Blog;
import com.edc.service.DelBlogService;
import com.edc.service.impl.DelBlogServiceImpl;

/**
 * Servlet implementation class DelBlogServlet
 */
@WebServlet("/DelBlogServlet")
public class DelBlogServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DelBlogServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		response. setCharacterEncoding("UTF-8");
		DelBlogService dbs=new DelBlogServiceImpl();
		Blog blog=new Blog();
		String id = request.getParameter("blogId");//用request得到
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		int ret=dbs.Del(id);
		if(ret>0) {
			response.sendRedirect("/ETC/my-blog.jsp");
			session.removeAttribute("allBlog");
			session.removeAttribute("myBlog");
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
