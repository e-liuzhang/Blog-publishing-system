<%@page import="javax.swing.text.StyledEditorKit.BoldAction"%>
<%@page import="com.edc.entity.Blog"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include  file="_layout/header.jsp"%>
<%@ include  file="_layout/bar.jsp"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<c:if test="${empty  sessionScope.user}">
	<%
    	response.sendRedirect("/ETC/signin.jsp");
	%>
</c:if>
<c:if test="${not empty  sessionScope.user}">
<c:if test="${empty  sessionScope.myBlog}">
	<%
    	response.sendRedirect("/ETC/MyBlogServlet");
	%>

</c:if>
<c:if test="${not empty  sessionScope.myBlog}">
	<!-- main content -->
	<main class="main">
		<div class="container">
			<div class="row">
				<div class="col-12 col-md-5 col-lg-4 col-xl-3">
					<%@ include  file="_layout/user.jsp"%>
					<%@ include  file="_layout/person-box.jsp"%>
				</div>

				<div class="col-12 col-md-7 col-lg-8 col-xl-6">
					<%-- <%@ include  file="_layout/blog-comment.jsp"%> --%>
					<!-- post -->
					<c:forEach items="${sessionScope.myBlog}" var="keyword" varStatus="id">
						<div class="post">
							<div class="post__head">
								<a href="#" class="post__head-img">
									<img src="${sessionScope.myBlog[id.index].uAvator}" alt="">
								</a>
								<div class="post__head-title">
									<h5><a href="#"><c:out value="${sessionScope.myBlog[id.index].uName}"/></a></h5>
									<p>
										<fmt:formatDate value="${sessionScope.myBlog[id.index].createTime}" pattern="yyyy-MM-dd" />  
									</p>
								</div>
						
								<div class="post__dropdown">
									<a class="dropdown-toggle post__dropdown-btn" href="#" role="button" id="dropdownMenu2" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
										<i class="icon ion-md-more"></i>
									</a>
						
									<ul class="dropdown-menu dropdown-menu-right post__dropdown-menu" aria-labelledby="dropdownMenu2">
										<c:url value="modify-blog.jsp" var="url" scope="session">
											<c:param name="indexId" value="${id.index}"/>
									      	<c:param name="blogId" value="${sessionScope.myBlog[id.index].id}"/>
									    </c:url>
									    <li><a href="${url}">编辑</a></li>
										<li><a href="DelBlogServlet?blogId=${sessionScope.myBlog[id.index].id}">删除</a></li>
									</ul>
								</div>
							</div>
						
							<div class="post__wrap">
								<div class="post__location">
									<i class="icon ion-ios-navigate"></i>
									<span><c:out value="${sessionScope.myBlog[id.index].uAddress}"/></span>
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
							<!--设置路径  -->
							<c:url value="page.jsp" var="seeUrl" scope="session">
								<c:param name="author" value="${sessionScope.myBlog[id.index].uName}"/>
						      	<c:param name="title" value="${sessionScope.myBlog[id.index].title}"/>
						      	<c:param name="content" value="${sessionScope.myBlog[id.index].content}"/>
						    </c:url>
							<h2 class="post__title"><c:out value="${sessionScope.myBlog[id.index].title}"/></h2>
							<div class="post__description">
								<p style="display: inline-block;height: 50px;overflow: hidden"><c:out value="${sessionScope.myBlog[id.index].content}"/></p>
								<p style="margin: 0px">......</p>
								<a href="${seeUrl}">查看更多</a>
							</div>
						
							<div class="post__tags">
								<a href="#"><c:out value="${sessionScope.myBlog[id.index].lable}"/></a>
							</div>
						
							<div class="post__stats">
								<div>
									<a class="post__likes" href="#"><i class="icon ion-ios-heart"></i> <span>15</span></a>
									<a class="post__comments" data-toggle="collapse" href="#collapse2" role="button" aria-expanded="true" aria-controls="collapse2"><i class="icon ion-ios-text"></i> <span>2</span></a>
								</div>
						
								<div class="post__views">
									<i class="icon ion-ios-eye"></i> <span>214</span>
								</div>
							</div>
						
							<div class="collapse show post__collapse" id="collapse2">
								<form action="#" class="post__form">
									<input type="text" placeholder="发布评论...">
									<button type="button"><i class="icon ion-ios-paper-plane"></i></button>
								</form>
						
								<!-- <div class="post__comment">
									<a href="#" class="post__comment-img">
										<img src="img/user9.jpg" alt="">
									</a>
									<div class="post__comment-title">
										<h5><a href="#">Alan Patrick</a></h5>
										<p>20 min ago</p>
									</div>
						
									<p class="post__comment-text">Many desktop publishing packages and web page editors now use Lorem Ipsum as their default model text, and a search for 'lorem ipsum' will uncover many web sites still in their infancy.</p>
								</div>
						
								<div class="post__comment">
									<a href="#" class="post__comment-img">
										<img src="img/user2.jpg" alt="">
									</a>
									<div class="post__comment-title">
										<h5><a href="#">Diego Costa</a></h5>
										<p>22 min ago</p>
									</div>
						
									<p class="post__comment-text">Many desktop publishing packages and web page editors now use Lorem Ipsum as their default model text, and a search for 'lorem ipsum' will uncover many web sites still in their infancy.</p>
								</div> -->
							</div>
						</div>
					
					</c:forEach>
					
					<!-- end post -->
					<!-- view more -->
					<button class="main__btn" type="button"><span>更多</span></button>
					<!-- end view more -->
				</div>

				<%@ include  file="_layout/box.jsp"%>

			</div>
		</div>
	</main>
	<!-- end main content -->
</c:if>

</c:if>

<%@ include  file="_layout/footer.jsp"%>
