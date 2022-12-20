<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="../header.jsp"></jsp:include>
<div class="main">
	<div class="container">
		<ul class="breadcrumb">
			<li><a href="index.html">Home</a></li>
			<li><a href="">Store</a></li>
			<li class="active">Checkout</li>
		</ul>
		<!-- BEGIN SIDEBAR & CONTENT -->
		<div class="row margin-bottom-40">
			<!-- BEGIN CONTENT -->
			<div class="col-md-12 col-sm-12">
				<h1>Checkout</h1>
				<!-- BEGIN CHECKOUT PAGE -->
				<div class="panel-group checkout-page accordion scrollable"
					id="checkout-page">


					<!-- BEGIN CONFIRM -->
					<div id="confirm" class="panel panel-default">
						<div class="panel-heading">
							<h2 class="panel-title">
								<a data-toggle="collapse" data-parent="#checkout-page"
									href="#confirm-content" class="accordion-toggle"> Confirm
									Order </a>
							</h2>
						</div>
						<div id="confirm-content" class="panel-collapse collapse">
							<div class="panel-body row">
								<div class="col-md-12 clearfix">
									<div class="table-wrapper-responsive">
										<table>
											<tr>
												<th class="checkout-image">Image</th>
												<th class="checkout-description">Description</th>
												<th class="checkout-model">Discount</th>
												<th class="checkout-quantity">Quantity</th>
												<th class="checkout-price">Price</th>
												<th class="checkout-total">Total</th>
											</tr>
											<c:forEach items="${listDetail }" var="o">
												<tr>
													<td class="checkout-image"><a href="javascript:;"><img
															src="${o.photo }" alt="Berry Lace Dress"></a></td>
													<td class="checkout-description">
														<h3>
															<a href="javascript:;">${o.name }</a>
														</h3>

													</td>
													<td class="checkout-model">${o.sale }</td>
													<td class="checkout-quantity">${o.quantily }</td>
													<td class="checkout-price"><strong>${o.price }<span>VND</span></strong></td>
													<td class="checkout-total"><strong>${o.total }<span>VND</span></strong></td>
												</tr>


											</c:forEach>
										</table>
									</div>
									<div class="checkout-total-block">
										<ul>
											<li><em>Sub total</em> <strong class="price">${total }<span>VND</span></strong>
											</li>
											<li><em>Shipping cost</em> <strong class="price">${ship }<span>VND</span></strong>
											</li>

											<li><em>VAT (10%)</em> <strong class="price">${VAT }<span>VND</span></strong>
											</li>
											<li class="checkout-total-price"><em>Total</em> <strong
												class="price">${money }<span>VND</span></strong></li>
										</ul>
									</div>
									<div class="clearfix"></div>

								</div>

								<div class="col-md-12">
									<p>Vui lòng chọn phương thúc thanh toán.</p>
									<form action="checkout" method="get" name="myForm">

										<div class="panel-body row">
											<div class="col-md-6 col-sm-6">

												<h3>Your Personal Details</h3>



											
											<div class="form-group">
												<label for="firstname">Họ và tên <span
													class="require">*</span></label> <input type="text" id="firstname"
													name="fullname" value="${user.fullName }"
													class="form-control">
											</div>

											<div class="form-group">
												<label for="email">E-Mail <span class="require">*</span></label>
												<input type="text" id="email" name="email"
													value="${user.email }" class="form-control">
											</div>
											<div class="form-group">
												<label for="telephone">Số điệm thoại <span
													class="require">*</span></label> <input type="text" id="telephone"
													name="phone" value="${user.phone }" class="form-control">
											</div>



										</div>
										<div class="col-md-6 col-sm-6">
											<h3>Your Address</h3>
											<div class="form-group">
												<label for="company">Địa chỉ</label> <input type="text"
													name="address" id="company" value="${user.address }"
													class="form-control">
											</div>

										</div>
										<hr>
</div>
										<div class="form-group" style="margin-bottom: 20px;">
											<input style="margin: .4rem;" type="radio" id="huey"
												name="payment" value="1" checked> <label
												for="Trực tiếp">Thanh toán khi nhận hàng</label> <input
												style="margin: .4rem;" type="radio" id="huey" name="payment"
												value="2"> <label for="Trực tuyến">Thanh
												toán trực tuyến</label>
										</div>

										<div class="form-group" id="card" style="display: none;">
											<label for="firstname">Chọn thẻ <span class="require">*</span>
											</label> <select id="cars" class="form-control">
												<option value="volvo">Visa</option>
												<option value="saab">Mastercard</option>
											</select>
										</div>
										<div class="form-group" id="card2" style="display: none;">
											<label for="firstname">Tên chủ thẻ <span
												class="require">*</span></label> <input type="text" id="firstname"
												name="fullname" class="form-control">
										</div>

										<div class="form-group" id="card3" style="display: none;">
											<label for="firstname">Số thẻ <span class="require">*</span></label>
											<input type="text" id="firstname" name="fullname"
												class="form-control">
										</div>

										<div class="form-group" id="card4" style="display: none;">
											<label for="firstname">Ngày hết hạn <span
												class="require">*</span></label> <input type="date" id="firstname"
												name="fullname" class="form-control">
										</div>
										<button class="btn btn-primary pull-right" type="submit"
											id="button-confirm">Confirm Order</button>
										<button type="button"
											class="btn btn-default pull-right margin-right-20">Cancel</button>
									</form>


								</div>

							</div>
						</div>
					</div>
					<!-- END CONFIRM -->
				</div>
				<!-- END CHECKOUT PAGE -->
			</div>
			<!-- END CONTENT -->
		</div>
		<!-- END SIDEBAR & CONTENT -->
	</div>
</div>
<jsp:include page="../footer.jsp"></jsp:include>