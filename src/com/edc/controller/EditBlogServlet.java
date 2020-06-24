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
import com.edc.service.EditBlogService;
import com.edc.service.WriteService;
import com.edc.service.impl.EditBlogServiceImpl;
import com.edc.service.impl.WriteServiceImpl;

/**
 * Servlet implementation class EditBlogServlet
 */
@WebServlet("/EditBlogServlet")
public class EditBlogServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditBlogServlet() {
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
		EditBlogService eds=new EditBlogServiceImpl();
		Blog blog=new Blog();
		BufferedReader reader = new BufferedReader(new InputStreamReader(request.getInputStream(), "UTF-8"));
		String body = IOUtils.read(reader);
		System.out.println("修改内容："+body);
		JSONObject jsonObj;
		try {
			jsonObj = new JSONObject(body);		
			PrintWriter out = response.getWriter();
			blog.setId((int)jsonObj.get("id"));
			blog.setTitle((String)jsonObj.get("title"));
			blog.setContent((String)jsonObj.get("content"));
			blog.setIntroduction((String)jsonObj.get("introduction"));
			blog.setLable((String)jsonObj.get("lable"));
			// 获取session
			HttpSession session = request.getSession();

			int ret=eds.Edit(blog);
			if(ret>0) {
				out.write("0");
				session.removeAttribute("allBlog");
				session.removeAttribute("myBlog");
			}else {
				out.write("1");
			}

					

		} catch (java.text.ParseException e) {
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
