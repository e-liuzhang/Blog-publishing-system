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
							<li class="breadcrumb__item"><a href="#">首页</a></li>
							<li class="breadcrumb__item breadcrumb__item--active">消息</li>
						</ul>
					</div>
				</div>
			</div>
		</div>
		<!-- end breadcrumb -->

		<div class="container">
			<div class="row">
				<!-- chat -->
				<div class="col-12">
					<div class="messages">
						<!-- dialogues -->
						<div class="messages__dialogues">
							<div class="messages__search">
								<input type="text" placeholder="Search...">
								<button type="button">
									<i class="icon ion-ios-search"></i>
								</button>
							</div>

							<div class="messages__list">
								<div class="messages__user messages__user--missed messages__user--online">
									<div class="messages__user-img">
										<img src="img/user4.jpg" alt="">
									</div>
									<div class="messages__user-title">
										<h5>Ariana Mun</h5>
										<p>Web Designer</p>
									</div>

									<div class="messages__user-missed">2</div>
								</div>

								<div class="messages__user messages__user--active">
									<div class="messages__user-img">
										<img src="img/user2.jpg" alt="">
									</div>
									<div class="messages__user-title">
										<h5>Ilya Kuznetsov</h5>
										<p>Middle School Teacher</p>
									</div>
								</div>

								<div class="messages__user messages__user--online">
									<div class="messages__user-img">
										<img src="img/user3.jpg" alt="">
									</div>
									<div class="messages__user-title">
										<h5>Erin Andrews</h5>
										<p>Insurance Agent</p>
									</div>
								</div>

								<div class="messages__user">
									<div class="messages__user-img">
										<img src="img/user6.jpg" alt="">
									</div>
									<div class="messages__user-title">
										<h5>Myra Pratt</h5>
										<p>Paramedic</p>
									</div>
								</div>

								<div class="messages__user">
									<div class="messages__user-img">
										<img src="img/user7.jpg" alt="">
									</div>
									<div class="messages__user-title">
										<h5>Mathew Wheeler</h5>
										<p>Registered Nurse</p>
									</div>
								</div>

								<div class="messages__user messages__user--online">
									<div class="messages__user-img">
										<img src="img/user1.jpg" alt="">
									</div>
									<div class="messages__user-title">
										<h5>Kristin Cunningham</h5>
										<p>Personal Care Aide</p>
									</div>
								</div>

								<div class="messages__user">
									<div class="messages__user-img">
										<img src="img/user8.jpg" alt="">
									</div>
									<div class="messages__user-title">
										<h5>Robin Cross</h5>
										<p>Teaching assistant</p>
									</div>
								</div>
							</div>
						</div>
						<!-- end dialogues -->

						<!-- dialog -->
						<div class="messages__dialog">
							<div class="messages__head">
								<h2>Ilya Kuznetsov <span>last seen 45 minutes ago</span></h2>

								<div class="post__dropdown">
									<a class="dropdown-toggle post__dropdown-btn" href="#" role="button" id="dropdownDialog" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
										<i class="icon ion-md-more"></i>
									</a>

									<ul class="dropdown-menu dropdown-menu-right post__dropdown-menu" aria-labelledby="dropdownDialog">
										<li><a href="#">Clear history</a></li>
										<li><a href="#">Delete</a></li>
									</ul>
								</div>
							</div>

							<div class="messages__chat">
								<div class="messages__text messages__text--guest">
									<div class="messages__user-img">
										<img src="img/user2.jpg" alt="">
									</div>

									<p>It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. <span>5:26 pm</span></p>
								</div>

								<div class="messages__date"><span>February 6</span></div>

								<div class="messages__text">
									<div class="messages__user-img">
										<img src="img/user5.jpg" alt="">
									</div>

									<p>Many desktop publishing packages and web page editors now use Lorem Ipsum as their default model text, and a search for 'lorem ipsum' will uncover many web sites still in their infancy. <span>4:41 pm</span></p>
								</div>

								<div class="messages__text">
									<div class="messages__user-img">
										<img src="img/user5.jpg" alt="">
									</div>

									<p>Various versions have evolved over the years, sometimes by accident, sometimes on purpose. <span>4:49 pm</span></p>
								</div>

								<div class="messages__text messages__text--guest">
									<div class="messages__user-img">
										<img src="img/user2.jpg" alt="">
									</div>

									<p>There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour, or randomised words which don't look even slightly believable. <span>5:13 pm</span></p>
								</div>

								<div class="messages__date"><span>Today</span></div>

								<div class="messages__text messages__text--guest">
									<div class="messages__user-img">
										<img src="img/user2.jpg" alt="">
									</div>

									<p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. <span>2:13 am</span></p>
								</div>

								<div class="messages__text messages__text--guest">
									<div class="messages__user-img">
										<img src="img/user2.jpg" alt="">
									</div>

									<p>OK? <span>2:15 am</span></p>
								</div>
							</div>

							<div class="messages__form">
								<input type="text" placeholder="Write a message…">
								<button type="button"><i class="icon ion-ios-paper-plane"></i></button>
							</div>
						</div>
						<!-- end dialog -->
					</div>
				</div>
				<!-- end chat -->
			</div>
		</div>
	</main>
	<!-- end main content -->

<%@ include  file="_layout/footer.jsp"%>