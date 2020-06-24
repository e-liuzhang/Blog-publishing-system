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
import com.edc.service.ChangePWDService;
import com.edc.service.LoginService;
import com.edc.service.impl.ChangePWDServiceImpl;
import com.edc.service.impl.LoginServiceImpl;

/**
 * Servlet implementation class ChangePWDServlet
 */
@WebServlet("/ChangePWDServlet")
public class ChangePWDServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangePWDServlet() {
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
		ChangePWDService cs=new ChangePWDServiceImpl();
		User user=new User();
		BufferedReader reader = new BufferedReader(new InputStreamReader(request.getInputStream(), "UTF-8"));
		String body = IOUtils.read(reader);
		System.out.println(body);
		JSONObject jsonObj;
		try {
			jsonObj = new JSONObject(body);		
			PrintWriter out = response.getWriter();
			String newPassword=(String)jsonObj.get("newpassword");
			String oldPassword=(String)jsonObj.get("oldpassword");
			// 获取session
			HttpSession session = request.getSession();
			// 获取session传过来的值
			String userInfo=request.getSession().getAttribute("user").toString();
			JSONObject userJSON=new JSONObject(userInfo);
			String userEmail=(String) userJSON.get("userEmail");
			String userPassword=(String) userJSON.get("password");
//			判断原密码
			if(!userPassword.equals(oldPassword)) {
				out.write("1");
				return;
			}
//			设置修改
			user.setUserEmail(userEmail);
			user.setPassword(newPassword);
			int ret=cs.UpdatePW(user);
			if(ret>0) {
				out.write("0");
				session.removeAttribute("user");
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
