    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

    <!-- BEGIN STEPS -->
    <div class="steps-block steps-block-red">
      <div class="container">
        <div class="row">
          <div class="col-md-4 steps-block-col">
            <i class="fa fa-truck"></i>
            <div>
              <h2>Free shipping</h2>
              <em>Express delivery withing 3 days</em>
            </div>
            <span>&nbsp;</span>
          </div>
          <div class="col-md-4 steps-block-col">
            <i class="fa fa-gift"></i>
            <div>
              <h2>Daily Gifts</h2>
              <em>3 Gifts daily for lucky customers</em>
            </div>
            <span>&nbsp;</span>
          </div>
          <div class="col-md-4 steps-block-col">
            <i class="fa fa-phone"></i>
            <div>
              <h2>0916778921</h2>
              <em>24/7 customer care available</em>
            </div>
          </div>
        </div>
      </div>
    </div>
    <!-- END STEPS -->

    <!-- BEGIN PRE-FOOTER -->
    <div class="pre-footer">
      <div class="container">
        <div class="row">
          <!-- BEGIN BOTTOM ABOUT BLOCK -->
          <div class="col-md-3 col-sm-6 pre-footer-col">
            <h2>About us</h2>
            <p>SupperShop là một trong những đơn vị cung cấp máy laptop đảm bảo chất lượng, giá thành hợp lý. Cửa hàng cung cấp hàng loạt các loại máy laptop với nhiều mẫu mã, tính năng và thương hiệu khác nhau như: Dell, HP, Acer, Asus, Macbook,... đặc biệt cập nhật mẫu mới liên tục cho khách hàng. Rất nhiều khách hàng đã trải nghiệm máy tính xách tay tại điện máy Nguyễn Kim và có đánh giá cao về chất lượng sản phẩm cũng như chất lượng phục vụ.  </p>

          </div>
          <!-- END BOTTOM ABOUT BLOCK -->
  


          <!-- END TWITTER BLOCK -->

          <!-- BEGIN BOTTOM CONTACTS -->
          <div class="col-md-3 col-sm-6 pre-footer-col">
            <h2>Our Contacts</h2>
            <address class="margin-bottom-40">
         		201 Phan Van Tri, Phường 7, <br>
            Gò Vấp, Tp.HCM<br>
              Số điện thoại: 0916778921<br>
              Email: <a href="#">pc@gmail.com</a><br>
   
            </address>
          </div>
          <!-- END BOTTOM CONTACTS -->
        </div>
        <hr>
        <div class="row">
          <!-- BEGIN SOCIAL ICONS -->
          <div class="col-md-6 col-sm-6">
            <ul class="social-icons">
              <li><a class="rss" data-original-title="rss" href="javascript:;"></a></li>
              <li><a class="facebook" data-original-title="facebook" href="javascript:;"></a></li>
              <li><a class="twitter" data-original-title="twitter" href="javascript:;"></a></li>
              <li><a class="googleplus" data-original-title="googleplus" href="javascript:;"></a></li>
              <li><a class="linkedin" data-original-title="linkedin" href="javascript:;"></a></li>
              <li><a class="youtube" data-original-title="youtube" href="javascript:;"></a></li>
              <li><a class="vimeo" data-original-title="vimeo" href="javascript:;"></a></li>
              <li><a class="skype" data-original-title="skype" href="javascript:;"></a></li>
            </ul>
          </div>
          <!-- END SOCIAL ICONS -->
          <!-- BEGIN NEWLETTER -->
          <div class="col-md-6 col-sm-6">
            <div class="pre-footer-subscribe-box pull-right">
              <h2>Newsletter</h2>
              <form action="#">
                <div class="input-group">
                  <input type="text" placeholder="youremail@mail.com" class="form-control">
                  <span class="input-group-btn">
                    <button class="btn btn-primary" type="submit">Subscribe</button>
                  </span>
                </div>
              </form>
            </div> 
          </div>
          <!-- END NEWLETTER -->
        </div>
      </div>
    </div>
    <!-- END PRE-FOOTER -->

    <!-- BEGIN FOOTER -->
    <div class="footer">
      <div class="container">
        <div class="row">
          <!-- BEGIN COPYRIGHT -->
          <div class="col-md-4 col-sm-4 padding-top-10">
            2015 © Keenthemes. ALL Rights Reserved. 
          </div>
          <!-- END COPYRIGHT -->
          <!-- BEGIN PAYMENTS -->
          <div class="col-md-4 col-sm-4">
            <ul class="list-unstyled list-inline pull-right">
              <li><img src='<c:url value = "/template/assets/corporate/img/payments/western-union.jpg"></c:url>' alt="We accept Western Union" title="We accept Western Union"></li>
              <li><img src='<c:url value = "/template/assets/corporate/img/payments/american-express.jpg"></c:url>' alt="We accept American Express" title="We accept American Express"></li>
              <li><img src='<c:url value = "/template/assets/corporate/img/payments/MasterCard.jpg"></c:url>' alt="We accept MasterCard" title="We accept MasterCard"></li>
              <li><img src='<c:url value = "/template/assets/corporate/img/payments/PayPal.jpg"></c:url>' alt="We accept PayPal" title="We accept PayPal"></li>
              <li><img src='<c:url value = "/template/assets/corporate/img/payments/visa.jpg"></c:url>' alt="We accept Visa" title="We accept Visa"></li>
            </ul>
          </div>
          <!-- END PAYMENTS -->
          <!-- BEGIN POWERED -->
          <div class="col-md-4 col-sm-4 text-right">
            <p class="powered">Powered by: <a href="http://www.keenthemes.com/">KeenThemes.com</a></p>
          </div>
          <!-- END POWERED -->
        </div>
      </div>
    </div>
    <!-- END FOOTER -->

    <!-- BEGIN fast view of a product -->
    <div id="product-pop-up" style="display: none; width: 700px;">
            <div class="product-page product-pop-up">
              <div class="row">
                <div class="col-md-6 col-sm-6 col-xs-3">
                  <div class="product-main-image">
                    <img src="assets/pages/img/products/model7.jpg" alt="Cool green dress with red bell" class="img-responsive">
                  </div>
                  <div class="product-other-images">
                    <a href="javascript:;" class="active"><img alt="Berry Lace Dress" src='<c:url value = "/template/assets/pages/img/products/model3.jpg"></c:url>'></a>
                    <a href="javascript:;"><img alt="Berry Lace Dress" src='<c:url value = "/template/assets/pages/img/products/model4.jpg"></c:url>'></a>
                    <a href="javascript:;"><img alt="Berry Lace Dress" src='<c:url value = "/template/assets/pages/img/products/model5.jpg"></c:url>'></a>
                  </div>
                </div>
                <div class="col-md-6 col-sm-6 col-xs-9">
                  <h2>Cool green dress with red bell</h2>
                  <div class="price-availability-block clearfix">
                    <div class="price">
                      <strong><span>$</span>47.00</strong>
                      <em>$<span>62.00</span></em>
                    </div>
                    <div class="availability">
                      Availability: <strong>In Stock</strong>
                    </div>
                  </div>
                  <div class="description">
                    <p>Lorem ipsum dolor ut sit ame dolore  adipiscing elit, sed nonumy nibh sed euismod laoreet dolore magna aliquarm erat volutpat Nostrud duis molestie at dolore.</p>
                  </div>
                  <div class="product-page-options">
                    <div class="pull-left">
                      <label class="control-label">Size:</label>
                      <select class="form-control input-sm">
                        <option>L</option>
                        <option>M</option>
                        <option>XL</option>
                      </select>
                    </div>
                    <div class="pull-left">
                      <label class="control-label">Color:</label>
                      <select class="form-control input-sm">
                        <option>Red</option>
                        <option>Blue</option>
                        <option>Black</option>
                      </select>
                    </div>
                  </div>
                  <div class="product-page-cart">
                    <div class="product-quantity">
                        <input id="product-quantity" type="text" value="1" readonly name="product-quantity" class="form-control input-sm">
                    </div>
                    <button class="btn btn-primary" type="submit">Add to cart</button>
                    <a href="shop-item.html" class="btn btn-default">More details</a>
                  </div>
                </div>

                <div class="sticker sticker-sale"></div>
              </div>
            </div>
    </div>
    <!-- END fast view of a product -->

    <!-- Load javascripts at bottom, this will reduce page load time -->
    <!-- BEGIN CORE PLUGINS (REQUIRED FOR ALL PAGES) -->
    <!--[if lt IE 9]>
    <script src="assets/plugins/respond.min.js"></script>  
    <![endif]-->
    <script src='<c:url value ="/template/assets/plugins/jquery.min.js"></c:url>' type="text/javascript"></script>
    <script src='<c:url value ="/template/assets/plugins/jquery-migrate.min.js"></c:url>' type="text/javascript"></script>
    <script src='<c:url value = "/template/assets/plugins/bootstrap/js/bootstrap.min.js"></c:url>' type="text/javascript"></script>      
    <script src='<c:url value ="/template/assets/corporate/scripts/back-to-top.js"></c:url>' type="text/javascript"></script>
    <script src='<c:url value ="/template/assets/plugins/jquery-slimscroll/jquery.slimscroll.min.js"></c:url>' type="text/javascript"></script>
    <!-- END CORE PLUGINS -->

    <!-- BEGIN PAGE LEVEL JAVASCRIPTS (REQUIRED ONLY FOR CURRENT PAGE) -->
    <script src='<c:url value = "/template/assets/plugins/fancybox/source/jquery.fancybox.pack.js"></c:url>' type="text/javascript"></script><!-- pop up -->
    <script src='<c:url value = "/template/assets/plugins/owl.carousel/owl.carousel.min.js"></c:url>' type="text/javascript"></script><!-- slider for products -->
    <script src='<c:url value = "/template/assets/plugins/zoom/jquery.zoom.min.js"></c:url>' type="text/javascript"></script><!-- product zoom -->
    <script src='<c:url value = "/template/assets/plugins/bootstrap-touchspin/bootstrap.touchspin.js"></c:url>' type="text/javascript"></script><!-- Quantity -->

    <script src='<c:url value = "/template/assets/corporate/scripts/layout.js"></c:url>' type="text/javascript"></script>
    <script src='<c:url value = "/template/assets/pages/scripts/bs-carousel.js"></c:url>' type="text/javascript"></script>
    <script type="text/javascript">
        jQuery(document).ready(function() {
            Layout.init();    
            Layout.initOWL();
            Layout.initImageZoom();
            Layout.initTouchspin();
            Layout.initTwitter();
        });
        
        
        var rad = document.myForm.payment;
    	var prev = null;
    	var card = document.getElementById('card');
    	var card2 = document.getElementById('card2');
    	var card3 = document.getElementById('card3');
    	var card4 = document.getElementById('card4');

    	for(var i = 0; i < rad.length; i++) {
    	    rad[i].onclick = function () {
    	        (prev)? console.log(prev.value):null;
    	        if(this !== prev) {
    	            prev = this;
    	        }

    	        if(this.value == "2"){
    	            card.setAttribute("style", "display: block ");
    	            card2.setAttribute("style", "display: block ");
    	            card3.setAttribute("style", "display: block ");
    	            card4.setAttribute("style", "display: block ");
    	        }else{
    	            card.setAttribute("style","display: none");
    	            card2.setAttribute("style","display: none");
    	            card3.setAttribute("style","display: none");
    	            card4.setAttribute("style","display: none");
    	        }

    	    };
    	  
    	}
  
    </script>
    <!-- END PAGE LEVEL JAVASCRIPTS -->
</body>
<!-- END BODY -->
</html>