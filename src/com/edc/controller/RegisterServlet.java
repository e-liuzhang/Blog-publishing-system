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
import com.edc.service.RegisterService;
import com.edc.service.impl.RegisterServiceImpl;


/**
 * Servlet implementation class Register
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
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
		RegisterService rs=new RegisterServiceImpl();
		User user=new User();
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(request.getInputStream(), "UTF-8"));
		String body = IOUtils.read(reader);
		System.out.println(body);
		JSONObject jsonObj;
		try {
			jsonObj = new JSONObject(body);		
			PrintWriter out = response.getWriter();
			List<User> userEmail=rs.CheckEmail((String)jsonObj.get("email"));
			List<User> userName=rs.CheckName((String)jsonObj.get("username"));
			
			if(userEmail.size()>0) {
				out.write("1");
			}else if(userName.size()>0){
				out.write("2");
			}else {
				user.setUserEmail((String)jsonObj.get("email"));
				user.setUserName((String)jsonObj.get("username"));
				user.setPassword((String)jsonObj.get("password"));
				int ret=rs.Register(user);
				if(ret>0) {
					List<User> getUser=rs.CheckEmail((String)jsonObj.get("email"));
					user=getUser.get(0);
					HttpSession session=request.getSession();
					session.setAttribute("user",JSON.toJSON(user));
					session.setMaxInactiveInterval(6000);
			        out.write("0");
				}else {
					 out.write("3");
				}				
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
