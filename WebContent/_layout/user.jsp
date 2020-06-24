<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<!-- user -->
<div class="user">
	<div class="user__head">
		<div class="user__img">
			<c:if test="${empty  sessionScope.user}">
			    <img src="img/avatar-default.png" alt="">
			</c:if>
			<c:if test="${not empty  sessionScope.user}">
			   <img src="${sessionScope.user.avator}" alt="">
			</c:if>		
		</div>
	</div>
	<div class="user__title">
		<h2>
			<c:if test="${empty  sessionScope.user}">
			    <c:out value="游客"/>
			</c:if>
			<c:if test="${not empty  sessionScope.user}">
			    <c:out value="${sessionScope.user.userName}"/>
			</c:if>	
		</h2>
	</div>
	<div class="user__btns">
		<a href="add-blog.jsp" class="user__btn user__btn--blue"><span>发布博客</span></a>
		<a href="profile.jsp" class="user__btn user__btn--orange"><span>个人信息</span></a>
	</div>
	<ul class="user__stats">
		<li>
			<p>关注</p>
			<span>0</span>
		</li>
		<li>
			<p>粉丝</p>
			<span>0</span>
		</li>
	</ul>
	<a href="profile.jsp" class="sidebox__more">查看资料</a>
</div>
<!-- end user -->