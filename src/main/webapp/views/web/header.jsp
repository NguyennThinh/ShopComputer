<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<!--
Template: Metronic Frontend Freebie - Responsive HTML Template Based On Twitter Bootstrap 3.3.4
Version: 1.0.0
Author: KeenThemes
Website: http://www.keenthemes.com/
Contact: support@keenthemes.com
Follow: www.twitter.com/keenthemes
Like: www.facebook.com/keenthemes
Purchase Premium Metronic Admin Theme: http://themeforest.net/item/metronic-responsive-admin-dashboard-template/4021469?ref=keenthemes
-->
<!--[if IE 8]> <html lang="en" class="ie8 no-js"> <![endif]-->
<!--[if IE 9]> <html lang="en" class="ie9 no-js"> <![endif]-->
<!--[if !IE]><!-->
<html lang="en">
<!--<![endif]-->

<!-- Head BEGIN -->
<head>
  <meta charset="utf-8">
  <title>Supper Shop</title>

  <meta content="width=device-width, initial-scale=1.0" name="viewport">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">

  <meta content="Metronic Shop UI description" name="description">
  <meta content="Metronic Shop UI keywords" name="keywords">
  <meta content="keenthemes" name="author">

  <meta property="og:site_name" content="-CUSTOMER VALUE-">
  <meta property="og:title" content="-CUSTOMER VALUE-">
  <meta property="og:description" content="-CUSTOMER VALUE-">
  <meta property="og:type" content="website">
  <meta property="og:image" content="-CUSTOMER VALUE-"><!-- link to image for socio -->
  <meta property="og:url" content="-CUSTOMER VALUE-">

	<style type="text/css">
	.arrow .ae{
	background: rgb(175, 174, 174);
}
	</style>

  <link rel="shortcut icon" href="favicon.ico">

  <!-- Fonts START -->
    <link href='<c:url value = "/template/assets/corporate/css/fonts.googleapis.com.css1.css"></c:url>' rel="stylesheet">
     <link href='<c:url value = "/template/assets/corporate/css/fonts.googleapis.com.css2.css"></c:url>' rel="stylesheet">
 <!--  <link href="http://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700|PT+Sans+Narrow|Source+Sans+Pro:200,300,400,600,700,900&amp;subset=all" rel="stylesheet" type="text/css">
  <link href="http://fonts.googleapis.com/css?family=Source+Sans+Pro:200,300,400,600,700,900&amp;subset=all" rel="stylesheet" type="text/css">- fonts for slider on the index page   -->
  
  <!-- Fonts END -->

  <!-- Global styles START -->          
  <link href='<c:url value ="/template/assets/plugins/font-awesome/css/font-awesome.min.css"></c:url>' rel="stylesheet">
  <link href='<c:url value="/template/assets/plugins/bootstrap/css/bootstrap.min.css"></c:url>' rel="stylesheet">
  <!-- Global styles END --> 
   
  <!-- Page level plugin styles START -->
  <link href='<c:url value = "/template/assets/pages/css/animate.css"></c:url>' rel="stylesheet">
  <link href='<c:url value = "/template/assets/plugins/fancybox/source/jquery.fancybox.css"></c:url>' rel="stylesheet">
  <link href='<c:url value ="/template/assets/plugins/owl.carousel/assets/owl.carousel.css"></c:url>' rel="stylesheet">
  <!-- Page level plugin styles END -->

  <!-- Theme styles START -->
  <link href='<c:url value = "/template/assets/pages/css/components.css"></c:url>' rel="stylesheet">
  <link href='<c:url value = "/template/assets/pages/css/slider.css"></c:url>' rel="stylesheet">
  <link href='<c:url value = "/template/assets/pages/css/style-shop.css"></c:url>' rel="stylesheet" type="text/css">
  <link href='<c:url value = "/template/assets/corporate/css/style.css"></c:url>' rel="stylesheet">
  <link href='<c:url value = "/template/assets/corporate/css/style-responsive.css"></c:url>' rel="stylesheet">
  <link href='<c:url value = "/template/assets/corporate/css/themes/red.css"></c:url>' rel="stylesheet">
  <link href='<c:url value = "/template/assets/corporate/css/custom.css"></c:url>' rel="stylesheet">
  <!-- Theme styles END -->
</head>
<!-- Head END -->

<!-- Body BEGIN -->
<body class="ecommerce">
    <!-- BEGIN STYLE CUSTOMIZER -->
    <div class="color-panel hidden-sm">
      <div class="color-mode-icons icon-color"></div>
      <div class="color-mode-icons icon-color-close"></div>
      <div class="color-mode">
        <p>THEME COLOR</p>
        <ul class="inline">
          <li class="color-red current color-default" data-style="red"></li>
          <li class="color-blue" data-style="blue"></li>
          <li class="color-green" data-style="green"></li>
          <li class="color-orange" data-style="orange"></li>
          <li class="color-gray" data-style="gray"></li>
          <li class="color-turquoise" data-style="turquoise"></li>
        </ul>
      </div>
    </div>
    <!-- END BEGIN STYLE CUSTOMIZER --> 

    <!-- BEGIN TOP BAR -->
    <div class="pre-header">
        <div class="container">
            <div class="row">
                <!-- BEGIN TOP BAR LEFT PART -->
                <div class="col-md-6 col-sm-6 additional-shop-info">
                    <ul class="list-unstyled list-inline">
                        <li><i class="fa fa-phone"></i><span>0916778921</span></li>
                        <!-- BEGIN CURRENCIES -->
                        <li class="shop-currencies">
                            <a href="javascript:void(0);">€</a>
                            <a href="javascript:void(0);">£</a>
                            <a href="javascript:void(0);" class="current">$</a>
                        </li>
                        <!-- END CURRENCIES -->
                        <!-- BEGIN LANGS -->
                        <li class="langs-block">
                            <a href="javascript:void(0);" class="current">English </a>
                            <div class="langs-block-others-wrapper"><div class="langs-block-others">
                              <a href="javascript:void(0);">French</a>
                              <a href="javascript:void(0);">Germany</a>
                              <a href="javascript:void(0);">Turkish</a>
                            </div></div>
                        </li>
                        <!-- END LANGS -->
                    </ul>
                </div>
                <!-- END TOP BAR LEFT PART -->
                <!-- BEGIN TOP BAR MENU -->
                <div class="col-md-6 col-sm-6 additional-nav">
                    <ul class="list-unstyled list-inline pull-right">
                        <li><a href="${accID==null?"login":"order" }">Đơn hàng của tôi</a></li>
               
                         <li><a href="${accID==null?"login":"cart" }">Giỏ hàng</a></li>
                   		<c:if test="${accID==null }">
                   			  <li><a href="login">Log in</a></li>
                   		</c:if>
                   			<c:if test="${accID!=null }">
                   			  <li><a href="logout">Log out</a></li>
                   		</c:if>
                       
                    </ul>
                </div>
                <!-- END TOP BAR MENU -->
            </div>
        </div>        
    </div>
    <!-- END TOP BAR -->

    <!-- BEGIN HEADER -->
    <div class="header">
      <div class="container">
        <a class="site-logo" href="index"><img src='<c:url value = "/template/assets/corporate/img/logos/logo-shop-red.png"></c:url>' alt="Metronic Shop UI"></a>

        <a href="javascript:void(0);" class="mobi-toggler"><i class="fa fa-bars"></i></a>

        <!-- BEGIN CART -->
        <div class="top-cart-block">
          <div class="top-cart-info">
            <a href="javascript:void(0);" class="top-cart-info-count">${cartsize } items</a>
            <c:if test="${accID != null && cartsize >0}">
            <a href="javascript:void(0);" class="top-cart-info-value">${bill } VND</a>
            </c:if>
               <c:if test="${accID == null && cartsize ==0}">
            <a href="javascript:void(0);" class="top-cart-info-value">0 VND</a>
            </c:if>
          </div>
          <i class="fa fa-shopping-cart"></i>
                        
          <div class="top-cart-content-wrapper">
            <div class="top-cart-content">
              <ul class="scroller" style="height: 250px;">
              <c:forEach items="${CartHeader }" var="o">
               <li>
                  <a href="shop-item.html"><img src="${o.photo }" alt="Rolex Classic Watch" width="37" height="34"></a>
                    <strong><a href="shop-item.html">${o.name }</a></strong>
                  <span class="cart-content-count">${o.quantily }</span>
                  <em>${o.total }</em>
          
                </li>
              </c:forEach>
               
               
              </ul>
              <div class="text-right">
                <a href="cart" class="btn btn-primary">View Cart</a>
              </div>
            </div>
          </div>            
        </div>
        <!--END CART -->

        <!-- BEGIN NAVIGATION -->
        <div class="header-navigation">
          <ul>
            <li class="dropdown">
              <a class="dropdown-toggle" data-toggle="dropdown" data-target="#" href="javascript:;">
                Danh mục sản phẩm 
                
              </a>
                
              <!-- BEGIN DROPDOWN MENU -->
              <ul class="dropdown-menu">
  
                <li><a href="supplier">Tất cả máy tính</a></li>
           	<c:forEach items="${supplier }" var="c">
           	     <li><a href="supplier?supplier-id=${c.id }" >Máy tính ${c.sName }</a></li>
           	</c:forEach>
              </ul>
              <!-- END DROPDOWN MENU -->
            </li>
                 <li class="dropdown">
              <a class="dropdown-toggle" data-toggle="dropdown" data-target="#" href="javascript:;">
               Phụ kiện khác
                
              </a>
                
              <!-- BEGIN DROPDOWN MENU -->
              <ul class="dropdown-menu">
            
					<c:forEach items="${category }" var="c">
					                <li><a href="list-product?category-id=${c.id }">${c.cName }</a></li>
					</c:forEach>
            
              </ul>
              <!-- END DROPDOWN MENU -->
            </li>
            <!-- BEGIN TOP SEARCH -->
            <li class="menu-search">
              <span class="sep"></span>
              <i class="fa fa-search search-btn"></i>
              <div class="search-box">
                <form action="search">
                  <div class="input-group">
                    <input type="text" placeholder="Search" class="form-control" name="search">
                    <span class="input-group-btn">
                      <button class="btn btn-primary" type="submit">Search</button>
                    </span>
                  </div>
                </form>
              </div> 
            </li>
            <!-- END TOP SEARCH -->
          </ul>
        </div>
        <!-- END NAVIGATION -->
      </div>
    </div>