<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
	<!-- header -->
	<header class="header">
		<div class="container">
			<div class="row">
				<div class="col-7 col-md-9 col-lg-8 col-xl-9">
					<div class="header__content">
						<!-- header menu btn -->
						<button class="header__btn" type="button">
							<span></span>
							<span></span>
							<span></span>
						</button>
						<!-- end header menu btn -->

						<!-- header logo -->
						<a href="index.jsp" class="header__logo">
							<img src="img/logo.svg" alt="">
						</a>
						<!-- end header logo -->

						<!-- header nav -->
						<ul class="header__nav">
							<!-- dropdown -->
							<li class="header__nav-item">
								<a href="index.jsp" class="header__nav-link">主页</a>
							</li>
							<!-- end dropdown -->

							<!-- dropdown -->
							<li class="header__nav-item">
								<a class="dropdown-toggle header__nav-link" href="#" role="button" id="dropdownMenuProjects" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">博客</a>

								<ul class="dropdown-menu header__dropdown-menu" aria-labelledby="dropdownMenuProjects">
									<li><a href="my-blog.jsp">我的博客</a></li>
									<li><a href="add-blog.jsp">发布文章</a></li>
								</ul>
							</li>
							<!-- end dropdown -->

							<!-- dropdown -->
							<li class="header__nav-item">
								<a class="dropdown-toggle header__nav-link" href="#" role="button" id="dropdownMenuPages" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">功能</a>

								<ul class="dropdown-menu header__dropdown-menu" aria-labelledby="dropdownMenuPages">
									<li><a href="messages.jsp">消息内容</a></li>
									<li><a href="privacy.jsp">隐私政策</a></li>

								</ul>
							</li>
							<!-- end dropdown -->

							<!-- dropdown -->
							<li class="header__nav-item">
								<a class="dropdown-toggle header__nav-link" href="404.jsp" role="button" id="dropdownMenuCompanies">动态</a>
							</li>
							<!-- end dropdown -->


						</ul>
						<!-- end header nav -->

						<!-- header search -->
						<form action="#" class="header__search">
							<input class="header__search-input" type="text" placeholder="搜索...">
							<button class="header__search-button" type="button">
								<i class="icon ion-ios-search"></i>
							</button>
						</form>
						<!-- end header search -->
					</div>
				</div>

				<div class="col-5 col-md-3 col-lg-4 col-xl-3">
					<div class="header__content header__content--end">
						<a href="messages.jsp" class="header__messages header__messages--active">
							<i class="icon ion-ios-mail"></i>
						</a>

						<div class="header__notifications">
							<a class="dropdown-toggle header__notifications-btn header__notifications-btn--active" href="#" role="button" id="dropdownMenuNotifications" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
								<i class="icon ion-ios-notifications"></i>
							</a>

							<div class="dropdown-menu dropdown-menu-right header__dropdown-menu header__dropdown-menu--right header__dropdown-menu--ntf" aria-labelledby="dropdownMenuNotifications">
<!--								组件-->
								<div class="header__ntf">
									<a href="#" class="header__ntf-img">
										<img src="img/user1.jpg" alt="">
									</a>
									<h6 class="header__ntf-title">
										<span>Tony Young</span> Comment on your project.
									</h6>
								</div>

								<a href="#" class="header__ntf-more">View more</a>
							</div>
						</div>

						<div class="header__profile">
							<a class="dropdown-toggle header__profile-btn" href="#" role="button" id="dropdownMenuProfile" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
								<c:if test="${empty  sessionScope.user}">
								    <img src="img/avatar-default.png" alt="">
								</c:if>
								<c:if test="${not empty  sessionScope.user}">
								   <img src="${sessionScope.user.avator}" alt="">
								</c:if>
								
								<span>
								<c:if test="${empty  sessionScope.user}">
								    <c:out value="游客"/>
								</c:if>
								<c:if test="${not empty  sessionScope.user}">
								    <c:out value="${sessionScope.user.userName}"/>
								</c:if>
								</span> 
							</a>

							<ul class="dropdown-menu dropdown-menu-right header__dropdown-menu header__dropdown-menu--right" aria-labelledby="dropdownMenuProfile">
								<li><a href="profile.jsp"><i class="icon ion-ios-settings"></i> 设置</a></li>
								<li><a href="privacy.jsp"><i class="icon ion-ios-lock"></i> 隐私</a></li>
								<li><a href="signin.jsp"><i class="icon ion-ios-exit"></i> 登出</a></li>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
	</header>
	<!-- end header -->
