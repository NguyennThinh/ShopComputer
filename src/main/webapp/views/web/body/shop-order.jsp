<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="../header.jsp"></jsp:include>
<div class="main">
	<div class="container">
		<!-- BEGIN SIDEBAR & CONTENT -->
		<div class="row margin-bottom-40">
			<!-- BEGIN CONTENT -->
			<div class="col-md-12 col-sm-12">
				<h1>Shopping cart</h1>
				<form action="checkout-page" method="get">
					<div class="goods-page">
						<div class="goods-data clearfix">
							<div class="table-wrapper-responsive">

								<table summary="Shopping cart">
									<tr>

										<th class="goods-page-image">Hình ảnh</th>
										<th class="goods-page-description">Tên sản phẩm</th>
										<th class="goods-page-ref-no">Trạng thái</th>
										<th class="goods-page-quantity">Số lượng</th>
										<th class="goods-page-price">Tổng</th>
										<th class="goods-page-total" >Địa chỉ</th>
										<th class="goods-page-total">Thanh toán</th>
									</tr>
									<c:forEach items="${date }" var="d">
										<th>Ngày đặt hàng: ${d }</th>
										<c:forEach items="${order}" var="o">
											<tr>

												<td class="goods-page-image"><a href="javascript:;"><img
														src="${o.photo }" alt="Berry Lace Dress"></a></td>
												<td class="goods-page-description">
													<h3>
														<a href="javascript:;">${o.nameProduct }</a>
													</h3>

												</td>
												<td class="goods-page-ref-no">${o.status }</td>
												<td class="goods-page-quantity">${o.quantily }</td>
												<td class="goods-page-total"><strong>${o.total }<span>VND</span></strong>
												</td>
												<td class="goods-page-price">${o.address }</td>
												<td class="goods-page-price">${o.payment }</td>
												<td class="del-goods-col"><a class="del-goods"
													href="javascript:;">&nbsp;</a></td>
											</tr>
										</c:forEach>
									</c:forEach>
								</table>

							</div>

						
						</div>
						<a class="btn btn-default" href="index"> Continue shopping <i
							class="fa fa-shopping-cart"></i>
						</a>
						
					</div>
				</form>
			</div>
			<!-- END CONTENT -->
		</div>
		<!-- END SIDEBAR & CONTENT -->

	
	</div>
</div>
<jsp:include page="../footer.jsp"></jsp:include>