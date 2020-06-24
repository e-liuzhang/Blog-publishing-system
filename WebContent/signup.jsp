<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include  file="_layout/header.jsp"%>
	<div class="sign">
		<div class="container">
			<div class="row">
				<div class="col-12">
					<div class="sign__content">
						<!-- registration form -->
						<form action="ETC/RegisterServlet" class="sign__form">
							<a href="index.jsp" class="sign__logo">
								<img src="img/logo.svg" alt="">
							</a>

							<div class="sign__group">
								<input type="text" class="sign__input" placeholder="昵称">
							</div>

							<div class="sign__group">
								<input type="text" class="sign__input" placeholder="邮箱">
							</div>

							<div class="sign__group">
								<input type="password" class="sign__input" placeholder="密码">
							</div>

							<div class="sign__group sign__group--checkbox">
								<input id="remember" name="remember" type="checkbox" checked="checked">
								<label for="remember">已同意 <a href="privacy.jsp">隐私政策</a></label>
							</div>
							
							<button class="sign__btn" type="submit"><span>注册</span></button>

							<span class="sign__text">已有账户? <a href="signin.jsp">登录!</a></span>
						</form>
						<!-- registration form -->
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
1.邮箱已存在
2.用户名已存在
3.数据库问题
*/
	$(function () {
		var arr={};
		$('.sign__form').on('submit',function (e) {
			e.preventDefault();
			arr["username"]=$('.sign__input').eq(0).val();
			arr["email"]=$('.sign__input').eq(1).val();
			arr["password"]=$('.sign__input').eq(2).val();
			$.post( "RegisterServlet", JSON.stringify(arr))
				.done(function( data) {
					if(data==0){
						window.location="http://localhost:8080/ETC/index.jsp";
					}else if(data==1){
						alert("用户邮箱已注册");
					}else if(data==2){
						alert("用户名已存在");
					}else{
						alert("系统繁忙，请稍后");
					}

				});
			 
		})
		
	})
</script>