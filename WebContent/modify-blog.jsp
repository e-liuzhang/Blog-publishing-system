<%@page import="com.edc.entity.Blog"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include  file="_layout/header.jsp"%>
<%@ include  file="_layout/bar.jsp"%>

 <c:set var="id" scope="session" value="${param.blogId}"/>	
	<!-- main content -->
	<main class="main main--breadcrumb">
		<!-- breadcrumb -->
		
		<div class="breadcrumb">
			<div class="container">
				<div class="row">
					<div class="col-12">
						<ul class="breadcrumb__wrap">
							<li class="breadcrumb__item"><a href="#">首页</a></li>
							<li class="breadcrumb__item breadcrumb__item--active">修改文章</li>
						</ul>
					</div>
				</div>
			</div>
		</div>
		<!-- end breadcrumb -->

		<div class="container">
			<div class="row">
				<div class="col-12 col-md-7 col-lg-8 col-xl-9">
					<!-- form -->
					<form action="UpdBlogServlet" class="form" method="get">
						<div class="row">
							<div class="col-12">
								<h2 class="form__title"></h2>
							</div>

							<div class="col-12">
								<div class="form__group">
									<label for="name" class="form__label">文章名称:</label>				
									<input name="title" type="text" id="name" class="form__input" value="${sessionScope.myBlog[param.indexId].title}">
								</div>
							</div>

							<div class="col-12">
								<div class="form__group">
									<label for="description" class="form__label">正文:</label>
									<textarea name="content" id="description" class="form__textarea">${sessionScope.myBlog[param.indexId].content}</textarea>
								</div>
							</div>

							<div class="col-12">
								<div class="form__group">
									<label for="location" class="form__label">简介:</label>
									<input name="introduction" id="location" type="text" class="form__input" value="${sessionScope.myBlog[param.indexId].introduction}">
								</div>
							</div>

							<div class="col-12">
								<div class="form__group">
									<label for="skills" class="form__label">标签:</label>
									<input name="lable" id="location" type="text" class="form__input" value="${sessionScope.myBlog[param.indexId].lable}">
								</div>
							</div>
							<div class="col-12">
								<button class="form__btn" type="submit" ><span>发布</span></button>
							</div>
							
						</div>
					</form>
					
					<!-- end form -->
				</div>

				<div class="col-12 col-md-5 col-lg-4 col-xl-3">
					
				</div>
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
		$('.form').eq(0).on('submit',function (e) {
			e.preventDefault();
			arr["id"]=${param.blogId};
			arr["title"]=$('.form__input').eq(0).val();
			arr["content"]=$('.form__textarea').eq(0).val();
			arr["introduction"]=$('.form__input').eq(1).val();
			arr["lable"]=$('.form__input').eq(2).val();
	 		$.post( "EditBlogServlet", JSON.stringify(arr))
				.done(function( data) {
					if(data==0){
						window.location="http://localhost:8080/ETC/my-blog.jsp";
					}else if(data==1){
						alert("修改失败");
					}else{
						alert("系统繁忙，请稍后");
					} 
				});	 
		})
		
	})
</script>