<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- post -->
<div class="post">
	<div class="post__head">
		<a href="#" class="post__head-img">
			<img src="img/user8.jpg" alt="">
		</a>
		<div class="post__head-title">
			<h5><a href="#">Sebastian Lee</a></h5>
			<p>45 min ago</p>
		</div>

		<div class="post__dropdown">
			<a class="dropdown-toggle post__dropdown-btn" href="#" role="button" id="dropdownMenu2" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
				<i class="icon ion-md-more"></i>
			</a>

			<ul class="dropdown-menu dropdown-menu-right post__dropdown-menu" aria-labelledby="dropdownMenu2">
				<li><a href="modify-blog">编辑</a></li>
				<li><a href="#">删除</a></li>
			</ul>
		</div>
	</div>

	<div class="post__wrap">
		<div class="post__location">
			<i class="icon ion-ios-navigate"></i>
			<span>浙江</span>
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

	<h2 class="post__title">古诗</h2>
	<div class="post__description">
		<p>
		君不见，黄河之水天上来，奔流到海不复回。君不见，高堂明镜悲白发，朝如青丝暮成雪。
		人生得意须尽欢，莫使金樽空对月。天生我材必有用，千金散尽还复来。烹羊宰牛且为乐，
		会须一饮三百杯。岑夫子，丹丘生，将进酒，杯莫停。
		</p>
		<a href="#">更多</a>
	</div>

	<div class="post__tags">
		<a href="#">HTML</a>
		<a href="#">CSS</a>
		<a href="#">PHP</a>
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

		<div class="post__comment">
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
		</div>
	</div>
</div>
<!-- end post -->