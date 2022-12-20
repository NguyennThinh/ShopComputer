<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="../header.jsp"></jsp:include>
<div class="title-wrapper">
	<div class="container">
		<div class="container-inner">
			<h1>
				<span>MEN</span> CATEGORY
			</h1>
			<em>Over 4000 Items are available here</em>
		</div>
	</div>
</div>

<div class="main">
	<div class="container">
		<ul class="breadcrumb">
			<li><a href="index.html">Home</a></li>
			<li><a href="">Store</a></li>
			<li class="active">Men category</li>
		</ul>
		<!-- BEGIN SIDEBAR & CONTENT -->
		<div class="row margin-bottom-40">
			<!-- BEGIN SIDEBAR -->
			<div class="sidebar col-md-3 col-sm-5">


				<div class="sidebar-filter margin-bottom-25">
					<h2>Category</h2>

					<ul class="list-group margin-bottom-25 sidebar-menu">

						<c:forEach items="${lcategory }" var="l">

							<li class="list-group-item clearfix"><a
								href="list-product?category-id=${l.id }"><i
									class="fa fa-angle-right"></i> ${l.cName }</a></li>
						</c:forEach>
					</ul>

				</div>
			</div>
			<!-- END SIDEBAR -->
			<!-- BEGIN CONTENT -->
			<div class="col-md-9 col-sm-7">
				<div class="row list-view-sorting clearfix">
					<div class="col-md-2 col-sm-2 list-view">
						<a href="javascript:;"><i class="fa fa-th-large"></i></a> <a
							href="javascript:;"><i class="fa fa-th-list"></i></a>
					</div>
					<div class="col-md-10 col-sm-10">
						<div class="pull-right">
							<label class="control-label">Show:</label> <select
								class="form-control input-sm">
								<option value="#?limit=24" selected="selected">24</option>
								<option value="#?limit=25">25</option>
								<option value="#?limit=50">50</option>
								<option value="#?limit=75">75</option>
								<option value="#?limit=100">100</option>
							</select>
						</div>
						<div class="pull-right">
							<label class="control-label">Sort&nbsp;By:</label> <select
								class="form-control input-sm">
								<option value="#?sort=p.sort_order&amp;order=ASC"
									selected="selected">Default</option>
								<option value="#?sort=pd.name&amp;order=ASC">Name (A -
									Z)</option>
								<option value="#?sort=pd.name&amp;order=DESC">Name (Z -
									A)</option>
								<option value="#?sort=p.price&amp;order=ASC">Price (Low
									&gt; High)</option>
								<option value="#?sort=p.price&amp;order=DESC">Price
									(High &gt; Low)</option>
								<option value="#?sort=rating&amp;order=DESC">Rating
									(Highest)</option>
								<option value="#?sort=rating&amp;order=ASC">Rating
									(Lowest)</option>
								<option value="#?sort=p.model&amp;order=ASC">Model (A -
									Z)</option>
								<option value="#?sort=p.model&amp;order=DESC">Model (Z
									- A)</option>
							</select>
						</div>
					</div>
				</div>
				<!-- BEGIN PRODUCT LIST -->
				<div class="row product-list">
					<!-- PRODUCT ITEM START -->
					<c:forEach items="${cProduct }" var="c">
						<div class="col-md-4 col-sm-6 col-xs-12">
							<div class="product-item">
								<div class="pi-img-wrapper">
									<img src="${c.photo }" class="img-responsive"
										alt="Berry Lace Dress">
									<div>
										<a href="${c.photo }" class="btn btn-default fancybox-button">Zoom</a>
										<a href="#product-pop-up"
											class="btn btn-default fancybox-fast-view">View</a>
									</div>
								</div>
								<h3>
									<a href="product?pid=${c.id }">${c.productName }</a>
								</h3>
								<div class="pi-price">${c.total }VND</div>
								<a href="javascript:;" class="btn btn-default add2cart">Add
									to cart</a>
							</div>
						</div>
					</c:forEach>
					<!-- PRODUCT ITEM END -->

				</div>
				<!-- END PRODUCT LIST -->
				<!-- BEGIN PAGINATOR -->
				<div class="row">
					<div class="col-md-8 col-sm-8">
						<ul class="pagination pull-right">



							<li><a href="javascript:;">&laquo;</a></li>
							<c:forEach begin="1" end="${totalPage}" var="o">

					
									<li  class="arrow"><a class="${page ==o?"
							ae":""}" href="list-product?category-id=${id}&page=${o}">${o }</a></li>
							
							</c:forEach>


							<li><a href="javascript:;">&raquo;</a></li>
						</ul>
					</div>
				</div>
				<!-- END PAGINATOR -->
			</div>
			<!-- END CONTENT -->
		</div>
		<!-- END SIDEBAR & CONTENT -->
	</div>
</div>
<jsp:include page="../footer.jsp"></jsp:include>