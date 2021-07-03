<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zxx">
   <head>
      <!-- Meta Tag -->
      <meta charset="utf-8">
      <meta http-equiv="X-UA-Compatible" content="IE=edge">
      <meta name='copyright' content=''>
      <meta http-equiv="X-UA-Compatible" content="IE=edge">
      <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
      <!-- Title Tag  -->
      <title>${detail.title} - Nhà sách Y Dược</title>
      <!-- Favicon -->
      <link rel="icon" type="image/png" href="images/favicon.png">
      <!-- Web Font -->
      <link href="https://fonts.googleapis.com/css?family=Poppins:200i,300,300i,400,400i,500,500i,600,600i,700,700i,800,800i,900,900i&display=swap" rel="stylesheet">
      <!-- StyleSheet -->
      <!-- Bootstrap -->
      <link rel="stylesheet" href="css/bootstrap.css">
      <!-- Magnific Popup -->
      <link rel="stylesheet" href="css/magnific-popup.min.css">
      <!-- Font Awesome -->
      <link rel="stylesheet" href="css/font-awesome.css">
      <!-- Fancybox -->
      <link rel="stylesheet" href="css/jquery.fancybox.min.css">
      <!-- Themify Icons -->
      <link rel="stylesheet" href="css/themify-icons.css">
      <!-- Jquery Ui -->
      <link rel="stylesheet" href="css/jquery-ui.css">
      <!-- Nice Select CSS -->
      <link rel="stylesheet" href="css/niceselect.css">
      <!-- Animate CSS -->
      <link rel="stylesheet" href="css/animate.css">
      <!-- Flex Slider CSS -->
      <link rel="stylesheet" href="css/flex-slider.min.css">
      <!-- Owl Carousel -->
      <link rel="stylesheet" href="css/owl-carousel.css">
      <!-- Slicknav -->
      <link rel="stylesheet" href="css/slicknav.min.css">
      <!-- Eshop StyleSheet -->
      <link rel="stylesheet" href="css/reset.css">
      <link rel="stylesheet" href="style.css">
      <link rel="stylesheet" href="css/responsive.css">
   </head>
   <body class="js">

      <!-- Header -->
      	<jsp:include page="header.jsp"></jsp:include>
      <!--/ End Header -->
      <!-- Product Style -->
      <section class="product-area shop-sidebar shop section">
         <div class="container">
            <div class="row">
               
               <!-- Start sidebar -->
					<jsp:include page="sidebar.jsp"></jsp:include>
				<!-- End Sidebar -->
               
               <div class="col-lg-9 col-md-8 col-12">
                  <!--Section: Block Content-->
                  <section class="mb-5">
                     <div class="row">
                        <div class="col-md-6 mb-4 mb-md-0">
                           <div id="mdb-lightbox-ui"></div>
                           <div class="mdb-lightbox">
                              <div class="row product-gallery mx-1">
                                 <div class="col-12 mb-0">
                                    <figure class="view overlay rounded z-depth-1 main-img">
                                       
                                       <img src="upload/${detail.image}"
                                          class="img-fluid z-depth-1">
                                    
                                    </figure>
                                 </div>
                            
                              </div>
                           </div>
                        </div>
                        <div class="col-md-6">
                           <h5>${detail.title}</h5><br>
                           <p class="mb-2 text-muted text-uppercase small">Tên sách: ${detail.pname}</p>
                       		<p class="mb-2 text-muted text-uppercase small">Tác giả: ${detail.author}</p>
                      
                           <p><span class="mr-1"><strong>Giá: ${detail.price}đ</strong></span></p>

                           <p class="pt-1">${detail.description}
                           </p>
                        
                           <hr>
                  			<div class="def-number-input number-input safari_only mb-0">
                      <button onclick="this.parentNode.querySelector('input[type=number]').stepDown()" class="minus"></button>
                      <input class="quantity" min="0" name="quantity" value="1" type="number">
                      <button onclick="this.parentNode.querySelector('input[type=number]').stepUp()" class="plus"></button>
                    		</div>
                    		<br>
                    		
                           <button type="button" class="btn btn-primary btn-md mr-1 mb-2"><a href="checkout">Thanh toán</a></button>
                           <button type="button" class="btn btn-light btn-md mr-1 mb-2">
                           <a title="Add to cart" href="addtocart?pid=${detail.pid}">Đặt hàng</a></button>
                        </div>
                     </div>
                  </section>
                  <!--Section: Block Content-->
                  <!-- Classic tabs -->
                  <div class="classic-tabs border rounded px-4 pt-1">
                     <ul class="nav tabs-primary nav-justified" id="advancedTab" role="tablist">
                        <li class="nav-item">
                           <a class="nav-link active show" id="description-tab" data-toggle="tab" href="#description" role="tab" aria-controls="description" aria-selected="true">Chi tiết</a>
                        </li>
                        
                        <li class="nav-item">
                           <a class="nav-link" id="reviews-tab" data-toggle="tab" href="#reviews" role="tab" aria-controls="reviews" aria-selected="false">Đánh giá (1)</a>
                        </li>
                     </ul>
                     <div class="tab-content" id="advancedTabContent">
                        <div class="tab-pane fade show active" id="description" role="tabpanel" aria-labelledby="description-tab">
                         
                           
                           <p class="pt-1">${detail.detail}
                           </p>
                        </div>
                   
                        <div class="tab-pane fade" id="reviews" role="tabpanel" aria-labelledby="reviews-tab">
                           <h5><span>1</span> đánh giá cho <span>Tên sách</span></h5>
                           <div class="media mt-3 mb-4">
                              <img class="d-flex mr-3 z-depth-1" src="https://mdbootstrap.com/img/Photos/Others/placeholder1.jpg" width="62" alt="Generic placeholder image">
                              <div class="media-body">
                                 <div class="d-sm-flex justify-content-between">
                                    <p class="mt-1 mb-2">
                                       <strong>Marthasteward </strong>
                                       <span>– </span><span> 28/05/2021</span>
                                    </p>
                                   <!--  <ul class="rating mb-sm-0">
                                       <li>
                                          <i class="fas fa-star fa-sm text-primary"></i>
                                       </li>
                                       <li>
                                          <i class="fas fa-star fa-sm text-primary"></i>
                                       </li>
                                       <li>
                                          <i class="fas fa-star fa-sm text-primary"></i>
                                       </li>
                                       <li>
                                          <i class="fas fa-star fa-sm text-primary"></i>
                                       </li>
                                       <li>
                                          <i class="far fa-star fa-sm text-primary"></i>
                                       </li>
                                    </ul> -->
                                 </div>
                                 <p class="mb-0">Nice one, love it!</p>
                              </div>
                           </div>
                           <hr>
                           <h5 class="mt-4">Thêm đánh giá</h5>
                       <!--     <div class="my-3">
                              <ul class="rating mb-0">
                                 <li>
                                    <a href="#!">
                                    <i class="fas fa-star fa-sm text-primary"></i>
                                    </a>
                                 </li>
                                 <li>
                                    <a href="#!">
                                    <i class="fas fa-star fa-sm text-primary"></i>
                                    </a>
                                 </li>
                                 <li>
                                    <a href="#!">
                                    <i class="fas fa-star fa-sm text-primary"></i>
                                    </a>
                                 </li>
                                 <li>
                                    <a href="#!">
                                    <i class="fas fa-star fa-sm text-primary"></i>
                                    </a>
                                 </li>
                                 <li>
                                    <a href="#!">
                                    <i class="far fa-star fa-sm text-primary"></i>
                                    </a>
                                 </li>
                              </ul>
                           </div> -->
                           <div>
                              <!-- Your review -->
                              <div class="md-form md-outline">
                                 <textarea id="form76" class="md-textarea form-control pr-6" rows="4"></textarea>
                                 <label for="form76">Đánh giá của bạn</label>
                              </div>
                              <!-- Name -->
                              <div class="md-form md-outline">
                                 <input type="text" id="form75" class="form-control pr-6">
                                 <label for="form75">Tên người dùng</label>
                              </div>
                              <!-- Email -->
                              <div class="md-form md-outline">
                                 <input type="email" id="form77" class="form-control pr-6">
                                 <label for="form77">Email</label>
                              </div>
                              <div class="text-right pb-2">
                                 <button type="button" class="btn btn-primary">Xác nhận</button>
                              </div>
                           </div>
                        </div>
                     </div>
                  </div>
                  <!-- Classic tabs -->
               </div>
            </div>
         </div>
      </section>
      <!--/ End Product Style 1  -->	
      <!-- Start Footer Area -->
      	<jsp:include page="footer.jsp"></jsp:include>
      <!-- /End Footer Area -->
      <!-- Jquery -->
      <script src="js/jquery.min.js"></script>
      <script src="js/jquery-migrate-3.0.0.js"></script>
      <script src="js/jquery-ui.min.js"></script>
      <!-- Popper JS -->
      <script src="js/popper.min.js"></script>
      <!-- Bootstrap JS -->
      <script src="js/bootstrap.min.js"></script>
      <!-- Color JS -->
      <script src="js/colors.js"></script>
      <!-- Slicknav JS -->
      <script src="js/slicknav.min.js"></script>
      <!-- Owl Carousel JS -->
      <script src="js/owl-carousel.js"></script>
      <!-- Magnific Popup JS -->
      <script src="js/magnific-popup.js"></script>
      <!-- Fancybox JS -->
      <script src="js/facnybox.min.js"></script>
      <!-- Waypoints JS -->
      <script src="js/waypoints.min.js"></script>
      <!-- Countdown JS -->
      <script src="js/finalcountdown.min.js"></script>
      <!-- Nice Select JS -->
      <script src="js/nicesellect.js"></script>
      <!-- Ytplayer JS -->
      <script src="js/ytplayer.min.js"></script>
      <!-- Flex Slider JS -->
      <script src="js/flex-slider.js"></script>
      <!-- ScrollUp JS -->
      <script src="js/scrollup.js"></script>
      <!-- Onepage Nav JS -->
      <script src="js/onepage-nav.min.js"></script>
      <!-- Easing JS -->
      <script src="js/easing.js"></script>
      <!-- Active JS -->
      <script src="js/active.js"></script>
   </body>
</html>