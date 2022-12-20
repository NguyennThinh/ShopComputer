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
<title>Matrix Template - The Ultimate Multipurpose admin
	template</title>
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
								<h5 class="card-title">Danh sách sản phẩm</h5>
								<h6 style="color: red">
									<c:if test="${error !=null }"></c:if>${error }
								</h6>
								<h6 style="color: green">
									<c:if test="${succsess !=null }"></c:if>${succsess }
								</h6>
								<button style="margin-bottom: 10px" data-toggle="modal"
									data-target="#myModal">Thêm loại sản phẩm</button>
								<div class="table-responsive">
									<table id="zero_config"
										class="table table-striped table-bordered">
										<thead>
											<tr>
												<th>ID Sản phẩm</th>
												<th>Tên sản phẩm</th>
												<th>Nhà sản xuất</th>
												<th>Loại sản phẩm</th>
												<th>Chi tiết sản phẩm</th>
												<th>Giới thiệu</th>
												<th>Số lượng</th>
												<th>Đã bán</th>
												<th>Giá gốc</th>
												<th>Giảm giá (%)</th>
												<th>Tổng</th>
												<th>Delete</th>
												<th>Action</th>
											</tr>
										</thead>
										<tbody>
											<c:forEach items="${listProduct }" var="o">
												<tr>
													<td>${o.id }</td>
													<td>${o.productName }</td>
													<td>${o.idSuplier }</td>
													<td>${o.idCategory }</td>
													<td><a class="ctdd" onclick="return theFunction();" style="color: black"
													 data-toggle="modal"
									data-target="#myModal1">${o.idProductDetail }</a>
													<input name="idct" type="hidden" id = "id" value="${o.idCategory }"> </td>
													<td>${o.description }</td>
													<td>${o.quantily }</td>
													<td>${o.sold }</td>
													<td>${o.price }VND</td>
													<td>${o.sale }%</td>
													<td>${o.total }VND</td>
													<td>${o.delete }</td>
													<td><a
														style=" border: none; color: red;  font-size: 16px; cursor: pointer;"
														class="fa fa-trash" type="button"
														href="delete-product?pid=${o.id }"></a>
												
													
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
				<!-- Modal -->
				<div class="modal fade" id="myModal" role="dialog">
					<div class="modal-dialog">

						<!-- Modal content-->
						<div class="modal-content">
							<div class="modal-header">
								<h4>Thêm loại sản phẩm mới</h4>
								<button type="button" class="close" data-dismiss="modal">&times;</button>

							</div>
							<div class="modal-body">
								<form class="w3-container" action="add-new-product">
									<h5 style="margin-bottom: 20px">Thông tin sản phẩm</h5>
									<p>
										<label>Tên sản phẩm</label> <input class="w3-input"
											type="text" name="nameproduct">
									</p>
									<p>
										<label>Giảm giá (%)</label> <input class="w3-input"
											type="text" name="sale">
									</p>
									<p>
										<label>Giá</label> <input class="w3-input" type="text"
											name="price">
									</p>
									<p>
										<label style="margin-right: 30px">Nhà sản xuất</label> <select name="supplier">
											<c:forEach items="${listSupplier }" var="s">
												<option value="${s.id }">${s.sName }</option>
											</c:forEach>

										</select>
									</p>
									<p>
										<label>Giới thiệu</label> <input class="w3-input" type="text"
											name="description">
									</p>
									<p>
										<label>Hình ảnh</label> <input class="w3-input" type="text"
											name="photo">
									</p>
									<p>
										<label>Số lượng</label> <input class="w3-input" type="text"
											name="quantily">
									</p>
									<p>
										<label style="margin-right: 30px">Loại sản phẩm</label> <select name="category">
											<c:forEach items="${listCategory }" var="s">
												<option value="${s.id }">${s.cName }</option>
											</c:forEach>
										</select>
									</p>
									<h4>Thêm chi tiết sản phẩm</h4>
										<p>
										<label>ID Chi tiết</label> <input class="w3-input" type="text"
											name="did">
									</p>
									<p>
										<label>CPU</label> <input class="w3-input" type="text"
											name="CPU">
									</p>
									<p>
										<label>Mainboard</label> <input class="w3-input" type="text"
											name="mainboard">
									</p>
									<p>
										<label>RAM</label> <input class="w3-input" type="text"
											name="RAM">
									</p>
									<p>
										<label>ROM</label> <input class="w3-input" type="text"
											name="ROM">
									</p>
									<p>
										<label>Card đồ họa</label> <input class="w3-input" type="text"
											name="CARD">
									</p>
									<p>
										<label>Nguồn</label> <input class="w3-input" type="text"
											name="POWER">
									</p>
									<p>
										<label>Khung</label> <input class="w3-input" type="text"
											name="khung">
									</p>
									<p>
										<label>Tản nhiệt</label> <input class="w3-input" type="text"
											name="tannhiet">
									</p>

									<button class="w3-btn w3-green">Thêm</button>
									</p>

								</form>
							</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-default"
									data-dismiss="modal">Close</button>
							</div>
						</div>

					</div>
				</div>
				<div class="modal fade" id="myModal1" role="dialog">
					<div class="modal-dialog">
						<!-- Modal content-->
						<div class="modal-content">
							<div class="modal-header">
								<h4>Chi tiết sản phẩm</h4>
								<button type="button" class="close" data-dismiss="modal">&times;</button>

							</div>
							<div class="modal-body">
								<form class="w3-container">
							
									<h4>Thêm chi tiết sản phẩm</h4>
										<p>
										<label>ID Chi tiết</label> <input class="w3-input" type="text"
											id="ctidd"	name="did">
									</p>
									<p>
										<label>CPU</label> <input class="w3-input" type="text"
										id = "cpu"	name="CPU" value="${A.cpu }">
									</p>
									<p>
										<label>Mainboard</label> <input class="w3-input" type="text"
											id = "mainboard"		name="mainboard">
									</p>
									<p>
										<label>RAM</label> <input class="w3-input" type="text"
											id = "ram"		name="RAM">
									</p>
									<p>
										<label>ROM</label> <input class="w3-input" type="text"
											id = "rom"		name="ROM">
									</p>
									<p>
										<label>Card đồ họa</label> <input class="w3-input" type="text"
											id = "card"		name="CARD">
									</p>
									<p>
										<label>Nguồn</label> <input class="w3-input" type="text"
											id = "power"		id = "cpu"		name="POWER">
									</p>
									<p>
										<label>Khung</label> <input class="w3-input" type="text"
											id = "khung"		name="khung">
									</p>
									<p>
										<label>Tản nhiệt</label> <input class="w3-input" type="text"
											id = "tannhiet"		name="tannhiet">
									</p>

								</form>
							</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-default"
									data-dismiss="modal">Close</button>
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
		$('.table .ctdd').click(function(e){
		 //   ($(e.target).text()); // using jQuery
		    var idct =  $(e.target).text();
	
	
			$.ajax({
				  url: "/ShopPC/product-detail",
				  type: "get", //send it through get method
				  data: { 
				    idct: idct, 
				
				  },
				  success: function(ProductDetail) {
					   var product = $.parseJSON(ProductDetail);
				   $('#myModal1 #ctidd').val(product.id);
				
				   $('#myModal1 #cpu').val(product.cpu);
				   $('#myModal1 #mainboard').val(product.mainboard);
				   $('#myModal1 #ram').val(product.ram);
				   $('#myModal1 #rom').val(product.rom);
				   $('#myModal1 #card').val(product.card);
				   $('#myModal1 #power').val(product.power);
				   $('#myModal1 #khung').val(product.frames);
				   $('#myModal1 #tannhiet').val(product.radiators);
				
				  },
				  error: function(xhr) {
				    //Do Something to handle error
				  }
				});
	    
		});
	</script>

</body>

</html>