package com.edc.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;

import com.alibaba.dubbo.common.utils.IOUtils;
import com.alibaba.fastjson.JSON;
import com.edc.entity.User;
import com.edc.service.LoginService;
import com.edc.service.impl.LoginServiceImpl;


/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
		LoginService rs=new LoginServiceImpl();
		User user=new User();
		BufferedReader reader = new BufferedReader(new InputStreamReader(request.getInputStream(), "UTF-8"));
		String body = IOUtils.read(reader);
		System.out.println("登录信息："+body);
		JSONObject jsonObj;
		try {
			jsonObj = new JSONObject(body);		
			PrintWriter out = response.getWriter();
			List<User> userEmail=rs.CheckEmail((String)jsonObj.get("email"));
			String putPW=(String)jsonObj.get("password");
			if(userEmail.size()>0) {
				user=userEmail.get(0);
				String password=user.getPassword();
				if(putPW.equals(password)) {
					out.write("0");
					HttpSession session=request.getSession();
					session.setAttribute("user",JSON.toJSON(user));
					session.setMaxInactiveInterval(6000);
				}else {
					out.write("2");
				}
				System.out.println("登录者信息："+user);	
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
