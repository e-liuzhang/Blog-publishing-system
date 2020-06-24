<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>   
<%@ include  file="_layout/header.jsp"%>
	<c:remove var="user" scope="session" />
	<div class="sign">
		<div class="container">
			<div class="row">
				<div class="col-12">
					<div class="sign__content">
						<!-- authorization form -->
						<form action="#" class="sign__form">
							<a href="index.jsp" class="sign__logo">
								<img src="img/logo.svg" alt="">
							</a>

							<div class="sign__group">
								<input type="text" class="sign__input" placeholder="邮箱">
							</div>

							<div class="sign__group">
								<input type="password" class="sign__input" placeholder="密码">
							</div>

							<div class="sign__group sign__group--checkbox">
								<input id="remember" name="remember" type="checkbox" checked="checked">
								<label for="remember">记住我</label>
							</div>
							
							<button class="sign__btn" type="submit"><span>登录</span></button>

							<span class="sign__text">没有账户? <a href="signup.jsp">注册!</a></span>

							<span class="sign__text"><a href="forgot.jsp">忘记密码?</a></span>
						</form>
						<!-- end authorization form -->
					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- JS -->
<%@ include  file="_layout/footer.jsp"%>
<script>
/*  data状态码解析：
 0.注册成功
 1.邮箱未注册
 2.密码错误
 3.数据库问题
 */

	$(function () {
		var arr={};
		$('.sign__form').on('submit',function (e) {
			e.preventDefault();
			arr["email"]=$('.sign__input').eq(0).val();
			arr["password"]=$('.sign__input').eq(1).val();
			$.post( "LoginServlet", JSON.stringify(arr))
				.done(function( data) {
					if(data==0){
						window.location="http://localhost:8080/ETC/index.jsp";
					}else if(data==1){
						alert("用户邮箱未注册");
					}else if(data==2){
						alert("密码错误");
					}else{
						alert("系统繁忙，请稍后");
					}
				});			 
		})
		
	})
</script>