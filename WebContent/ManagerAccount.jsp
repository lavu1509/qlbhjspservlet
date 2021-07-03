
<%@page import="java.text.NumberFormat"%>
<%@page import="java.util.Locale"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Quản lý người dùng - Danh sách</title>
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
        <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <link href="css/manager.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="style.css">
        <style>
            img{
                width: 100px;
                height: 120px;
            }
        </style>
        <% Locale lc = new Locale("nv","VN");
           						NumberFormat nf = NumberFormat.getCurrencyInstance(lc);
           						%>
    <body>
    <header class="header shop">
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
    </header>
    
        <div class="container">
            <div class="table-wrapper">
                <div class="table-title">
                    <div class="row">
                        <div class="col-sm-6">
                            <h2>Quản lý <b>người dung </b></h2>
                        </div>
                        <div class="col-sm-6">
                            <a href="chuyen"  class="btn btn-success" ><i class="material-icons">&#xE147;</i> <span>Thêm mới</span></a>						
                        </div>
                    </div>
                </div>
                <table class="table table-striped table-hover">
                    <thead>
                        <tr>
                            <th>
                                <span class="custom-checkbox">
                                    <input type="checkbox" id="selectAll">
                                    <label for="selectAll"></label>
                                </span>
                            </th>
                            <th>ID</th>
                            <th>Username</th>
                            <th>Họ tên</th>
                            <th>Email</th>
                            <th>SĐT</th>
                            <th>Địa chỉ</th>
                            <th>IsSell</th>
                            <th>IsSell</th>
                            <th>Action</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${listac}" var="o">
                            <tr>
                                <td>
                                    <span class="custom-checkbox">
                                        <input type="checkbox" id="checkbox1" name="options[]" value="1">
                                        <label for="checkbox1"></label>
                                    </span>
                                </td>
                                
                                <td>${o.uid}</td>
                                <td>${o.username}</td>
                                <td>${o.fullname}</td>
                                
                                <td>${o.email}</td>
                                <td>${o.phone}</td>
                                <td>${o.address}</td>
                                <td>                    	
                                        <input type="checkbox" id="checkbox2" name="isSell" value="${o.isSell}" ${o.isSell == 1?"checked":""} >   
                                </td>
                                 <td>                              	
                                        <input type="checkbox" id="checkbox2" name="isAdmin" value="${o.isAdmin}" ${o.isAdmin == 1?"checked":""} >
                                </td>
                                <td>
                                    <a href="edit?uid=${o.uid}"  class="edit" data-toggle="modal"><i class="material-icons" data-toggle="tooltip" title="Edit">&#xE254;</i></a>
                                    <a href="delele?uid=${o.uid}" class="delete" data-toggle="modal"><i class="material-icons" data-toggle="tooltip" title="Delete">&#xE872;</i></a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
                <div class="clearfix">
                    <div class="hint-text">Hiển thị <b>5</b> trong <b>${count}</b></div>
                    <ul class="pagination">
                        <c:forEach begin="1" end="${end}" var="i">
                        <li class="page-item ${tag == i?"active":"" }"><a href="managerp?index=${i}" class="page-link">${i}</a></li>
                        </c:forEach>
                    </ul>
                </div>
            </div>
            <a href="home"><button type="button" class="btn btn-primary">Back to home</button>

        </div>
       
        
        
    <script src="js/manager.js" type="text/javascript"></script>
</body>
</html>