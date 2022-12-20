<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="../header.jsp"></jsp:include>
<div class="main">
	<div class="container">
		<ul class="breadcrumb">
			<li><a href="index.html">Home</a></li>
			<li><a href="">Store</a></li>
			<li class="active">Cool green dress with red bell</li>
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
				<div class="product-page">
					<div class="row">

						<div class="col-md-6 col-sm-6">
							<div class="product-main-image">
								<img src="${p.photo }" alt="Cool green dress with red bell"
									class="img-responsive" data-BigImgsrc="${p.photo }">
							</div>
							<div class="product-other-images">
								<a href="${p.photo }" class="fancybox-button" rel="photos-lib"><img
									alt="Berry Lace Dress" src="${p.photo }"></a> <a
									href="${p.photo }" class="fancybox-button" rel="photos-lib"><img
									alt="Berry Lace Dress" src="${p.photo }"></a> <a
									href="${p.photo }" class="fancybox-button" rel="photos-lib"><img
									alt="Berry Lace Dress" src="${p.photo }"></a>
							</div>
						</div>
						<div class="col-md-6 col-sm-6">
							<h1>${p.productName }</h1>
							<div class="price-availability-block clearfix">
								<div class="price">
									<strong>${p.total }<span>VND</span></strong>
									<c:if test="${p.sale !=0 }">
										<em><span>${p.price }</span> VND
		
										</em>
									</c:if>
								
								</div>
							
							</div>
							<div class="description" style="margin-bottom: 15px">
								<p>Giới thiệu: ${p.description }.</p>
							</div>
							<h6 style="color: red"> ${error }</h6>
							<form action="add-cart?pid=${p.id }" method="post">
								<div class="product-page-cart">
									<div class="product-quantity">
										<input id="product-quantity" type="text" value="1" readonly
											name="soluong" class="form-control input-sm">
									</div>
									<button class="btn btn-primary" type="submit">Add to
										cart</button>
								</div>
							</form>
							<div class="review">
								<input type="range" value="4" step="0.25" id="backing4">
								<div class="rateit" data-rateit-backingfld="#backing4"
									data-rateit-resetable="false" data-rateit-ispreset="true"
									data-rateit-min="0" data-rateit-max="5"></div>
								<a href="javascript:;">7 reviews</a>&nbsp;&nbsp;|&nbsp;&nbsp;<a
									href="javascript:;">Write a review</a>
							</div>
							<ul class="social-icons">
								<li><a class="facebook" data-original-title="facebook"
									href="javascript:;"></a></li>
								<li><a class="twitter" data-original-title="twitter"
									href="javascript:;"></a></li>
								<li><a class="googleplus" data-original-title="googleplus"
									href="javascript:;"></a></li>
								<li><a class="evernote" data-original-title="evernote"
									href="javascript:;"></a></li>
								<li><a class="tumblr" data-original-title="tumblr"
									href="javascript:;"></a></li>
							</ul>
						</div>


						<div class="product-page-content">
							<ul id="myTab" class="nav nav-tabs">
								<li><a href="#Description" data-toggle="tab">Description</a></li>
								<li><a href="#Information" data-toggle="tab">Information</a></li>
								
							</ul>
							<div id="myTabContent" class="tab-content">
								<div class="tab-pane fade" id="Description">
									<p>${p.description }.</p>
								</div>
								<div class="tab-pane fade" id="Information">
									
									 
									 <table class="datasheet">
										<tr>
											<th colspan="2">Thông tin sản phẩm</th>
										</tr>
										<tr>
											<td class="datasheet-features-type">CPU</td>
											<td>${pdetail.cpu }</td>
										</tr>
										<tr>
											<td class="datasheet-features-type">Mainboard</td>
											<td>${pdetail.mainboard }</td>
										</tr>
										<tr>
											<td class="datasheet-features-type">Ram</td>
											<td>${pdetail.ram }</td>
										</tr>
										<tr>
											<td class="datasheet-features-type">Rom</td>
											<td>${pdetail.rom }</td>
										</tr>
										<tr>
											<td class="datasheet-features-type">Card</td>
											<td>${pdetail.card }</td>
										</tr>
										<tr>
											<td class="datasheet-features-type">Nguồng</td>
											<td>${pdetail.power }</td>
										</tr>
										<tr>
											<td class="datasheet-features-type">Khung</td>
											<td>${pdetail.frames }</td>
										</tr>
										<tr>
											<td class="datasheet-features-type">Tản nhiệt</td>
											<td>${pdetail.radiators }</td>
										</tr>
									</table>
								
								</div>
							
							</div>
						</div>

						<div class="sticker sticker-sale"></div>
					</div>
				</div>
			</div>
			<!-- END CONTENT -->
		</div>
		<!-- END SIDEBAR & CONTENT -->

	
	</div>
</div>
<jsp:include page="../footer.jsp"></jsp:include>