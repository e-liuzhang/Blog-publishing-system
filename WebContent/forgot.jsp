<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include  file="_layout/header.jsp"%>
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

							<div class="sign__group sign__group--checkbox">
								<input id="remember" name="remember" type="checkbox" checked="checked">
								<label for="remember">已同意 <a href="privacy.jsp">隐私政策</a></label>
							</div>
							
							<button class="sign__btn" type="submit"><span>发送</span></button>

							<span class="sign__text">我们会发送密码至你的邮箱</span>
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
 0.发送成功
 1.邮箱未注册
 */

	$(function () {
		var arr={};
		$('.sign__form').on('submit',function (e) {
			e.preventDefault();
			arr["email"]=$('.sign__input').eq(0).val();
			$.post( "EmailServlet", JSON.stringify(arr))
				.done(function( data) {
					if(data==0){
						window.location="http://localhost:8080/ETC/signin.jsp";
					}else if(data==1){
						alert("用户邮箱未注册");
					}else{
						alert("系统繁忙，请稍后");
					}
				});			 
		})
		
	})
</script>