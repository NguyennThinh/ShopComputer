<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html dir="ltr" lang="en">

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<!-- Tell the browser to be responsive to screen width -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<!-- Favicon icon -->
<link rel="stylesheet"
	href='<c:url value = "/template/assets/corporate/css/w3.css"></c:url>'>
<link rel="icon" type="image/png" sizes="16x16"
	href='<c:url value = "/template/assets/images/favicon.png"></c:url>'>
<title>MatrixAdmin
	</title>
<!-- Custom CSS -->
<link rel="stylesheet" type="text/css"
	href='<c:url value = "/template/assets/extra-libs/multicheck/multicheck.css"></c:url>'>
<link
	href='<c:url value = "/template/assets/libs/datatables.net-bs4/css/dataTables.bootstrap4.css"></c:url>'
	rel="stylesheet">
<link href='<c:url value = "/template/dist/css/style.min.css"></c:url>'
	rel="stylesheet">
<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
<![endif]-->
</head>

<body>
	<!-- ============================================================== -->
	<!-- Preloader - style you can find in spinners.css -->
	<!-- ============================================================== -->
	<div class="preloader">
		<div class="lds-ripple">
			<div class="lds-pos"></div>
			<div class="lds-pos"></div>
		</div>
	</div>
	<!-- ============================================================== -->
	<!-- Main wrapper - style you can find in pages.scss -->
	<!-- ============================================================== -->
	<div id="main-wrapper">
		<!-- ============================================================== -->
		<!-- Topbar header - style you can find in pages.scss -->
		<!-- ============================================================== -->
		<jsp:include page="../header.jsp"></jsp:include>
		<!-- ============================================================== -->
		<!-- End Topbar header -->
		<!-- ============================================================== -->
		<!-- ============================================================== -->
		<!-- Left Sidebar - style you can find in sidebar.scss  -->
		<!-- ============================================================== -->
		<jsp:include page="../sidebar.jsp"></jsp:include>
		<!-- ============================================================== -->
		<!-- End Left Sidebar - style you can find in sidebar.scss  -->
		<!-- ============================================================== -->
		<!-- ============================================================== -->
		<!-- Page wrapper  -->
		<!-- ============================================================== -->
		<div class="page-wrapper">
			<!-- ============================================================== -->
			<!-- Bread crumb and right sidebar toggle -->
			<!-- ============================================================== -->
			<div class="page-breadcrumb">
				<div class="row">
					<div class="col-12 d-flex no-block align-items-center">
						<h4 class="page-title">Tables</h4>
						<div class="ml-auto text-right">
							<nav aria-label="breadcrumb">
								<ol class="breadcrumb">
									<li class="breadcrumb-item"><a href="#">Home</a></li>
									<li class="breadcrumb-item active" aria-current="page">Library</li>
								</ol>
							</nav>
						</div>
					</div>
				</div>
			</div>
			<!-- ============================================================== -->
			<!-- End Bread crumb and right sidebar toggle -->
			<!-- ============================================================== -->
			<!-- ============================================================== -->
			<!-- Container fluid  -->
			<!-- ============================================================== -->
			<div class="container-fluid">
				<!-- ============================================================== -->
				<!-- Start Page Content -->
				<!-- ============================================================== -->
				<div class="row">
					<div class="col-12">


						<div class="card">
							<div class="card-body">
								<h5 class="card-title">Danh sách đơn hàng</h5>
							
								<div class="table-responsive">
									<table id="zero_config"
										class="table table-striped table-bordered">
										<thead>
											<tr>
												<th>Mã đơn hàng</th>
												<th>Tên sản phẩm</th>
												<th>Số lượng</th>
												<th>Tổng tiền</th>
												<th>Ngày đặt</th>
												<th>Địa chỉ gửi</th>
												<th>Trạng thái</th>
												<th>Phương thức thanh toán</th>
											
											</tr>
										</thead>
										<tbody>
											<c:forEach items="${listOrder }" var="o">
												<tr>

													<td>${o.idBill }</td>
													<td>${o.nameProduct }</td>
													<td>${o.quantily }</td>
													<td>${o.total } VND</td>
													<td>${o.dateOrder }</td>
													<td>${o.address }</td>
													<td>
													<form action="update-order-status" method="get">
													
													<select id="show" name="status">
															<c:forEach items="${status }" var="s">
																<option value="${s }" ${o.status ==s?"selected":"" }>${s }</option>
															</c:forEach>

													</select> 
													 <input type="hidden" id="custId" name="oid" value="${o.idBill }">
													<button type="submit"
														id="submit" style="display: none">Xác nhận</button>
													</form>
													</td>
													
													
													<td>
														<form action="update-order-payment" method="get">
													
													<select id="showp" name="payment">
															<c:forEach items="${payment }" var="s">
																<option value="${s }" ${o.payment ==s?"selected":"" }>${s }</option>
															</c:forEach>

													</select> 
													 <input type="hidden" id="custId" name="oid" value="${o.idBill }">
													<button type="submit"
														id="submitt" style="display: none">Xác nhận</button>
													</form>
													
													</td>

													
												</tr>
											</c:forEach>


										</tbody>

									</table>
								</div>

							</div>
						</div>

					</div>
				</div>

				<!-- ============================================================== -->
				<!-- End PAge Content -->
				<!-- ============================================================== -->
				<!-- ============================================================== -->
				<!-- Right sidebar -->
				<!-- ============================================================== -->
				<!-- .right-sidebar -->
				<!-- ============================================================== -->
				<!-- End Right sidebar -->
				<!-- ============================================================== -->
			</div>
			<!-- ============================================================== -->
			<!-- End Container fluid  -->
			<!-- ============================================================== -->
			<!-- ============================================================== -->
			<!-- footer -->
			<!-- ============================================================== -->
			<footer class="footer text-center">
				All Rights Reserved by Matrix-admin. Designed and Developed by <a
					href="https://wrappixel.com">WrapPixel</a>.
			</footer>
			<!-- ============================================================== -->
			<!-- End footer -->
			<!-- ============================================================== -->
		</div>
		<!-- ============================================================== -->
		<!-- End Page wrapper  -->
		<!-- ============================================================== -->
	</div>
	<!-- ============================================================== -->
	<!-- End Wrapper -->
	<!-- ============================================================== -->
	<!-- ============================================================== -->
	<!-- All Jquery -->
	<!-- ============================================================== -->
	<script
		src='<c:url value = "/template/assets/libs/jquery/dist/jquery.min.js"></c:url>'></script>
	<!-- Bootstrap tether Core JavaScript -->
	<script
		src='<c:url value = "/template/assets/libs/popper.js/dist/umd/popper.min.js"></c:url>'></script>
	<script
		src='<c:url value = "/template/assets/libs/bootstrap/dist/js/bootstrap.min.js"></c:url>'></script>
	<script
		src='<c:url value ="/template/assets/libs/perfect-scrollbar/dist/perfect-scrollbar.jquery.min.js"></c:url>'></script>
	<script
		src='<c:url value = "/template/assets/extra-libs/sparkline/sparkline.js"></c:url>'></script>
	<!--Wave Effects -->
	<script src='<c:url value ="/template/dist/js/waves.js"></c:url>'></script>
	<!--Menu sidebar -->
	<script
		src='<c:url value = "/template/dist/js/sidebarmenu.js"></c:url>'></script>
	<!--Custom JavaScript -->
	<script src='<c:url value = "/template/dist/js/custom.min.js"></c:url>'></script>
	<!-- this page js -->
	<script
		src='<c:url value = "/template/assets/extra-libs/multicheck/datatable-checkbox-init.js"></c:url>'></script>
	<script
		src='<c:url value = "/template/assets/extra-libs/multicheck/jquery.multicheck.js"></c:url>'></script>
	<script
		src='<c:url value = "/template/assets/extra-libs/DataTables/datatables.min.js"></c:url>'></script>
	<script>
		/****************************************
		 *       Basic Table                   *
		 ****************************************/
		$('#zero_config').DataTable();

		$('#show').change(function() {

			// If checkbox is 'checked'
			if ($(this).is(':checked')) {
				// show the element that has the id 'txt_area' 
				$('#submit').hide();
			} else {
				// hide it when not checked
				$('#submit').show();
			}
		});
		$('#showp').change(function() {

			// If checkbox is 'checked'
			if ($(this).is(':checked')) {
				// show the element that has the id 'txt_area' 
				$('#submitt').hide();
			} else {
				// hide it when not checked
				$('#submitt').show();
			}
		});
	</script>

</body>

</html>