<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include  file="_layout/header.jsp"%>
<%@ include  file="_layout/bar.jsp"%>
	<!-- main content -->
	<main class="main">
		<div class="container">
			<div class="row">
				<div class="col-12 col-md-5 col-lg-4 col-xl-3">
					<%@ include  file="_layout/user.jsp"%>
					<%@ include  file="_layout/person-box.jsp"%>
				</div>
				
				<div class="col-12 col-md-7 col-lg-8 col-xl-6">
					<%@ include  file="_layout/blog.jsp"%>
					<!-- view more -->
					<button class="main__btn" type="button"><span>更多</span></button>
					<!-- end view more -->
				</div>
				<%@ include  file="_layout/box.jsp"%>
			</div>
		</div>
	</main>
	<!-- end main content -->
	
<%@ include  file="_layout/footer.jsp"%>
