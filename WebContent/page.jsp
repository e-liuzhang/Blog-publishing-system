<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include  file="_layout/header.jsp"%>
<%@ include  file="_layout/bar.jsp"%>
	<!-- main content -->
	<main class="main main--breadcrumb">
		<!-- breadcrumb -->
		<div class="breadcrumb">
			<div class="container">
				<div class="row">
					<div class="col-12">
						<ul class="breadcrumb__wrap">
							<li class="breadcrumb__item"><a href="#">${param.author}</a></li>
							<li class="breadcrumb__item breadcrumb__item--active">${param.title}</li>
						</ul>
					</div>
				</div>
			</div>
		</div>
		<!-- end breadcrumb -->
		
		<div class="container">
			<div class="row">
				<div class="col-12 col-md-7 col-lg-8 col-xl-9">
					<div class="privacy">
						<h2 class="privacy__title">${param.title}</h2>
						<p class="privacy__text">
							作者：${param.author}
						</p>
						<p class="privacy__text">
							${param.content}
						</p>

					</div>
				</div>
			</div>
		</div>
	</main>
	<!-- end main content -->

	<!-- JS -->
	<script src="js/jquery-3.4.1.min.js"></script>
	<script src="js/bootstrap.bundle.min.js"></script>
	<script src="js/owl.carousel.min.js"></script>
	<script src="js/wNumb.js"></script>
	<script src="js/nouislider.min.js"></script>
	<script src="js/select2.min.js"></script>
	<script src="js/jquery.mousewheel.min.js"></script>
	<script src="js/jquery.mCustomScrollbar.min.js"></script>
	<script src="js/main.js"></script>