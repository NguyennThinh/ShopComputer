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
      <link rel="icon" type="image/png" sizes="16x16" href='<c:url value = "/template/assets/images/favicon.png"></c:url>'>
<title>MatrixAdmin
	</title>
    <!-- Custom CSS -->
    <link href='<c:url value = "/template/assets/libs/flot/css/float-chart.css"></c:url>' rel="stylesheet">
    <!-- Custom CSS -->
    <link href='<c:url value = "/template/dist/css/style.min.css"></c:url>' rel="stylesheet">
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

    <!-- ============================================================== -->
    <!-- End Wrapper -->
    <!-- ============================================================== -->
    <!-- ============================================================== -->
    <!-- All Jquery -->
    <!-- ============================================================== -->
    <script src='<c:url value = "/template/assets/libs/jquery/dist/jquery.min.js"></c:url>'></script>
    <!-- Bootstrap tether Core JavaScript -->
    <script src='<c:url value = "/template/assets/libs/popper.js/dist/umd/popper.min.js"></c:url>'></script>
    <script src='<c:url value = "/template/assets/libs/bootstrap/dist/js/bootstrap.min.js"></c:url>'></script>
    <script src='<c:url value ="/template/assets/libs/perfect-scrollbar/dist/perfect-scrollbar.jquery.min.js"></c:url>'></script>
    <script src='<c:url value = "/template/assets/extra-libs/sparkline/sparkline.js"></c:url>'></script>
    <!--Wave Effects -->
    <script src='<c:url value ="/template/dist/js/waves.js"></c:url>'></script>
    <!--Menu sidebar -->
    <script src='<c:url value = "/template/dist/js/sidebarmenu.js"></c:url>'></script>
    <!--Custom JavaScript -->
    <script src='<c:url value = "/template/dist/js/custom.min.js"></c:url>'></script>
    <!--This page JavaScript -->
    <!-- <script src="dist/js/pages/dashboards/dashboard1.js"></script> -->
    <!-- Charts js Files -->
    <script src='<c:url value = "/template/assets/libs/flot/excanvas.js"></c:url>'></script>
    <script src='<c:url value = "/template/assets/libs/flot/jquery.flot.js"></c:url>'></script>
    <script src='<c:url value = "/template/assets/libs/flot/jquery.flot.pie.js"></c:url>'></script>
    <script src='<c:url value = "/template/assets/libs/flot/jquery.flot.time.js"></c:url>'></script>
    <script src='<c:url value = "/template/assets/libs/flot/jquery.flot.stack.js"></c:url>'></script>
    <script src='<c:url value = "/template/assets/libs/flot/jquery.flot.crosshair.js"></c:url>'></script>
    <script src='<c:url value ="/template/assets/libs/flot.tooltip/js/jquery.flot.tooltip.min.js"></c:url>'></script>
    <script src='<c:url value = "/template/dist/js/pages/chart/chart-page-init.js"></c:url>'></script>

</body>

</html>