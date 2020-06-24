<%@ page import="com.edc.entity.Blog" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!-- post -->
<c:if test="${empty  sessionScope.allBlog}">
	<%
    	response.sendRedirect("/ETC/AllBlogServlet");
	%>

</c:if>
<c:if test="${not empty  sessionScope.allBlog}">
	<c:forEach items="${sessionScope.allBlog}" var="keyword" varStatus="id">
		 <div class="post">
			<div class="post__head">
				<a href="#" class="post__head-img">
					<img src="${sessionScope.allBlog[id.index].uAvator}" alt="">
				</a>
				<div class="post__head-title">
					<h5><a href="#">
						<c:out value="${sessionScope.allBlog[id.index].uName}"/>
					</a></h5>
					<p>
						<fmt:formatDate value="${sessionScope.allBlog[id.index].createTime}" pattern="yyyy-MM-dd" />  
					</p>
				</div>
			</div>
		
			<div class="post__wrap">
		
				<div class="post__location">
					<i class="icon ion-ios-navigate"></i>
					<span><c:out value="${sessionScope.allBlog[id.index].uAddress}"/></span>
				</div>
		
				<div class="post__actions">
					<a class="post__actions-btn post__actions-btn--green" href="#">
						<i class="icon ion-ios-bookmark"></i>
					</a>
					<a class="post__actions-btn post__actions-btn--red" href="#">
						<i class="icon ion-ios-mail"></i>
					</a>
				</div>
			</div>
		
			<h2 class="post__title"><c:out value="${sessionScope.allBlog[id.index].title}"/></h2>
		<!--设置路径  -->
			<c:url value="page.jsp" var="seeUrl" scope="session">
				<c:param name="author" value="${sessionScope.allBlog[id.index].uName}"/>
		      	<c:param name="title" value="${sessionScope.allBlog[id.index].title}"/>
		      	<c:param name="content" value="${sessionScope.allBlog[id.index].content}"/>
		    </c:url>
			<div class="post__description">
				<p style="display: inline-block;height: 50px;overflow: hidden"><c:out value="${sessionScope.allBlog[id.index].content}"/></p>
				<p style="margin: 0px">......</p>
				<a href="${seeUrl}">查看更多</a>
			</div>
		
			<div class="post__tags">
				<a href="#"><c:out value="${sessionScope.allBlog[id.index].lable}"/></a>
			</div>
		
			<div class="post__stats">
				<div>
					<a class="post__likes" href="#"><i class="icon ion-ios-heart"></i> <span>15</span></a>
					<a class="post__comments" data-toggle="collapse" href="#collapse1" role="button" aria-expanded="false" aria-controls="collapse1"><i class="icon ion-ios-text"></i> <span>0</span></a>
				</div>
		
				<div class="post__views">
					<i class="icon ion-ios-eye"></i> <span>214</span>
				</div>
			</div>
		
			<div class="collapse post__collapse" id="collapse1">
				<form action="#" class="post__form">
					<input type="text" placeholder="Type your comment...">
					<button type="button"><i class="icon ion-ios-paper-plane"></i></button>
				</form>
			</div>
		</div>
		<!-- end post -->
	</c:forEach>
	
	 
</c:if>
