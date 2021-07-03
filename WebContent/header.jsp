<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<header class="header shop">
	<!-- Topbar -->
	<div class="topbar">
		<div class="container">
			<div class="row">
				<div class="col-lg-4 col-md-12 col-12">
					<!-- Top Left -->
					<div class="top-left">
						<ul class="list-main">
							<li><i class="ti-headphone-alt"></i> +84 772 444 555</li>
						</ul>
					</div>
					<!--/ End Top Left -->
				</div>
				<div class="col-lg-8 col-md-12 col-12">
					<!-- Top Right -->
					<div class="right-content">
						<ul class="list-main">
							<c:if test="${sessionScope.acc.isAdmin == 1}">
								<li class="nav-item"><a class="nav-link" href="managera">QL Account
										</a></li>
							</c:if>
							<c:if test="${sessionScope.acc.isAdmin == 1}">
								<li class="nav-item"><a class="nav-link" href="managerc">QL Category</a></li>
							</c:if>
							<c:if test="${sessionScope.acc.isAdmin == 1}">
								<li class="nav-item"><a class="nav-link" href="hoadon">QL Bill</a></li>
							</c:if>
							<c:if test="${sessionScope.acc.isSell == 1}">
								<li class="nav-item"><a class="nav-link" href="managerp">QL Product</a></li>
							</c:if>
							<c:if test="${sessionScope.acc != null}">
								<li class="nav-item"><a class="nav-link" href="#">Xin chào, 
										${sessionScope.acc.username}</a></li>
								<li class="nav-item"><a class="nav-link" href="logout">Đăng xuất</a>
								</li>
							</c:if>
							<c:if test="${sessionScope.acc == null}">
								<li class="nav-item"><a class="nav-link" href="login.jsp">Đăng nhập</a>
								</li>
							</c:if>
						</ul>
					</div>
					<!-- End Top Right -->
				</div>
			</div>
		</div>
	</div>
	<!-- End Topbar -->
	<div class="middle-inner">
		<div class="container">
			<div class="row">
				<div class="col-lg-2 col-md-2 col-12">
					<!-- Logo -->
					<div class="logo">
						<a href="home"><img src="upload/logo.png" alt="logo"></a>
					</div>
					<!--/ End Logo -->
					<!-- Search Form -->
					<div class="search-top">
						<div class="top-search">
							<a href="#0"><i class="ti-search"></i></a>
						</div>
						<!-- Search Form -->
						<div class="search-top">
							<form class="search-form">
								<input type="text" placeholder="Search here..." name="search">
								<button value="search" type="submit">
									<i class="ti-search"></i>
								</button>
							</form>
						</div>
						<!--/ End Search Form -->
					</div>
					<!--/ End Search Form -->
					<div class="mobile-nav"></div>
				</div>
				<div class="col-lg-8 col-md-7 col-12">
					<div class="search-bar-top">
						<div class="search-bar">

							<form action="search" method="post">
								<input name="searchtxt" placeholder="Nhập sách cần tìm ..."
									type="search">
								<button class="btnn">
									<i class="ti-search"></i>
								</button>
							</form>
						</div>
					</div>
				</div>
				<div class="col-lg-2 col-md-3 col-12">
					<div class="right-bar">
						<!-- Search Form -->
						<div class="sinlge-bar shopping">
							<!-- Shopping Item -->
							<a href="cart" class="single-icon"><i class="ti-bag"></i></a>
							<!--/ End Shopping Item -->
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- Header Inner -->
	<div class="header-inner">
		<div class="container">
			<div class="cat-nav-head">
				<div class="row">
					<div class="col-12">
						<div class="menu-area">
							<!-- Main Menu -->
							<nav class="navbar navbar-expand-lg">
								<div class="navbar-collapse">
									<div class="nav-inner">
										<ul class="nav main-menu menu navbar-nav">
											<li class="active"><a href="home">Trang chủ</a></li>
											<li><a href="#">Liên hệ</a></li>
											<li><a href="#">Giới thiệu</a></li>
										</ul>
									</div>
								</div>
							</nav>
							<!--/ End Main Menu -->
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!--/ End Header Inner -->
</header>