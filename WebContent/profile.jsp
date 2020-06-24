<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ include  file="_layout/header.jsp"%>
<%@ include  file="_layout/bar.jsp"%>
	<!-- main content -->
	<main class="main">
		<div class="container">
			<div class="row">
				<div class="col-12 col-md-5 col-lg-4 col-xl-3">
					<%@ include  file="_layout/user.jsp"%>
					<!--social content-->
					<div class="sidebox">
						<div class="sidebox__share">
							<span>Social:</span>
							<ul>
								<li class="facebook"><a href="#"><i class="icon ion-logo-facebook"></i></a></li>
								<li class="instagram"><a href="#"><i class="icon ion-logo-instagram"></i></a></li>
								<li class="twitter"><a href="#"><i class="icon ion-logo-twitter"></i></a></li>
								<li class="vk"><a href="#"><i class="icon ion-logo-vk"></i></a></li>
							</ul>
						</div>
					</div>
					<!-- end social -->
				</div>
	

				<div class="col-12 col-md-7 col-lg-8 col-xl-6">
					<ul class="nav nav-tabs main__nav" id="main__nav" role="tablist">

						<li class="nav-item">
							<a class="nav-link" data-toggle="tab" href="#tab-2" role="tab" aria-controls="tab-2" aria-selected="true">关于</a>
						</li>

						<li class="nav-item">
							<a class="nav-link" data-toggle="tab" href="#tab-3" role="tab" aria-controls="tab-3" aria-selected="false">设置</a>
						</li>
					</ul>

					<div class="tab-content">
						<div class="tab-pane show active" id="tab-2" role="tabpanel" aria-labelledby="tab-2">
							<!-- box -->
							<div class="main__box">
								<h3 class="main__box-title">简介</h3>
								<p class="main__box-text">
									<c:if test="${empty  sessionScope.user}">
									    <c:out value="未登录"/>
									</c:if>
									<c:if test="${not empty  sessionScope.user}">
									    <c:out value="${sessionScope.user.bio}"/>
									</c:if>
								</p>
							</div>
							<!-- end box -->

							<!-- box -->
							<div class="main__box">
								<h3 class="main__box-title">生日</h3>
								<p class="main__box-text">
									<c:if test="${empty  sessionScope.user}">
									    <c:out value="未登录"/>
									</c:if>
									<c:if test="${not empty  sessionScope.user}">
										<fmt:formatDate value="${sessionScope.user.birthday}" pattern="yyyy-MM-dd" /> 
									</c:if>									
								</p>
							</div>
							<!-- end box -->
							<!-- box -->
							<div class="main__box">
								<h3 class="main__box-title">性别</h3>
								<p class="main__box-text">
									<c:if test="${empty  sessionScope.user}">
									    <c:out value="未登录"/>
									</c:if>
									<c:if test="${not empty  sessionScope.user}">
										<c:if test="${sessionScope.user.gender==-1}">
										    <c:out value="保密"/>
										</c:if>	
										<c:if test="${sessionScope.user.gender==1}">
										    <c:out value="男"/>
										</c:if>	
									    <c:if test="${sessionScope.user.gender==2}">
										    <c:out value="女	"/>
										</c:if>	
									</c:if>									
								</p>
							</div>
							<!-- end box -->
							<!-- box -->
							<div class="main__box">
								<h3 class="main__box-title">地址</h3>
								<p class="main__box-text">
									<c:if test="${empty  sessionScope.user}">
									    <c:out value="未登录"/>
									</c:if>
									<c:if test="${not empty  sessionScope.user}">
									    <c:out value="${sessionScope.user.address}"/>
									</c:if>									
								</p>
							</div>
							<!-- end box -->
							<!-- box -->
							<div class="main__box">
								<h3 class="main__box-title">创建时间</h3>
								<p class="main__box-text">
									<c:if test="${empty  sessionScope.user}">
									    <c:out value="未登录"/>
									</c:if>
									<c:if test="${not empty  sessionScope.user}">
										<fmt:formatDate value="${sessionScope.user.create_time}" pattern="yyyy-MM-dd" />
									</c:if>									
								</p>
							</div>
							<!-- end box -->
												
						</div>

						<div class="tab-pane fade" id="tab-3" role="tabpanel" aria-labelledby="tab-3">
							<!-- form -->
							<form action="#" class="form">
								<div class="row">
									<div class="col-12">
										<h2 class="form__title">个人信息</h2>
									</div>

									<div class="col-12 col-lg-6">
										<div class="form__group">
											<label for="login" class="form__label">姓名:</label>
												<c:if test="${empty  sessionScope.user}">
												    <input name="login" id="login" type="text" class="form__input" placeholder="未登录">
												</c:if>
												<c:if test="${not empty  sessionScope.user}">
													<input name="login" id="login" type="text" class="form__input" placeholder="姓名" value="${sessionScope.user.userName}" >
												</c:if>												
										</div>
									</div>

									<div class="col-12 col-lg-6">
										<div class="form__group">
											<label for="birthday" class="form__label">生日:</label>
												<c:if test="${empty  sessionScope.user}">
												    <input name="birthday" id="birthday" type="text" class="form__input" placeholder="未登录">
												</c:if>
												<c:if test="${not empty  sessionScope.user}">
													<input name="birthday" id="birthday" type="text" class="form__input" placeholder="生日" value="<fmt:formatDate value='${sessionScope.user.birthday}' pattern='yyyy-MM-dd'/>" required pattern="[0-9]{4}-[0-9]{2}-[0-9]{2}">
												</c:if>												
										</div>
									</div>

									<div class="col-12 col-lg-12">
										<div class="form__group">
											<label for="bio" class="form__label">个人简介:</label>
												<c:if test="${empty  sessionScope.user}">
												    <input name="bio" id="bio" type="text" class="form__input" placeholder="未登录">
												</c:if>
												<c:if test="${not empty  sessionScope.user}">
													<input name="bio" id="bio" type="text" class="form__input" placeholder="个人简介" value="${sessionScope.user.bio}">
												</c:if>													
										</div>
									</div>
									<div class="col-12 col-lg-12">
										<div class="form__group">
											<label for="address" class="form__label">地址:</label>
												<c:if test="${empty  sessionScope.user}">
												    <input name="address" id="address" type="text" class="form__input" placeholder="未登录">
												</c:if>
												<c:if test="${not empty  sessionScope.user}">
													<input name="address" id="address" type="text" class="form__input" placeholder="地址" value="${sessionScope.user.address}">
												</c:if>													
										</div>
									</div>
									
									<div class="col-12 col-lg-6">
										<div class="form__group">
											<label for="address" class="form__label">头像:</label>
												<c:if test="${empty  sessionScope.user}">
													<select name="category" id="category" class="form__select">
														<option value="avatar-default.png">默认</option>					
													</select>	
												</c:if>
												<c:if test="${not empty  sessionScope.user}">
													<select name="avator" id="category" class="form__select">
														<c:if test="${sessionScope.user.avator=='img/avatar-default.png'}">
															<option value="img/avatar-default.png" selected>默认</option>
															<option value="img/user8.jpg">中年大叔</option>
															<option value="img/user7.jpg">忧郁男</option>
															<option value="img/user9.jpg">性感大叔</option>
															<option value="img/user3.jpg">女神</option>
														</c:if>	
														<c:if test="${sessionScope.user.avator=='img/user8.jpg'}">
															<option value="img/avatar-default.png">默认</option>
															<option value="img/user8.jpg" selected>中年大叔</option>
															<option value="img/user7.jpg">忧郁男</option>
															<option value="img/user9.jpg">性感大叔</option>
															<option value="img/user3.jpg">女神</option>
														</c:if>	
														<c:if test="${sessionScope.user.avator=='img/user7.jpg'}">
															<option value="img/avatar-default.png">默认</option>
															<option value="img/user8.jpg">中年大叔</option>
															<option value="img/user7.jpg" selected>忧郁男</option>
															<option value="img/user9.jpg">性感大叔</option>
															<option value="img/user3.jpg">女神</option>
														</c:if>	
														<c:if test="${sessionScope.user.avator=='img/user9.jpg'}">
															<option value="img/avatar-default.png">默认</option>
															<option value="img/user8.jpg">中年大叔</option>
															<option value="img/user7.jpg">忧郁男</option>
															<option value="img/user9.jpg" selected>性感大叔</option>
															<option value="img/user3.jpg">女神</option>
														</c:if>	
														<c:if test="${sessionScope.user.avator=='img/user3.jpg'}">
															<option value="img/avatar-default.png">默认</option>
															<option value="img/user8.jpg">中年大叔</option>
															<option value="img/user7.jpg">忧郁男</option>
															<option value="img/user9.jpg">性感大叔</option>
															<option value="img/user3.jpg" selected>女神</option>
														</c:if>	

														
													</select>	
												</c:if>													
										</div>
									</div>	
									<div class="col-12 col-lg-6">
										<div class="form__group">
											<label for="address" class="form__label">性别:</label>
												<c:if test="${empty  sessionScope.user}">
													<select name="gender" id="category" class="form__select">
														<option value="-1">保密</option>					
													</select>	
												</c:if>
												<c:if test="${not empty  sessionScope.user}">
													<select name="category" id="category" class="form__select">
														<c:if test="${sessionScope.user.gender==-1}">
															<option value="-1" selected>保密</option>
															<option value="1">男</option>
															<option value="2">女</option>

														</c:if>	
														<c:if test="${sessionScope.user.gender==1}">
														    <option value="-1">保密</option>
															<option value="1" selected>男</option>
															<option value="2">女</option>
														</c:if>	
													    <c:if test="${sessionScope.user.gender==2}">
														    <option value="-1">保密</option>
															<option value="1">男</option>
															<option value="2" selected>女</option>
														</c:if>													 
														
													</select>	
												</c:if>													
										</div>
									</div>							

									<div class="col-12">
										<button class="form__btn" type="submit"><span>保存</span></button>
									</div>
								</div>
							</form>
							<!-- end form -->

							<!-- form -->
							<form action="#" class="form">
								<div class="row">
									<div class="col-12">
										<h2 class="form__title">改密码</h2>
									</div>

									<div class="col-12 col-lg-6">
										<div class="form__group changePW">
											<label for="oldpass" class="form__label">旧密码:</label>
											<input name="oldpass" id="oldpass" type="password" class="form__input">
										</div>
									</div>

									<div class="col-12 col-lg-6">
										<div class="form__group changePW">
											<label for="newpass" class="form__label">新密码:</label>
											<input name="newpass" id="newpass" type="password" class="form__input">
										</div>
									</div>

									<div class="col-12 col-lg-6">
										<div class="form__group changePW">
											<label for="confirmpass" class="form__label">确认密码:</label>
											<input name="confirmpass" id="confirmpass" type="password" class="form__input">
										</div>
									</div>

									<div class="col-12">
										<button class="form__btn" type="submit"><span>修改</span></button>
									</div>
								</div>
							</form>
							<!-- end form -->
						</div>
					</div>
				</div>
				<%@ include  file="_layout/box.jsp"%>
			</div>
		</div>
	</main>
	<!-- end main content -->
<%@ include  file="_layout/footer.jsp"%>
<script>
/*  data状态码解析：
0.修改成功
1.用户名已存在
2.更改失败
*/
	$(function () {
		var arr={};
		var arr1={};
		$('.form').eq(0).on('submit',function (e) {
			e.preventDefault();
			arr["username"]=$('.form__input').eq(0).val();
			arr["birthday"]=$('.form__input').eq(1).val();
			arr["bio"]=$('.form__input').eq(2).val();
			arr["address"]=$('.form__input').eq(3).val();
			arr["avator"]=$('.form__select').eq(0).val();
			arr["gender"]=$('.form__select').eq(1).val();
			$.post( "ChangeUserInfoServlet", JSON.stringify(arr))
				.done(function( data) {
					if(data==0){
						window.location="http://localhost:8080/ETC/index.jsp";
					}else if(data==1){
						alert("用户名已存在");
					}else if(data==2){
						alert("更改失败");
					}else{
						alert("系统繁忙，请稍后");
					}
				});			 
		})
		//
		$('.form').eq(1).on('submit',function (e) {
			e.preventDefault();
			arr1["oldpassword"]=$('.changePW .form__input').eq(0).val();
			arr1["newpassword"]=$('.changePW .form__input').eq(1).val();
			arr1["confirmpassword"]=$('.changePW .form__input').eq(2).val();
			if(arr1["newpassword"]==arr1["confirmpassword"]){
				$.post( "ChangePWDServlet", JSON.stringify(arr1))
				.done(function( data) {
					if(data==0){
						window.location="http://localhost:8080/ETC/signin.jsp";
					}else if(data==1){
						alert("原密码错误");
					}else if(data==2){
						alert("密码更改失败");
					}else{
						alert("系统繁忙，请稍后");
					}
				});						
			}else{
				alert("两次密码不一样");
			}
 
			 	 
		})
		
	})
</script>