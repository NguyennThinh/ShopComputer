<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="../header.jsp"></jsp:include>


<div class="main">
	<div class="container">
		<!-- BEGIN SALE PRODUCT & NEW ARRIVALS -->
		<div class="row margin-bottom-40">
			<!-- BEGIN SALE PRODUCT -->
			<div class="col-md-12 sale-product">
				<h2>SẢN PHẨM ĐANG SALE</h2>
				<div class="owl-carousel owl-carousel5">

					<c:forEach items="${listProduct }" var="p">
						<div>
							<div class="product-item">
								<div class="pi-img-wrapper">
									<img src="${p.photo }" class="img-responsive"
										alt="Berry Lace Dress">
									<div>
										<a href="${p.photo }" class="btn btn-default fancybox-button">Zoom</a>
								
									</div>
								</div>
								<h3>
									<a href="product?pid=${p.id }">${p.productName }</a>
								</h3>

								
								<h5><a>Giá: ${p.price }VND</a></h5>
								<h5>
									<a>Giảm: ${p.sale }%</a>
								</h5>
							

								<div class="pi-price" style="margin-right: 50px">Tổng:
									${p.total } VND</div>
						
								<div class="sticker sticker-sale"></div>

							</div>
						</div>
					</c:forEach>
				</div>
			</div>
			<!-- END SALE PRODUCT -->
		</div>
		<!-- END SALE PRODUCT & NEW ARRIVALS -->

		<!-- BEGIN SIDEBAR & CONTENT -->
		<div class="row margin-bottom-40 ">
			<!-- BEGIN SIDEBAR -->
			<div class="sidebar col-md-3 col-sm-4">
				<ul class="list-group margin-bottom-25 sidebar-menu">
					
						<c:forEach items="${lcategory }" var = "l">
						
							<li class="list-group-item clearfix"><a
						href="list-product?category-id=${l.id }"><i class="fa fa-angle-right"></i>
							${l.cName }</a></li>
						</c:forEach>
				
				</ul>
			</div>
			<!-- END SIDEBAR -->
			<!-- BEGIN CONTENT -->
			<div class="col-md-9 col-sm-8">
				<h2>SẢN PHẨM MỚI NHẤT</h2>
				<div class="owl-carousel owl-carousel3">
					<c:forEach items="${list10Product }" var="p">
						<div>

							<div class="product-item">
								<div class="pi-img-wrapper">
									<img src="${p.photo } " class="img-responsive"
										alt="Berry Lace Dress">
									<div>
										<a href="${p.photo }" class="btn btn-default fancybox-button">Zoom</a>
										
									</div>
								</div>
								<h3>
									<a href="product?pid=${p.id }">${p.productName }</a>
								</h3>
								<div class="pi-price">${p.total }VND</div>
				
								<div class="sticker sticker-new"></div>
							</div>

						</div>
					</c:forEach>
				</div>
				<!-- END CONTENT -->
			</div>
			<!-- END SIDEBAR & CONTENT -->

			<!-- BEGIN TWO PRODUCTS & PROMO -->
			<div class="row margin-bottom-35 ">
				<!-- BEGIN TWO PRODUCTS -->
				<div class="col-md-6 two-items-bottom-items">
					<h2>SẢN PHẨM ĐƯỢC MUA NHIỀU NHẤT</h2>
					<div class="owl-carousel owl-carousel2">
						<c:forEach items="${listSell }" var="o">
							<div>
								<div class="product-item">
									<div class="pi-img-wrapper">
										<img src="${o.photo }" class="img-responsive"
											alt="Berry Lace Dress">
										<div>
											<a href="${o.photo }" class="btn btn-default fancybox-button">Zoom</a>
											
										</div>
									</div>
									<h3>
										<a href="product?pid=${o.id }">${o.productName }</a>
									</h3>
									<div class="pi-price">${o.total }VND</div>
								
								</div>
							</div>
						</c:forEach>

					</div>
				</div>
				<!-- END TWO PRODUCTS -->
				<!-- BEGIN PROMO -->
				<div class="col-md-6 shop-index-carousel">
					<div class="content-slider">
						<div id="myCarousel" class="carousel slide" data-ride="carousel">
							<!-- Indicators -->
							<ol class="carousel-indicators">
								<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
								<li data-target="#myCarousel" data-slide-to="1"></li>
								<li data-target="#myCarousel" data-slide-to="2"></li>
							</ol>
							<div class="carousel-inner">
								<div class="item active">
									<img
										src="https://cdn5.f-cdn.com/contestentries/93288/7603270/53dc111ccf2f2_thumb900.jpg"
										class="img-responsive" alt="Berry Lace Dress">
								</div>
								<div class="item">
									<img
										src="https://cdn3.f-cdn.com/contestentries/93288/8898676/53db9c1727260_thumb900.jpg"
										class="img-responsive" alt="Berry Lace Dress">
								</div>
								<div class="item">
									<img src="https://tmdpc.vn/media/news/325_banner_pcgame.jpg"
										class="img-responsive" alt="Berry Lace Dress">
								</div>
							</div>
						</div>
					</div>
				</div>
				<!-- END PROMO -->
			</div>
			<!-- END TWO PRODUCTS & PROMO -->
		</div>
	</div>
	<jsp:include page="../footer.jsp"></jsp:include>