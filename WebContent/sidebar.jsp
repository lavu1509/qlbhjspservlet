<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="col-lg-3 col-md-4 col-12">
						<div class="shop-sidebar">
								<!-- Single Widget -->
								<div class="single-widget category">
									<h3 class="title">Danh mục</h3>
									<ul class="categor-list">
										<c:forEach items="${listc}" var="o">
											<li ><a class="${tagc==o.cid?"active":""}" href="category?cid=${o.cid}">${o.cname} </a></li>
										</c:forEach>
										
									</ul>
								</div>
								<!--/ End Single Widget -->
					
								<!-- Single Widget -->
								<div class="single-widget recent-post">
									<h3 class="title">Sách mới cập nhật</h3>
									
	
										<!-- Single Post -->
									<div class="single-post first">
										<div class="image">
											<img src="upload/${last.image}" alt="#">
										</div>
										<div class="content">
											<h5><a href="detail?pid=${last.pid}">${last.pname}</a></h5>
											<p class="price">
												<fmt:setLocale value="vi_VN"/>
                                				<fmt:formatNumber value="${last.price}" type="currency"/>
											</p>
										</div>
									</div>
									<!-- End Single Post -->
									
									
									
								</div>
								<!--/ End Single Widget -->
						</div>
					</div>