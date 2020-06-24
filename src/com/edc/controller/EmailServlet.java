package com.edc.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.List;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
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
 * Servlet implementation class EmailServlet
 */
@WebServlet("/EmailServlet")
public class EmailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmailServlet() {
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
		LoginService rs=new LoginServiceImpl();
		User user=new User();
		BufferedReader reader = new BufferedReader(new InputStreamReader(request.getInputStream()));
		String body = IOUtils.read(reader);
		System.out.println(body);
		JSONObject jsonObj;
		try {
			jsonObj = new JSONObject(body);		
			PrintWriter out = response.getWriter();
			String email=(String)jsonObj.get("email");
			List<User> userEmail=rs.CheckEmail(email);
			if(userEmail.size()>0) {
				user=userEmail.get(0);
				String password=user.getPassword();
//				 email start
				
			      // 收件人电子邮箱
			      String to = email;		 
			      // 发件人电子邮箱
			      String from = "2461167723@qq.com";
			      // 指定发送邮件的主机为 smtp.qq.com
			      String host = "smtp.qq.com";  //QQ 邮件服务器
			      // 获取系统属性
			      Properties properties = System.getProperties();
			      // 设置邮件服务器
			      properties.setProperty("mail.smtp.host", host);
			      properties.put("mail.smtp.auth", "true");
			      // 获取默认session对象
			      Session session = Session.getDefaultInstance(properties,new Authenticator(){
			        public PasswordAuthentication getPasswordAuthentication()
			        {
			         return new PasswordAuthentication("2461167723@qq.com", "fmbhylvclukkeahd"); //发件人邮件用户名、密码
			        }
			       });
			 
			      try{
			         // 创建默认的 MimeMessage 对象
			    	  MimeMessage message = new MimeMessage(session);
			 
			         // Set From: 头部头字段
			         message.setFrom(new InternetAddress(from));
			 
			         // Set To: 头部头字段
			         message.addRecipient(Message.RecipientType.TO,
			                                  new InternetAddress(to));
			 
			         // Set Subject: 头部头字段
			         message.setSubject("来至专业it技术交流社区的验证");
			 
			         // 设置消息体
			         message.setText("您在专业it技术交流社区的账户密码："+password+"，请妥善保管。");
			 
			         // 发送消息
			         Transport.send(message);
			         System.out.println("Sent message successfully....from ETC");
			      }catch (MessagingException mex) {
			         mex.printStackTrace();
			      }
				
//				 email end
			      out.write("0");
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
